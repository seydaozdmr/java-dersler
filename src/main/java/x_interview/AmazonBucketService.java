package x_interview;

// Amazon S3 servisini kullanmak için gerekli bağımlılıkları ekleyin
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class AmazonBucketService {
    // Amazon S3 servisiyle iletişim kurmak için gerekli ayarları tanımlayın
    private static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
    private static final String SECRET_KEY = "YOUR_SECRET_KEY";
    private static final Regions REGION = Regions.US_EAST_1;

    // Amazon S3 servisini kullanmak için bir nesne oluşturun
    private static final AmazonS3 s3 = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
            .withRegion(REGION)
            .build();

    public static void main(String[] args) {
        // Örnek bir dosya yükleyelim
        s3.putObject("my-bucket", "my-file.txt", new File("/path/to/my-file.txt"));

        // Örnek bir dosya indirelim
        s3.getObject("my-bucket", "my-file.txt");
    }
}

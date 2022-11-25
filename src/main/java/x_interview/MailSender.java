package x_interview;

import java.util.function.Supplier;

public class MailSender {
    public Service service=new Service();

    public void send(Supplier<Dto> source){
        EmailDto emailDto =(EmailDto) source.get();
        //burada emailDto'ya bişeyler eklenebilir
        service.send(source.get());
    }
}

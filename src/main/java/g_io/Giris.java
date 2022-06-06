package g_io;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Giris {
    /**
     *  java.io API to interact with files
     * and streams. We start by describing how files and directories are
     * organized within a file system and show how to access them with the
     * java.io.File class. We then show how to read and write file data
     * with the stream classes.
     */

    /**
     * When we refer to streams in this chapter, we are referring to the
     * I/O streams found in the java.io API (unless otherwise
     * specified). I/O streams are completely unrelated to the streams
     * you saw in Chapter 15, “Functional Programming.” We agree
     * that the naming can be a bit confusing!
     */
    /**
     * When working with directories in Java, we
     * often treat them like files. In fact, we use many of the same classes to
     * operate on files and directories. For example, a file and directory both
     * can be renamed with the same Java method.
     */

    /**
     * To interact with files, we need to connect to the file system. The file
     * system is in charge of reading and writing data within a computer.
     */

    /**
     * JVM creates connection file system.
     * Next, the root directory is the topmost directory in the file system,
     * from which all files and directories inherit. In Windows, it is denoted
     * with a drive name such as c:\, while on Linux it is denoted with a
     * single forward slash, /.
     */

    /**
     * Finally, a path is a String representation of a file or directory within
     * a file system.
     */

    public static void main(String[] args) {
        /**
         * The first class that we will discuss is one of the most commonly used
         * in the java.io API: the java.io.File class. The File class is used
         * to read information about existing files and directories, list the
         * contents of a directory, and create/delete files and directories.
         */
//
//        File file=new File("test.txt");
//        /**
//         * The File class cannot read or write data
//         * within a file, although it can be passed as a reference to many stream
//         * classes to read or write data, as you will see in the next section.
//         */
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
//
//        File parent=new File("C:\\Users\\seyda\\Documents\\java-dersler");
//        File child = new File("\\test.txt");
//
//        File result = new File(parent,child.toString());
//        File result2 = new File(parent,"\\test.txt");
//        System.out.println(result.exists());
//        System.out.println(result.getParent());
//        System.out.println(System.getProperty("file.separator"));
//
//        File [] myroute = new File ("C:\\Users\\seyda").listFiles();
        //Arrays.stream(myroute).filter(File::isFile).map(e->e.getName()).forEach(System.out::println);

        File classpath=new File("test");
        System.out.println(classpath.getAbsolutePath());
        classpath.mkdir();

        File C= new File("C:\\test");
        if (!C.exists()){
            C.mkdir();
        }
        else{
            System.out.println("klasör var");
        }

        File example=new File("mytest.txt");
        try {
            if(!example.exists())
                example.createNewFile();
            else
                System.out.println("bu dosya daha önce oluşturulmuş");
            //Dosya işlemlerin excepitonları yönetmek oldukça önemli
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(file.exists());
//
//
//        /**
//         * The absolute path of a file or directory is the full path from the root
//         * directory to the file or directory, including all subdirectories that
//         * contain the file or directory. Alternatively, the relative path of a file
//         * or directory is the path from the current working directory to the file
//         * or directory.
//         */
//
//        System.out.println(file.getAbsolutePath());
//
//        System.out.println(System.getProperty("file.separator"));
//
//        File parent = new File("C:\\Users\\seyda\\Documents\\java-dersler\\");
//        File currentFile=new File(parent,"src\\main\\java\\g_io\\test.txt");
//        System.out.println(currentFile.getAbsolutePath());
//        System.out.println(currentFile.exists());
//
//        //dizini yazdır
//        File[] listFiles = new File("C:\\").listFiles();
//        Arrays.stream(listFiles).forEach(e->System.out.println(e.getName()));
//
//        File currentDirectory=new File(parent,"src\\main\\java\\g_id\\test");
//        System.out.println(currentDirectory.mkdir());
//
//        /**
//         * In these examples, you see that the output of an I/O‐based program is
//         * completely dependent on the directories and files available at runtime
//         * in the underlying file system.
//         * On the exam, you might get paths that look like files but are
//         * directories, or vice versa. For example, /data/zoo.txt could be a
//         * file or a directory, even though it has a file extension. Don't assume it
//         * is either unless the question tells you it is!
//         */
//
//
    }

}

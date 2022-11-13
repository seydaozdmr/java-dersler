package g_io.basics;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class UsingFile {
    /**
     * An instance of the File class contains an abstract representation of
     * a file or directory path (a compact map that locates and identifies a file system object).
     */
    public static void main(String[] args) throws IOException {
        //making new directory
//        System.out.println(new File("test").mkdir());
//        new File("test/test.txt").createNewFile();

//        System.out.println(new File("").getAbsolutePath());
//        File test = new File("");
//        File newPath = new File(test.getAbsolutePath(),"src/main/java/g_io/basics");
//        System.out.println(newPath.getAbsolutePath());
//        File myDirectory = new File(newPath,"test");
//        if(myDirectory.exists()){
//            System.out.println("This directory already created");
//        }else{
//            myDirectory.mkdir();
//            System.out.println("directory created");
//        }
//
//        File newTestFile = new File(myDirectory,"test.txt"); //path
//        String path = newTestFile.getPath();
//        System.out.println(path);
//
//        if(!newTestFile.exists()){
//            newTestFile.createNewFile();
//            System.out.println("file created");
//        }else
//            System.out.println("File exist");

//        File dummy = new File("Deneme");
//        System.out.println(dummy.getAbsolutePath());
//        dummy.mkdir();

//        File myPath = new File("src/main/java");
//        System.out.println(myPath.getAbsolutePath());
//        System.out.println(myPath.getPath());
        //C://Users/asd/Desktop --> absolutePath
        //../test/test1
//        File file1= new File("C:\\temp");
//        file1.mkdir();
//        System.out.println(file1.isFile());
//        System.out.println(file1.isDirectory());
//
//        File file2=new File("/test");
//        file2.mkdir();
//        System.out.println(file2.isDirectory());
//

//        File rootDir = File.listRoots()[0];
//        System.out.println(rootDir.getPath());
//        File dir = new File(new File(new File(rootDir, "Users"), "seydaozdemir"), "Desktop");
//        File myDirectory = new File(dir,"/test");
//        myDirectory.mkdir();
//
//        System.out.println(dir);
////        if (!dir.exists()){
////            dir.mkdirs();
////        }
//
        System.out.println(File.separatorChar);

        File here = new File("src\\main\\java\\g_io\\basics");

        File projectDirectory = new File(new File("").getAbsolutePath(),"Deneme"+File.separator+"12112022");
        System.out.println(projectDirectory.getAbsolutePath());
//        System.out.println(here.getAbsolutePath());
//        File createHere= new File(here,"test");
//        createHere.mkdir();
//        System.out.println(createHere.getCanonicalPath());
//
//        File[] roots = File.listRoots();
//        for (File root: roots)
//        {
//            System.out.println("Partition: " + root);
//            System.out.println("Free space on this partition = " +
//                    root.getFreeSpace());
//            System.out.println("Usable space on this partition = " +
//                    root.getUsableSpace());
//            System.out.println("Total space on this partition = " +
//                    root.getTotalSpace());
//            System.out.println("***");
//        }
//
//        String[] files = here.list();
//        Arrays.stream(files).forEach(System.out::println);
//
//        //printFiles(dir,0);
//
//        System.out.println(System.getProperty("java.io.tmpdir"));
//        File temp = File.createTempFile("text", ".txt");
//        System.out.println(temp);
//        temp.deleteOnExit();

    }

    private static void printFiles(File directory,int dept){
        File [] elems=directory.listFiles();
        for(File elem:elems){
            if(elem.isDirectory()){
                dept++;
                printFiles(elem,dept);
            }
            System.out.printf("%4s %n",elem.getName());
        }
    }
}

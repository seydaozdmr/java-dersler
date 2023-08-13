package f_exceptions.hierarcy;

public class TestCase {
    public static void main(String[] args) throws Exception{
        try{
            System.out.println("exception 1");
            throw new MyException1("myexception 1");
        }catch (Exception e){
            System.out.println("exception catch 1");
            throw new MyException2("myexception 2");
        }finally {
            System.out.println("exception finally 1");
            throw new Exception("myexception 1");
        }
    }
}

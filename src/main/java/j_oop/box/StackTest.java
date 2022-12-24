package j_oop.box;

public class StackTest {
    public static void main(String[] args) {
        Stack stack=new Stack(10);
        for(int i=0;i<11;i++){
            stack.push(i);
        }

        for(int i=0;i<11;i++){
            System.out.println(stack.pop());
        }
    }
}

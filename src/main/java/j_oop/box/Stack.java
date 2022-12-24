package j_oop.box;

public class Stack {
    private int [] stack;
    private int index;

    public Stack(int capacity) {
        stack=new int[capacity];
        index=0;
    }

    public void push(int val){
        if(index>=stack.length)
            System.out.println("stack kapasitesi dolu");
        else
            this.stack[index++]=val;
    }

    public int pop(){
        if(index<=0){
            System.out.println("stack tükendi");
            return -1;
        }else
            return stack[--index];
    }
}

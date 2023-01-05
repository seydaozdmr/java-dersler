package l_concurrency.suspend_resume;

public class NewThread implements Runnable{
    private String name;
    private Thread t;
    private boolean suspendFlag;

    public NewThread(String name) {
        this.name = name;
        t=new Thread(this,name);
        System.out.println("New Thread :"+t);
        suspendFlag=false;
    }

    @Override
    public void run() {
        try{
            for(int i=15;i>0;i--){
                System.out.println(name+" :"+i);
                Thread.sleep(200);
                synchronized (this){
                    while(suspendFlag){
                        System.out.println("suspend operation working");
                        wait(); //wait durumda olan thread'i notify ediyor.
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name+" interrupted.");
        }
        System.out.println(" exiting..");
    }

    synchronized void mySuspend(){
        suspendFlag=true;
    }

    synchronized void myResume(){
        suspendFlag=false;
        notify();
    }

    public void startThread(){
        this.t.start();
    }

    public void joinThread(){
        System.out.println("Waiting for threads to finish."+Thread.currentThread().getName());
        try {
            this.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getThreadState(){
        return this.t.getState().name();
    }
}

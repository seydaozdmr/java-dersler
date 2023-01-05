package l_concurrency.suspend_resume;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        System.out.println("Thread State : "+ob1.getThreadState());
        ob1.startThread(); // Start the thread
        ob2.startThread(); // Start the thread
        System.out.println("Thread State : "+ob1.getThreadState());
        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resuming thread One");
            ob2.mySuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Waiting for threads to finish."+Thread.currentThread().getName());
        ob1.joinThread();
        ob2.joinThread();

        System.out.println("Main thread exiting.");
    }
}

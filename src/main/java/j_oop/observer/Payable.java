package j_oop.observer;

public interface Payable {
    void pay();

    public static class Implementation implements Payable{
        private PaymentObserver paymentObserver;
        public void addObserver(PaymentObserver observer){
            this.paymentObserver=observer;
        }
        public void pay(){
            paymentObserver.amPaying(this);
        }
    }
}

package j_oop.observer;

public class AccountPayable implements PaymentObserver{
    private static AccountPayable instance = new AccountPayable();

    static AccountPayable getInstance(){
        return instance;
    }
    //aldığı interface'in pay methodunu çağırdı (ki içine concrete sınıf gelecek)
    public void amPaying(Payable employee){
        employee.pay();
    }


}

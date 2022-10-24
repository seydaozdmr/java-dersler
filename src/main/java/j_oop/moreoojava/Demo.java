package j_oop.moreoojava;

import java.math.BigDecimal;

public class Demo {
    private boolean isHappyHour;

    private Money reserve(Money cost){
        Money finalCost = this.isHappyHour ? cost.scale(0.5) : cost;
        System.out.println("Reserving an item costing : "+finalCost);
        return finalCost;
    }

    private void buy(Money wallet, Money cost){
        boolean enoughMoney = wallet.compareTo(cost)>=0;

        Money finalCost =reserve(cost);
        boolean finalEnoughMoney = wallet.compareTo(finalCost)>=0;

        if(finalEnoughMoney && !enoughMoney){
            System.out.println("Only this time you pay :"+finalCost+" with your :"+wallet);
        }
        else if(enoughMoney){
            System.out.println("You will pay :"+finalCost+" with your :"+wallet);
        }else{
            System.out.println("You cannot pay :"+finalCost+" with your :"+wallet);
        }

    }

    public static void main(String[] args) {
        Currency usd = new Currency("USD");

        Money usd12=new Money(new BigDecimal(12),usd);
        Money usd10=new Money(new BigDecimal(10),usd);
        Money usd7 =new Money(new BigDecimal(7),usd);
        Demo demo =new Demo();
        demo.buy(usd12,usd7);

        demo.isHappyHour=true;
        demo.buy(usd7,usd10);

    }
}

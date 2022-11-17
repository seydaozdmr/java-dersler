package Basics;

public class Course {
    String name; //attribute
    int credits;

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        if(name.isEmpty())
            System.out.println("giriş yaptığınız değer boş");
        else
            this.name = name;
    }

    public int getCredits() {
        if(this.credits==0)
            System.out.println("istenen kredi değeri henüz girilmemiştir...");
        return credits;
    }

    public void setCredits(int credits) {
        if(credits<=0)
            System.out.println("girilen kredi değeri 0'dan büyük olmalı");
        else
            this.credits = credits;
    }
}

package j_oop.nested;

public class Car {
    static int maxSpeed=220;
    int maxSpeed2=220;
    private static class Door{
        int numberOfDoor=4;
        static String description="dummy data";
        void maxSpeed(){
            System.out.println(maxSpeed);
        }
    }

    public class Sase{
        int maxSpeed2=120;
        void print(){
            System.out.println(new Door().numberOfDoor); //instance
            System.out.println(Door.description); //static
            System.out.println(maxSpeed);

        }
        void write(){
            Tears t=new Tears() {
                @Override
                int numberOfTears() {
                    return 4;
                }
            };
            System.out.println(t.numberOfTears());
        }
    }

    static abstract class Tears{
        abstract int numberOfTears();
    }


}

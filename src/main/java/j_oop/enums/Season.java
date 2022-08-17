package j_oop.enums;

public enum Season {
    WINTER(1),SPRING(2),SUMMER(3),FALL(4);

    int count;

    private Season(int c){
        this.count=c;
    }

    public int getCount(){
        return this.count;
    }

}

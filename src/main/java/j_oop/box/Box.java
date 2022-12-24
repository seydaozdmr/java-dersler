package j_oop.box;

public class Box {
    double width;
    double height;
    double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(double len){
        this(len,len,len);
    }


    public void calculateVolume(){
        System.out.println(width*height*depth);
    }
}

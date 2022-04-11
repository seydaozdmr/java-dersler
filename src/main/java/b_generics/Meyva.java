package b_generics;

public interface Meyva extends Urun{
    void sat();

    default Class getCategoryType(){
        return Meyva.class;
    }

}

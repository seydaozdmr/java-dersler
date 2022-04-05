package b_basic;

public interface Meyva extends Urun{
    void sat();
    default Class getCategoryType(){
        return Meyva.class;
    }

}

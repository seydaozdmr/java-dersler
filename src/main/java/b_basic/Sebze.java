package b_basic;

public interface Sebze extends Urun{
    int dayaniklilikSuresi();
    default Class getCategoryType(){
        return Sebze.class;
    }
}

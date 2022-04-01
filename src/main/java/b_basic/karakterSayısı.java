package b_basic;

public class karakterSayısı <T extends String, R extends Integer> {

    T ısım;
    R karakterSayısı;

    public karakterSayısı(T ısım) {
        this.ısım = ısım;
    }

    public R karakterSayısı(){
        return (R) Integer.valueOf(ısım.length());
    }
}

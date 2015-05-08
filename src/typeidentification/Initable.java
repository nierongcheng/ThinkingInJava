package typeidentification;

public class Initable {

    public static final int staticFinal = 47;
    public static int staticNotFinal = 147;

    static {
        System.out.println("Initializing Initable");
    }
    
    public Initable() {
        System.out.println("new Initable");
    }
}
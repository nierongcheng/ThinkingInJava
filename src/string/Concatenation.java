package string;

import innerclass.ControlMode;

public class Concatenation {

    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + "47";
        System.out.println(s);
        System.out.println(Boolean.TYPE);
        try {
            Class<Concatenation> class1 = (Class<Concatenation>) Class.forName("string.Concatenation");
            System.out.println(class1.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return "this is Concatenation";
    }
    
    public void print() {
        System.out.println("this is Concatenation");
    }
    
}

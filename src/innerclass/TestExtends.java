package innerclass;

import innerclass.TestExtends.Egg2.Yolk;

/**
 * @author  作者 E-mail: Codi, nierc@gionee.com
 * @date 创建时间: 2015年4月17日 上午8:32:12
 * @version 1.0 
 */
public class TestExtends {

    class Egg2 {

        public Egg2() {
            System.out.println("new Egg2");
        }
        
        protected class Yolk {
            public Yolk() {
                System.out.println("Egg2.Yolk()");
            }
        }
        
    }
    
    class InheritInner extends Egg2.Yolk {
        public InheritInner(Egg2 egg2) {
            egg2.super();  // 必须调用
        }
    }
    
    class BigEgg2 extends Egg2 {

        public BigEgg2() {
            System.out.println("new BigEgg2");
        }
        
        public BigEgg2(String name) {
            System.out.println("new BigEgg2 " + name);
        }
        
    }
    
    
    public static void main(String[] args) {
        TestExtends testExtends = new TestExtends();
        Egg2 egg2 = testExtends.new BigEgg2("haha");
    }
}

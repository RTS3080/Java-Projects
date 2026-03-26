public class interfaceTest {
    interface A{
        default int go(){
            return 1;
        }
    }
    abstract class B{
        public int go(){
            return 2;
        };
    }
    class C extends B implements A{
        public int go(){
            return 3;
        }
    }

}

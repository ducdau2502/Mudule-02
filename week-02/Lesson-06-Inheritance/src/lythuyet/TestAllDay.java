package lythuyet;

public class TestAllDay {
    public static void main(String[] args) {
        A a = new A();
        a.p(10);
        a.p(10.0);
    }


    static class A extends B {
        @Override
        public void p(double number) {
            System.out.println(number);
        }
    }

    static class B {
        public void p(double number) {
            System.out.println(number * 2);
        }
    }
}

package foobar;

public class Application {
    public static void main(String[] args) {

        final RunnableThread foo = new RunnableThread("foo");


        FooBar fooBar = FooBar.getInstance(Integer.valueOf(4));
        try {
            new Thread(new Runnable() {

                public void run() {
                    FooBar fooBar = FooBar.getInstance(Integer.valueOf(4));
                    RunnableThread bar = new RunnableThread("bar");
                    try {
                        fooBar.bar(bar);//.bar(bar);
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }


                }
            }).start();
            System.out.println("heer");
            new Thread(new Runnable() {

                public void run() {
                    FooBar fooBar = FooBar.getInstance(Integer.valueOf(4));
                    RunnableThread foo = new RunnableThread("foo");
                    try {
                        fooBar.foo(foo);//.bar(bar);
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }


                }
            }).start();
            System.out.println("end");

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }
}

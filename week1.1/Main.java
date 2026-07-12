public class Main {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application Running");

        System.out.println("Same Instance: " + (logger1 == logger2));
    }
}
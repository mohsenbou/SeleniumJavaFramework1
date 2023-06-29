public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        try {
            demo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        try {
//
//        }
//        catch (Exception exp){
//            System.out.println("I am inside catch block");
//            System.out.println(exp.getMessage());
//            System.out.println(exp.getCause());
//            exp.printStackTrace();
//        }
//        finally {
//            System.out.println("I am inside finally block");
//        }
    }

    public static void demo() throws Exception{
        System.out.println("Hello world...!");
        throw new ArithmeticException("not valid opertion");
//        int i = 1/0;
//        System.out.println("Completed");
    }
}

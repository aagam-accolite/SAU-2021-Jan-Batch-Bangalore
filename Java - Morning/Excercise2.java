import java.util.*;

public class Excercise2 {

    public static int division(int a, int b) throws ArithmeticException
    {
        if(b == 0)
        {
            throw new ArithmeticException("Cannot Divide Number by Zero");
        }
        return a/b;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : a , b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            int res = a / b;
            System.out.println(res);
        }   
        catch(ArithmeticException e)
        {
            System.out.println("Artithmetic Exception Occured : Cannot Divide by Zero");
        }
        finally{
            try{
                System.out.println("Enter the Number Again : a , b");
                a = sc.nextInt();
                b = sc.nextInt();
                int result = a / b;
                System.out.println(result);
            }
            catch(ArithmeticException k) {
                System.out.println(k);	
            }
        }
        sc.close();
    }    
}

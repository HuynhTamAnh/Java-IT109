package bt1;

public class Main {
    public static void main(String[] args) {
        int num1=5;
        int num2=10;
        int calculation=calculateExpression(num1,num2);
        System.out.println("The calculation of the expression is: "+calculation);
    }
    public static int calculateExpression(int num1, int num2) {
        return num1*num2+(num1+num2);
    }
}

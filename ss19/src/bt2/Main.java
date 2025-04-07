package bt2;

import java.util.function.Function;

//Sử dụng Function để biểu diễn hàm số f(x) = x^2 + 3x + 2.
//
//Khai báo Function<Integer, Integer> để tính giá trị của hàm số
//In kết quả của f(1), f(2), f(3)
public class Main {
    public static void main(String[] args) {
        //f(x) = x^2 + 3x + 2
        Function<Integer, Integer> f = x -> x * x + 3 * x + 2;
        System.out.println("F(1) = " + f.apply(1));
        System.out.println("F(2) = " + f.apply(2));
        System.out.println("F(3) = " + f.apply(3));
    }
}

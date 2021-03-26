import static service.Services.computeFactorial;
import static service.Services.concatenateWords;

public class Main {
    public static void main(String[] args) {
        System.out.println(concatenateWords("Hello", "world!"));
        System.out.println(computeFactorial(21));
    }
}

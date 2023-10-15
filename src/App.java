import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) throws Exception {
        runConsumerExample();
    }

    /*
     * Consumer<T>
     * Used for actions or side effects on elements without modifying then
     */
    static void runConsumerExample() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> printNumbers = number -> {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        };
        numbers.forEach(printNumbers);
    }
}

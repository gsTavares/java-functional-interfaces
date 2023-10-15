import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        runConsumerExample();
        runSupplierExample();
    }

    /*
     * Consumer<T>
     * Used for actions or side effects on elements without modifying then
     */
    static void runConsumerExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> printNumbers = number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        };
        numbers.forEach(printNumbers);
    }

    /*
     * Supplier<T>
     * Doesn't accept any arguments and retuns an T object. Commom used for creating
     * new objects
     */
    static void runSupplierExample() {
        Supplier<String> greetings = () -> "Hello, be welcome!";

        // Generating a list using greetings supplier
        List<String> greetingsList = Stream.generate(greetings)
                .limit(5)
                .toList();
        greetingsList.forEach(System.out::println);
    }
}

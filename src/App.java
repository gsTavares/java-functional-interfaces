import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        runConsumerExample();
        runSupplierExample();
        runFunctionExample();
        runPredicateExample();
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

    /*
     * Function<T, R>
     * Receives a T argument and returns the R argument. Used object transforming or
     * mapping
     */
    static void runFunctionExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Function<Integer, Integer> multiplyBy2 = number -> number * 2;
        List<Integer> doubledValues = numbers.stream().map(multiplyBy2).toList();
        doubledValues.forEach(System.out::println);
    }

    /*
     * Predicate<T>
     * Receives a T argumnet and returns a boolean value (true or false). Commom
     * used for filtering operations
     */
    static void runPredicateExample() {
        List<String> words = Arrays.asList("java", "kotlin", "phyton", "javascript", "c", "go", "ruby");
        Predicate<String> moreThanFiveChars = word -> word.length() > 5;
        words.stream().filter(moreThanFiveChars).forEach(System.out::println);
    }
}

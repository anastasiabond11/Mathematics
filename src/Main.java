import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    @FunctionalInterface
    interface StringManipulator {
        String manipulate(String s);
    }

    static class StringListProcessor {
        public static int countUppercase(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    static class RandomNumberGenerator {
        public static int generateRandomNumber(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min + 1) + min;
        }
    }

    public static void main(String[] args) {
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        int resultAddition = addition.operate(10, 15);
        System.out.println("Результат додавання: " + resultAddition);

        StringManipulator toUpperCase = s -> s.toUpperCase();

        String upperCaseResult = toUpperCase.manipulate("hello world");
        System.out.println("Рядок у верхньому регістрі: " + upperCaseResult);

        Function<String, Integer> countUppercaseFunction = StringListProcessor::countUppercase;

        int uppercaseCount = countUppercaseFunction.apply("Hello World");
        System.out.println("Кількість великих літер: " + uppercaseCount);

        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);

        int randomNumber = randomSupplier.get();
        System.out.println("Випадкове число: " + randomNumber);
    }
}

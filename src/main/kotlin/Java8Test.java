import java.util.Arrays;
import java.util.List;

/**
 * Java 在一个拥有两个方法（不含默认方法）的接口中，是不可以使用 Lambda 表达式的，
 * 当一个接口中只有一个抽象方法，即达成了SAM（Single Abstract Method）条件时，Lambda表达式才可以使用
 *
 */
public class Java8Test {

    public static void main(String[] args) {
        Java8Test java8Test = new Java8Test();
        java8Test.lambdaDemo();

    }

    public void filter(Filter f, List<Integer> integerList) {
        for (Integer i : integerList) {
            if (f.test(i)) {
                System.out.println(i);
            }
        }
    }
    // 定义一个 SAM
    interface Filter {
        boolean test(int x);
    }

    public void lambdaDemo() {
        filter((x) -> x % 2 == 1, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }
}

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java-8 IntStream is a replacement for traditional loop.
 */
public class Java_IntStream {
    public static void main(String[] args) {
        /*
          Creating IntStream
         */
        //  1. IntStream.of();
        IntStream.of(1).forEach(System.out::print);   //1
        IntStream.of(1,2,3,4,5).forEach(System.out::print);   //12345

        //  2. Arrays.Stream(int[])
        Arrays.stream(new int[]{1,2,3,4,5}).forEach(System.out::print); // 12345

        //  End Exclusive
        IntStream.range(1,5).forEach(System.out::print);    // 1234

        //  End Inclusive
        IntStream.rangeClosed(1,5).forEach(System.out::print);  // 12345

        // It will start with 0 and keep on creating new element by adding 2
        IntStream.iterate(0, i->i+2).limit(5).forEach(System.out::print);

        // Takes IntSupplier
        IntStream.generate( ()-> ThreadLocalRandom.current().nextInt()).limit(5).forEach(System.out::println);


        /*
          Working with IntStream
         */

        // Using Map
        IntStream.rangeClosed(1,10)
                .map(i->i*i)
                .forEach(System.out::print); // 1 4 9 16 25 36 49 64 81 100

        // Using Filter
        IntStream.rangeClosed(1,10)
                .filter(i->i%2==0)
                .forEach(System.out::print); // 2 4 6 8 10


        // If you don't want the IntStream but a Stream use .boxed()
        Stream<Integer> boxed = IntStream.rangeClosed(1, 10).boxed();

        // Returns an object-valued Stream consisting of the results of applying the given function to the elements of this stream
        Stream<String> stringStream = IntStream.rangeClosed(1, 10).mapToObj(i -> "" + i);
    }
}

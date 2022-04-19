package il.vgoudk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiThreadedFizzBuzzTest {


    List<String> log = new ArrayList<>();

    @ParameterizedTest
    @ValueSource( ints = {1,9,10,11,12})
    public void shouldWork( int max) throws Exception {

        System.out.print( max+":  ");
        MultiThreadedFizzBuzz multiThreadedFizzBuzz = new MultiThreadedFizzBuzz(max);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    multiThreadedFizzBuzz.fizz(new Printer("Fizz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    multiThreadedFizzBuzz.buzz(new Printer("Buzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    multiThreadedFizzBuzz.fizzbuzz(new Printer("MultiThreadedFizzBuzz"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C");

        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    multiThreadedFizzBuzz.number(new MultiThreadedFizzBuzzTest.Consumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D");

        a.start();
        b.start();
        c.start();
        d.start();

        a.join();
        b.join();
        c.join();
        d.join();

        System.out.println(log);
        assertEquals(max, log.size(),"Diff: "+(log.size() - max));

    }

    private class Printer implements Runnable {
        final String output;

        public Printer(String output) {
            this.output = output;
        }

        @Override
        public void run() {
            log.add(output);
        }
    }

    private class Consumer implements IntConsumer {
        @Override
        public void accept(int value) {
            log.add(String.valueOf(value));
        }
    }
}
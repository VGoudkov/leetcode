package il.vgoudk;

import java.util.function.IntConsumer;

class MultiThreadedFizzBuzz {
    private int n;
    private volatile int i = 1;

    public MultiThreadedFizzBuzz(int n) {
        this.n = n;
    }

    private static Mode getMode(int current) {
        boolean isFizz = current % 3 == 0;
        boolean isBuzz = current % 5 == 0;

        if (isFizz && isBuzz) return Mode.FIZZBUZZ;
        else if (isFizz) return Mode.FIZZ;
        else if (isBuzz) return Mode.BUZZ;
        else return Mode.NUMBER;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (i > n) break;
                if (getMode(i) == Mode.FIZZ) {
                    printFizz.run();
                    ++i;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (i > n) break;
                if (getMode(i) == Mode.BUZZ) {
                    printBuzz.run();
                    ++i;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (i > n) break;
                if (getMode(i) == Mode.FIZZBUZZ) {
                    printFizzBuzz.run();
                    ++i;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (i > n) break;
                if (getMode(i) == Mode.NUMBER) {
                    printNumber.accept(i);
                    ++i;
                }
            }
        }
    }

    private enum Mode {
        FIZZ, BUZZ, FIZZBUZZ, NUMBER
    }
}
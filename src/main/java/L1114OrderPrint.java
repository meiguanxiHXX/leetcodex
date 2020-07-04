import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class L1114OrderPrint {

  static class Foo {

    private int order = 1;
    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
      lock.lock();
      try {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        order++;
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }

    public void second(Runnable printSecond) throws InterruptedException {
      lock.lock();
      try {
        while (order != 2) {
          condition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        order++;
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }

    public void third(Runnable printThird) throws InterruptedException {
      lock.lock();
      try {
        while (order != 3) {
          condition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Foo foo = new Foo();
    Runnable r1 = () -> System.out.println(1);
    Runnable r2 = () -> System.out.println(2);
    Runnable r3 = () -> System.out.println(3);

    Thread t1 = new Thread(() -> {
      try {
        foo.first(r1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        foo.second(r2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t3 = new Thread(() -> {
      try {
        foo.third(r3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t3.start();
    t2.start();
    t1.start();

    t1.join();
    t2.join();
    t3.join();
  }

}

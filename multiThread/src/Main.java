public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter(0);
        Thread t1 = new Thread(new MyThread(count));
        t1.start();
        Thread t2 = new Thread(new MyThread(count));
        t2.start();
        Thread t3 = new Thread(new MyThread(count));
        t3.start();
        Thread t4 = new Thread(new MyThread(count));
        t4.start();


        Thread.sleep(20000);
//        Thread t2 = new Thread(new )
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println(count.getC());
        System.out.println("!!!");
//        t1.interrupt();
    }
}

class Counter{
    private int c;

    public Counter(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}


class MyThread implements Runnable {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            counter.setC(counter.getC()+1);
        }
    }

    private void sleep2sec () throws InterruptedException {
        Thread.sleep(2000);
    }
}

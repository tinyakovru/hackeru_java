public class Main {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        PingPongThread t1 = new PingPongThread("Ping", q);
        PingPongThread t2 = new PingPongThread("Pong", q);

        try {
            t1.join();
            //t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


class MyQueue {
    boolean flag;

    public synchronized void ping() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("ping");
        flag = true;
        try {
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        notify();
    }

    public synchronized void pong() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("PONG");
        flag = false;
        try {
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        notify();
    }
}

class PingPongThread extends Thread {
    MyQueue q;
    String str;

    public PingPongThread(String str, MyQueue q) {
        super();
        this.str = str;
        this.q = q;
        start();
    }

    @Override
    public void run() {
        while (true)
            try {
//                System.out.println(str);
                if (str == "Ping")
                    q.ping();
                else if (str == "Pong")
                    q.pong();
                else{
                    throw new Exception("Error Queue work");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}


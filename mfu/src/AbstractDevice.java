import java.util.Queue;

public abstract class AbstractDevice implements Runnable {

    protected Thread t;
    protected Queue<Task> q;

    public AbstractDevice() {
        t = new Thread(this);
    }

    public Thread getT() {
        return t;
    }

    @Override
    public void run() {
        System.out.println("thread starts");
        while (true) {
            //System.out.println("while ");
            Task task = q.poll();

            if (task != null) {
                work(task);
            } else {
                try {
                    t.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract void work(Task task);

    public void setQueue(Queue<Task> q) {
        System.out.println("set queue " + this.toString() + "  " + t.getState());
        this.q = q;
        t.start();
        System.out.println(" t state:  " + t.getState());

    }
}

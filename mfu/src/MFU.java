import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MFU {

    MyScan sc;
    Printer pr;
    Queue<Task> qp;
    Queue<Task> qs;

    public MFU(MyScan sc, Printer pr) {
        this.sc = sc;
        this.pr = pr;
        qp = new LinkedList<>();
        qs = new LinkedList<>();
        this.sc.setQueue(qs);
        this.pr.setQueue(qp);
    }

    public void setTask(Task t) {
        if (t.getType() == Task.TYPE.PRINT) {
            qp.offer(t);
        } else if (t.getType() == Task.TYPE.SCAN) {
            qs.offer(t);
        }
    }
}

package MyOpinion.Queue;

import MyOpinion.Document.Doc;

import java.util.Queue;

abstract public class MFUQueue {

    protected Queue<Doc> queue;

    MFUQueue(Queue<Doc> queue) {
        this.queue = queue;
    }

    public Queue<Doc> getQueue() {
        return queue;
    }
}

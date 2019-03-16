package MyOpinion.Queue;

import MyOpinion.Document.Doc;

import java.util.Queue;

public class ScanQueue extends MFUQueue {
    public ScanQueue(Queue<Doc> queue) {
        super(queue);
    }
}

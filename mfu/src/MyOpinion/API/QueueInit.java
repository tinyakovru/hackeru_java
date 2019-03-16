package MyOpinion.API;

import MyOpinion.Document.Doc;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueInit {

    public static Queue<Doc> init(Doc... docs){
        return new ArrayBlockingQueue<>(10, false, Arrays.asList(docs));
    }

}

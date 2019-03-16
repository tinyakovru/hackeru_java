package MyOpinion;

import MyOpinion.Document.Doc;
import MyOpinion.Threads.PrintThread;
import MyOpinion.Threads.ScanThread;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import MyOpinion.API.MfuApi;
import MyOpinion.API.QueueInit;
import MyOpinion.Queue.PrintQueue;
import MyOpinion.Queue.ScanQueue;
import MyOpinion.Queue.MFUQueue;

public class MFUApp {
        private static Thread p1, p2, s1, s2;
        private static MFUQueue printQueue, scanQueue;
    static {
        printQueue = new PrintQueue(QueueInit.init(new Doc("Doc1",4), new Doc("Doc2", 3), new Doc("Doc3",4)));
        scanQueue = new ScanQueue(QueueInit.init(new Doc("Scan1",4), new Doc("Scan2", 5), new Doc("Scan3",2)));
        MfuApi api = new MfuApi();
        p1 = new Thread(new PrintThread(printQueue,api));
        p2 = new Thread(new PrintThread(printQueue, api));
        s1 = new Thread(new ScanThread(scanQueue, api));
        s2 = new Thread(new ScanThread(scanQueue, api));
    }

    public static void main(String[] args) throws InterruptedException {
        p1.start();
        p2.start();
        s1.start();
        s2.start();
        p1.join();
        p2.join();
        s1.join();
        s2.join();
    }

}

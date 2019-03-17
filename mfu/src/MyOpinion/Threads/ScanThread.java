package MyOpinion.Threads;

import MyOpinion.Document.Doc;
import MyOpinion.API.MfuApi;
import MyOpinion.Queue.MFUQueue;

public class ScanThread extends MFUThread implements Runnable {

    public ScanThread(MFUQueue queue, MfuApi mfuApi) {
        super(queue, mfuApi);
    }

    @Override
    public void run() {
        while ((doc = queue.getQueue().poll())!= null) mfuApi.scan(doc);
    }
}

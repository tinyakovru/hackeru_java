package MyOpinion.Threads;

import MyOpinion.Document.Doc;
import MyOpinion.API.MfuApi;
import MyOpinion.Queue.MFUQueue;

public class PrintThread extends MFUThread implements Runnable {


    public PrintThread(MFUQueue queue, MfuApi mfuApi) {
        super(queue, mfuApi);
    }

    @Override
    public void run() {
        while ((doc = queue.getQueue().poll())!= null) mfuApi.print(doc);
    }
}

package MyOpinion.Threads;

import MyOpinion.API.MfuApi;
import MyOpinion.Document.Doc;
import MyOpinion.Queue.MFUQueue;

abstract class MFUThread {
    MFUQueue queue;
    MfuApi mfuApi;
    protected Doc doc;

    MFUThread(MFUQueue queue, MfuApi mfuApi) {
        this.queue = queue;
        this.mfuApi = mfuApi;
        doc = null;
    }
}

package MyOpinion.API;

import MyOpinion.Document.Doc;
import MyOpinion.Queue.MFUQueue;

public class MfuApi {

    //Хак для синхронизации
    private final Object printLock = new Object();
    private final Object scanLock = new Object();



    public void print(Doc doc){
        synchronized (printLock) {
            System.out.println("Начинаю печать документа  № " + doc.getName() + " (страницы: " + doc.getPages() + ")");
            for (int i = 0; i < doc.getPages(); i++) {
                System.out.println("Напечатана страница № " + (i + 1));
            }
            System.out.println("Документ № " + doc.getName() + " распечатан");
        }
    }

    public void scan(Doc doc){
        synchronized (scanLock) {
            System.out.println("Начинаю сканирование документа № " + doc.getName() + " (страницы: " + doc.getPages() + ")");
            for (int i = 0; i < doc.getPages(); i++) {
                System.out.println("Сканируется страница № " + (i + 1));
            }
            System.out.println("Документ № " + doc.getName() + " отсканирован");
        }
    }
}

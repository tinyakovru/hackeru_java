public class Main {

    public static void main(String[] args) {
        MyScan sc = new MyScan();
        Printer pr = new Printer();
        MFU mfu = new MFU(sc, pr);

        for (int i = 0; i < 100; i++) {
            mfu.setTask(new Task(Task.TYPE.PRINT, "Документ для печати №" + i));
        }
        for (int i = 0; i < 100; i++) {
            mfu.setTask(new Task(Task.TYPE.SCAN, "Сканируется страница " + i));
        }


        try {
            sc.getT().join();
            pr.getT().join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}

public class MyScan extends AbstractDevice {

    @Override
    public void work(Task task) {
        System.out.println("Идет сканирование: " + task.getTarget());
        try {
            t.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

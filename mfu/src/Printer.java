public class Printer extends AbstractDevice {

    @Override
    public void work(Task task) {
        System.out.println("Идет печать: " + task.getTarget());
        try {
            t.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

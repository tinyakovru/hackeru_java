public class Task {
    public enum TYPE {PRINT, SCAN}

    private TYPE type;
    private String target;

    public TYPE getType() {
        return type;
    }

    public Task(TYPE type, String target) {
        this.type = type;
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

}


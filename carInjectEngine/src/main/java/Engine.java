public class Engine {
    String name;

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                '}';
    }

    public Engine(String name) {
        this.name = name;
    }
}

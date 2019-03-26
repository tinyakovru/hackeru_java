package logger;

public class ConsoleLogger implements Loggable {
    public void log(String string){
        System.out.println("Logger: "+string);
    }
}

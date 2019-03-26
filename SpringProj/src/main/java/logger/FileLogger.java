package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileLogger implements Loggable {
    @Override
    public void log(String string) {


    //public void log_(String string){
        String path = getClass().getClassLoader().getResource("log.txt").getFile();
        Writer writer = null;
        try {
             writer = new FileWriter(path,true);
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Logger: "+string);
    }
}

package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

public class BufLogger {
    private List<String> logList;
    private int count;
    private FileWriter fw;
    private String path = getClass().getClassLoader().getResource("log.txt").getFile();

    public void log(String string){

       /* Writer writer = null;
        try {
            writer = new FileWriter(path,true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(logList.size() > count){
            logList.stream().forEach(s -> {
                writer.write(s);
            });
        }*/


    }

    public BufLogger(int count) {
        this.count = count;
        logList = new LinkedList<>();
    }
}

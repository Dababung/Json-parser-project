package bg.tu_varna.sit.b1.f21621618;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public void write(StringBuilder jsonData, String filePath){
        try{
        FileWriter writer=new FileWriter(filePath);
        writer.write(jsonData.toString());
    }
    catch (IOException e){
        e.printStackTrace();
        }
    }
}

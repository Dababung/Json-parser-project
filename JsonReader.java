package bg.tu_varna.sit.b1.f21621618;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {
    public StringBuilder read(String filePath){
        StringBuilder data=new StringBuilder();
        try{
            Path path= Paths.get(filePath);
            List<String> rows= Files.readAllLines(path);
            for(String row: rows){
                data.append(row);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}

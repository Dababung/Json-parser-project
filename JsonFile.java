package bg.tu_varna.sit.b1.f21621618;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonFile {
    private String filePath;
    private StringBuilder data;

    public JsonFile(String filePath) {
        this.filePath = filePath;
        this.data = new StringBuilder();
    }

    public void load(){ //https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
        try{
            Path path= Paths.get(filePath);//https://www.tabnine.com/code/java/methods/java.nio.file.Files/readAllLines
        List<String> lines= Files.readAllLines(path);
        for (String line:lines){
            data.append(line);
        }
    } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void save(){
        try {
            FileWriter writer=new FileWriter(filePath);
            writer.write(data.toString());
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public StringBuilder getData() {
        return data;
    }
}

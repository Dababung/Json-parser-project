package bg.tu_varna.sit.b1.f21621618;

import java.util.List;

public class JsonEditor {
    private JsonFile file;

    public void open(String filePath){
        file =new JsonFile(filePath);
        file.load();
        System.out.println("opened ");
    }
    public void close(){}
    public void save(){
        file.save();
        System.out.println("saved ");
    }
    public void saveAs(String filePath){
        file.setFilePath(filePath);
        save();
        System.out.print("as ");
    }
    public void help(){
        System.out.println("info");
    }
    public void exit(){
        System.out.println("exited");
        System.exit(0); //https://linuxhint.com/end-java-program/
    }
    public void validate(){
        JsonValidator validator=new JsonValidator();
        if (validator.validate(String.valueOf(file.getData()))){
            System.out.println("validated");
        }
        else System.out.println("cant validate");
    }
    public void print(){
        JsonPrinter printer=new JsonPrinter();
        printer.print(file.getData());
    }
    public void find(String key){
        JsonFinder finder=new JsonFinder();
        List<String> results=finder.find(file.getData(),key);
        for (String result : results){
            System.out.println(result);
        }
    }
    public void set(String path, String value){
        JsonSetter setter=new JsonSetter();
        setter.set(path,value, file.getData());
        System.out.println("set "+path);
    }
    public void create(String path, String value){
        JsonSetter setter=new JsonSetter();
        setter.create(path, value, file.getData());
        System.out.println("created "+path);
    }
    public void delete(String path){
        JsonSetter setter=new JsonSetter();
        setter.delete(path, file.getData());
        System.out.println("deleted "+path);
    }
    public void move(String from, String to){}
    public void save(String path){}
    public void saveAs(String file, String path){}
}

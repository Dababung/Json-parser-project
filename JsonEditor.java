package bg.tu_varna.sit.b1.f21621618;

import java.util.List;

public class JsonEditor {
    private JsonFile file;

    public void open(String filePath){
        file =new JsonFile(filePath);
        file.load();
        System.out.println("Successfully opened "+filePath);
    }
    public void close(){

        System.out.println("Successfully closed "+file.getFilePath());
        file=null;
    }
    public void save(){
        if (file==null)
            System.out.println("No file is opened");
        else {
        file.save();
        System.out.println("Successfully saved "+file.getFilePath());
        }
    }
    public void saveAs(String filePath){
        if (file==null)
            System.out.println("No file is opened");
        else {
        file.setFilePath(filePath);
        file.save();
        System.out.println("Successfully saved another "+file.getFilePath());
        }
    }
    public void help(){
        System.out.println("The following commands are supported: \n" +
                "open <file>\t\topens <file> \n" +
                "close\t\t\tcloses currently opened file \n" +
                "save\t\t\tsaves the currently open file \n" +
                "saveas <file>\tsaves the currently open file in <file> \n" +
                "help\t\t\tprints this information \n" +
                "exit\t\t\texists the program ");
    }
    public void exit(){
        System.out.println("Exiting the program...");
        System.exit(0); //https://linuxhint.com/end-java-program/
    }
    public void validate(){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonValidator validator = new JsonValidator();
            if (validator.validate(String.valueOf(file.getData())))
                System.out.println("The file is valid");
            else System.out.println("The file is not valid");
        }
    }
    public void print(){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonPrinter printer = new JsonPrinter();
            printer.print(file.getData());
        }
    }
    public void find(String key) {
        if (file == null)
            System.out.println("No file is opened");
        else {
            JsonFinder finder = new JsonFinder();
            List<String> results = finder.find(file.getData(), key);
            if (results.isEmpty()) {
                System.out.println("No matches found");
            } else
                for (String result : results) {
                    System.out.println(result);
                }
        }
    }
    public void set(String path, String value){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.set(path, value, file.getData());
            System.out.println("Value set in " + path);
        }
    }
    public void create(String path, String value){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.create(path, value, file.getData());
            System.out.println("Value created in " + path);
        }
    }
    public void delete(String path){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.delete(path, file.getData());
            System.out.println("Value deleted in " + path);
        }
    }
    public void move(String from, String to) {
        if (file == null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.move(from, to, file.getData());
            System.out.println("Value moved from " + from + " to " + to);
        }
    }
    public void save(String path){
        if (file == null)
            System.out.println("No file is opened");
        else {
            JsonWriter writer = new JsonWriter();
            writer.write( file.getData(), path);
            System.out.println("Successfully saved to "+path);
        }
    }
    public void saveAs(String files, String path){
        if (file == null)
            System.out.println("No file is opened");
        else {
            JsonWriter writer = new JsonWriter();
            writer.write(file.getData(), path);
            System.out.println("Successfully saved to "+path);
        }
    }
}

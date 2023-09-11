package bg.tu_varna.sit.b1.f21621618;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonEditor {
    private JsonFile file;

    public void open(String filePath){
        file =new JsonFile(filePath);
        if (!Files.exists(Paths.get(filePath))) {
            try {
                Files.createFile(Paths.get(filePath));
            } catch (IOException e) {
                System.out.println("Can't create file: " + filePath);
                e.printStackTrace();
                return;
            }
        }
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
                "saveas <file>\t\tsaves the currently open file in <file> \n" +
                "help\t\t\tprints this information \n" +
                "exit\t\t\texits the program \n"+
                "validate\t\tchecks if the file is of JSON type \n" +
                "print\t\t\tprints file's data \n" +
                "find <key>\t\treturns the value of the given key \n" +
                "set <path> <value>\tsets a new value at the given path \n" +
                "create <path> <value>\tcreates a new element at the given path with the specified value \n" +
                "delete <path>\t\tdeletes the specified element \n" +
                "move <from> <to>\tmoves the element to a new path \n" +
                "save <path>\t\tsaves the currently open file to the file path \n" +
                "saveas <file> <path>\tsaves the currently open file to a specific file path\n"


        );
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
        }
    }
    public void create(String path, String value){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.create(path, value, file.getData());
        }
    }
    public void delete(String path){
        if (file==null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.delete(path, file.getData());
        }
    }
    public void move(String from, String to) {
        if (file == null)
            System.out.println("No file is opened");
        else {
            JsonSetter setter = new JsonSetter();
            setter.move(from, to, file.getData());
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

package bg.tu_varna.sit.b1.f21621618;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        JsonEditor editor = new JsonEditor();
        Console console = System.console();
        String input;

        if (console == null) {
            System.out.println("No console available. Exiting...");
            System.exit(1);
        }

        while (true) {
            input = console.readLine("> ");

            String[] commandParts = input.split(" ", 2);
            String command = commandParts[0];

            if (command.equalsIgnoreCase("open")) {
                String filePath = commandParts[1];
                editor.open(filePath);
            } else if (command.equalsIgnoreCase("save")) {
                if (commandParts.length==1)
                editor.save();
                else{
                    String filePath=commandParts[1];
                    editor.save(filePath);
                }
            } else if (command.equalsIgnoreCase("saveas")) {
                String[] parameters = commandParts[1].split(" ", 2);
                String filePath = parameters[1];
                if (parameters.length == 1)
                    editor.saveAs(filePath);
                else {
                    String file = parameters[0];
                    editor.saveAs(file, filePath);
                }
            }
              else if (command.equalsIgnoreCase("close")) {
                editor.close();
            } else if (command.equalsIgnoreCase("help")) {
                editor.help();
            } else if (command.equalsIgnoreCase("exit")) {
                editor.exit();
                break;
            } else if (command.equalsIgnoreCase("validate")) {
                editor.validate();
            } else if (command.equalsIgnoreCase("print")) {
                editor.print();
            } else if (command.equalsIgnoreCase("find")) {
                String key = commandParts[1];
                editor.find(key);
            } else if (command.equalsIgnoreCase("set")) {
                String[] parameters = commandParts[1].split(" ", 2);
                String path = parameters[0];
                String value = parameters[1];
                editor.set(path, value);
            } else if (command.equalsIgnoreCase("create")) {
                String[] parameters = commandParts[1].split(" ", 2);
                String path = parameters[0];
                String value = parameters[1];
                editor.create(path, value);
            } else if (command.equalsIgnoreCase("delete")) {
                String path = commandParts[1];
                editor.delete(path);
            } else if (command.equalsIgnoreCase("move")) {
                String[] parameters = commandParts[1].split(" ", 2);
                String from = parameters[0];
                String to = parameters[1];
                editor.move(from, to);
            } else {
                console.printf("Invalid command. Type 'help' for a list of supported commands.");
            }
        }
    }
}

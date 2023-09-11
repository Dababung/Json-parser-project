package bg.tu_varna.sit.b1.f21621618;

public class JsonPrinter {
    public void print(StringBuilder jsonData){
        int level = 0;
        boolean commas = false;
        boolean newLine = true;
        for (int i = 0; i < jsonData.length(); i++){
            char curr = jsonData.charAt(i);
            if (curr == '"')
                commas = !commas;

            if (!commas){
                if (curr == '{' || curr == '['){
                    level++;
                    newLine = true;
                }
                else if (curr == '}' || curr == ']'){
                    level--;
                    newLine = true;
                }
                else if (curr == ','){
                    newLine = true;
                }
            }
            if (newLine){
                System.out.println();
                for (int j = 0; j < level; j++){
                    System.out.print("    ");
                }
                newLine = false;
            }
            if (!Character.isWhitespace(curr) || (curr == ' ' && commas)) {
                System.out.print(curr);
            }
        }
        System.out.println();
    }
}

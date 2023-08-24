package bg.tu_varna.sit.b1.f21621618;

public class JsonPrinter {
    public void print(StringBuilder jsonData){
        int level=0;
        boolean commas=false;
        boolean newLine=false;
        for (int i=0;i<jsonData.length();i++){
            char curr=jsonData.charAt(i);
            if (curr=='"')
                commas=!commas;

        if (!commas){
            if (curr=='{'||curr=='['){
                level++;
            }
            else if(curr=='}'||curr==']'){
                level--;
            }
            else if (curr!=','){
                newLine=false;
            }
        }
        if (newLine){
            System.out.println();
            for (int j=0;j<level;j++){
                System.out.println(" ");
            }
            newLine=false;
        }
        System.out.print(curr);
        }
        System.out.println();
    }

}

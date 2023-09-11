package bg.tu_varna.sit.b1.f21621618;

public class JsonSetter {
    public void set(String path, String value, StringBuilder jsonData) {
        String[] divider = path.split("\\.");
        String json = jsonData.toString();

        for (int i = 0; i < divider.length - 1; i++) {
            String div = divider[i].trim();
            int iStart = json.indexOf(div);
            int iEnd = json.indexOf(":", iStart);

            if (iStart != -1 && iEnd != -1) {
                json = json.substring(0, iEnd) + ":" + json.substring(iEnd + 1);
            }
            else {
                System.out.println("Path not found");
            }
        }

        String segment = divider[divider.length - 1].trim();
        int iStart = json.indexOf(segment);
        int iEnd = json.indexOf(":", iStart) + 1;

        if (iStart != -1 && iEnd != -1) {
            int iStartValue = json.indexOf(":", iStart) + 1;
            int iEndValue = json.indexOf(",", iStartValue)+1;

            if (iEndValue == -1||iEndValue>json.indexOf("}", iStartValue)) {
                iEndValue = json.indexOf("}", iStartValue);
            }

            if (iEndValue != -1) {
                json = json.substring(0, iStartValue) + "\"" + value + "\"" + json.substring(iEndValue-1);
            }
        }

        jsonData.setLength(0);
        jsonData.append(json);
    }

    public void create(String path, String value, StringBuilder jsonData) {
        String[] divider = path.split("\\.");
        String json = jsonData.toString();

        String segment = divider[divider.length - 1].trim();

        if (json.contains(segment)) {
            System.out.println("Path already exists");
        }
        else
            System.out.println("Value created in " + path);

        int iStart = json.lastIndexOf("}");
        if (iStart != -1) {
            json = json.substring(0, iStart) + ",\"" + segment + "\":\"" + value + "\"" + json.substring(iStart);
        }

        jsonData.setLength(0);
        jsonData.append(json);
    }


    public void delete(String path, StringBuilder jsonData) {
        String[] divider = path.split("\\.");
        String json = jsonData.toString();
        String segment = divider[divider.length - 1].trim();

        if (!json.contains(segment)) {
            System.out.println("Path not found");
        }
        else
            System.out.println("Value deleted in " + path);

        int iTest=json.indexOf(segment)-10;
        int iStart = json.indexOf(",", iTest);
        if (iStart>json.indexOf("{", iTest)&&json.indexOf("{", iTest)!=-1){
            iStart=json.indexOf("{", iTest)+1;
        }
        int iEnd = json.indexOf(":", iStart);
        int iEndValue = json.indexOf(",", iEnd);

        if (iEndValue == -1||iEndValue>(json.indexOf("}", iEnd)-1)) {
            iEndValue = json.indexOf("}", iEnd)-1;
        }
        json = json.substring(0, iStart) + json.substring(iEndValue + 1);

        jsonData.setLength(0);
        jsonData.append(json);
    }



    public void move(String from, String to, StringBuilder jsonData) {
        String json = jsonData.toString();

        if (!json.contains(from)) {
            System.out.println("Element not found");
        }
        else
            System.out.println("Value moved from " + from + " to " + to);

        json = json.replace(from, to);

        jsonData.setLength(0);
        jsonData.append(json);
    }

}

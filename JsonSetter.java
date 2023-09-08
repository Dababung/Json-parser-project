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
        }

        String segment = divider[divider.length - 1].trim();
        int iStart = json.indexOf(segment);
        int iEnd = json.indexOf(":", iStart) + 1;

        if (iStart != -1 && iEnd != -1) {
            int iStartValue = json.indexOf(":", iStart) + 1;
            int iEndValue = json.indexOf(",", iStartValue);

            if (iEndValue == -1) {
                iEndValue = json.indexOf("}", iStartValue);
            }

            if (iEndValue != -1) {
                json = json.substring(0, iStartValue) + "\"" + value + "\"" + json.substring(iEndValue);
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
            return;
        }

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
            return;
        }

        int iStart = json.indexOf(segment);
        int iEnd = json.indexOf(":", iStart) + 1;
        int iEndValue = json.indexOf(",", iEnd);

        if (iEndValue == -1) {
            iEndValue = json.indexOf("}", iEnd);
        }

        json = json.substring(0, iStart - 1) + json.substring(iEndValue + 1);

        jsonData.setLength(0);
        jsonData.append(json);
    }


    public void move(String from, String to, StringBuilder jsonData) {
        String json = jsonData.toString();

        if (!json.contains(from)) {
            System.out.println("Path not found");
            return;
        }

        json = json.replace(from, to);

        jsonData.setLength(0);
        jsonData.append(json);
    }

}

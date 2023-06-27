package bg.tu_varna.sit.b1.f21621618;

public class JsonSetter {
    public void set(String path, String value, StringBuilder jsonData){
        String[] divider=path.split("\\.");
        String json=jsonData.toString();
        for (int i=0;i<divider.length;i++){
            String div=divider[i].trim();
            int iStart=json.indexOf(div);
            int iEnd=json.indexOf(":", iStart);
            if (iStart!=-1&& iEnd!=-1){
                json=json.substring(0, iEnd)+" {"+json.substring(iEnd);
            }
        }
        String segment=divider[divider.length].trim();
        int iStart=json.indexOf(segment);
        int iEnd=json.indexOf(":",iStart);
        if (iStart!=-1&&iEnd!=-1){
            int iStartValue=json.indexOf(":",iStart);
            int iEndValue=json.indexOf(",",iStartValue);
            if (iEndValue==-1) {
                iEndValue = json.indexOf("}", iStartValue);
            }
            else json=json.substring(0, iStartValue)+" "+value+json.substring(iEndValue);
        }
        jsonData.setLength(0);
        jsonData.append(json);
    }
    public void create(String path, String value, StringBuilder jsonData){
        String[] divider=path.split("\\.");
        String json=jsonData.toString();
        for (int i=0;i<divider.length;i++){
            String div=divider[i].trim();
            int iStart=json.indexOf(div);
            int iEnd=json.indexOf(":", iStart);
            if (iStart!=-1&& iEnd!=-1){
                json=json.substring(0, iEnd)+" {"+json.substring(iEnd);
            }
        }
        String segment=divider[divider.length].trim();
        int iStart=json.indexOf(segment);
        int iEnd=json.indexOf(":",iStart);
        if (iStart!=-1&&iEnd!=-1){
            int iStartValue=json.indexOf(":",iStart);
            int iEndValue=json.indexOf(",",iStartValue);
            if (iEndValue==-1) {
                iEndValue = json.indexOf("}", iStartValue);
            }
            else json=json.substring(0, iStartValue)+" "+value+json.substring(iStartValue);
        }
        jsonData.setLength(0);
        jsonData.append(json);
    }
    public void delete(String path, StringBuilder jsonData){
        String[] divider=path.split("\\.");
        String json=jsonData.toString();
        for (int i=0;i<divider.length;i++){
            String div=divider[i].trim();
            int iStart=json.indexOf(div);
            int iEnd=json.indexOf(":", iStart);
            if (iStart!=-1&& iEnd!=-1){
                json=json.substring(0, iEnd)+" {"+json.substring(iEnd);
            }
        }
        String segment=divider[divider.length].trim();
        int iStart=json.indexOf(segment);
        int iEnd=json.indexOf(":",iStart);
        if (iStart!=-1&&iEnd!=-1){
            int iStartValue=json.indexOf(":",iStart);
            int iEndValue=json.indexOf(",",iStartValue);
            if (iEndValue==-1) {
                iEndValue = json.indexOf("}", iStartValue);
            }
            else json=json.substring(0, iStartValue)+json.substring(iEndValue);
        }
        jsonData.setLength(0);
        jsonData.append(json);
    }
    public void move(String path, String value, StringBuilder jsonData){}

}

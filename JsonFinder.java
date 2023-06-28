package bg.tu_varna.sit.b1.f21621618;

import java.util.ArrayList;
import java.util.List;

public class JsonFinder {
    public List<String> find(StringBuilder jsonData, String key){
        List<String> results=new ArrayList<>();
        String jsonSt= jsonData.toString();
        int i=jsonSt.indexOf(key);
        while (i!=-1){
            int iStart=jsonSt.indexOf(":", i+key.length());
                    if(iStart!=-1){
                        int iEnd=jsonSt.indexOf(",", iStart);
                        if (iEnd==-1){
                            iEnd=jsonSt.indexOf("}", iStart);
                        }
                        if (iEnd!=-1){
                            String value=jsonSt.substring(iStart+1, iEnd).trim();
                            results.add(value);
                        }}
                        i=jsonSt.indexOf(key,i+key.length());
                    }
                    return results;
        }
    }

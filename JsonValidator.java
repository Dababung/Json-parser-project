package bg.tu_varna.sit.b1.f21621618;

public class JsonValidator {
    public boolean validate(String json) {
        json =json.trim();
            if ((json.startsWith("{")&&json.endsWith("}"))||(json.startsWith("[")&&json.endsWith("]")))
                return true;
            else return false;
    }
}
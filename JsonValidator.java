package bg.tu_varna.sit.b1.f21621618;

public class JsonValidator {
    public boolean validate(String json) {
        return validate(json, 0, 0);
    }

    private boolean validate(String json, int i, int depth) {
        if (i >= json.length()) {
            return true;
        }
        char curr = json.charAt(i);
        switch (curr) {
            case '{':
                depth++;
                return isObjectValid(json, i, depth);
            case '[':
                depth++;
                return isArrayValid(json, i, depth);
            case '}':
                if (depth == 0) {
                    System.out.println("Error: Unexpected '}' at position " + i);
                    return false;
                }
                depth--;
                break;
            case ']':
                if (depth == 0) {
                    System.out.println("Error: Unexpected ']' at position " + i);
                    return false;
                }
                depth--;
                break;
            default:
                break;
        }
        return validate(json, i + 1, depth);
    }

    private boolean isObjectValid(String json, int i, int depth) {
        int balance = 1;
        i++;
        while (i < json.length() && balance > 0) {
            char curr = json.charAt(i);
            if (curr == '{') {
                balance++;
            } else if (curr == '}') {
                balance--;
            }
            i++;
        }
        if (balance != 0) {
            System.out.println("Error: Missing '}' at position " + (i - 1));
            return false;
        }
        return validate(json, i, depth - 1);
    }

    private boolean isArrayValid(String json, int i, int depth) {
        int balance = 1;
        i++;
        while (i < json.length() && balance > 0) {
            char curr = json.charAt(i);
            if (curr == '[') {
                balance++;
            } else if (curr == ']') {
                balance--;
            }
            i++;
        }

        if (balance != 0) {
            System.out.println("Error: Missing ']' at position " + (i - 1));
            return false;
        }

        return validate(json, i, depth - 1);
    }
}

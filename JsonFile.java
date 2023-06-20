package bg.tu_varna.sit.b1.f21621618;

public class JsonFile {
    private String filePath;
    private JsonData data;

    public JsonFile(String filePath) {
        this.filePath = filePath;
    }
    public void load(){}
    public void save(){}

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public JsonData getData() {
        return data;
    }

    public void setData(JsonData data) {
        this.data = data;
    }
}

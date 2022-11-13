package task3;

public class Test {
    private String id;
    private String title;
    private String value;
    private Test values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Test() {
    }

    public Test(String id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}

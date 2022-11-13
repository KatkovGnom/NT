package task3;

public class Value {
    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Value() {
    }

    public Value(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

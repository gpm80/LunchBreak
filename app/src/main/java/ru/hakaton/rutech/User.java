package ru.hakaton.rutech;

public class User {
    private String identify;
    private String name;
    private Value value;

    public User(String identify, String name, Value value) {
        this.identify = identify;
        this.name = name;
        this.value = value;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "User{" +
                "identify='" + identify + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

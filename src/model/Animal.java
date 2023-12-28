package model;

public abstract class Animal {
    protected String type;
    protected String name;
    protected String age;

    public Animal(String type, String name, String age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }
    public Animal() {}


    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getAge() {
        return age;
    }


    @Override
    public final String toString() {
        return "Тип: %s, Имя: %s, Возраст: %s".formatted(getType(), getName(), getAge());
    }
}

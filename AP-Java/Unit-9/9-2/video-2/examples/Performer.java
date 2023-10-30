package examples;

public class Performer {
    private String name;
    private int age;

    public Performer() {
        name = "Ima Performer";
        age = 16;
    }

    public Performer(String n, int a) {
        name = n;
        age = a;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
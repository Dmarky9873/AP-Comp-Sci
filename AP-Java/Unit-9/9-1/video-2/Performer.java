public class Performer {
    private String name;
    private int age;

    public Performer(String name_, int age_) {
        name = name_;
        age = age_;
    }

    public String getName() {
        return name;
    }

    public void practice() {
        System.out.println("Honing my craft!");
    }

    public int getAge() {
        return age;
    }

    public void perform() {
        System.out.println("Performing for an audience!");
    }
}
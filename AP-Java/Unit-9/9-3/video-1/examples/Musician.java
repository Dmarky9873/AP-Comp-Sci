package examples;

public class Musician extends Performer{
    private String instrument;

    public Musician() {
        super(); // Has to be the first line
        instrument = "Piano";
    }

    public Musician(String inst) {
        super();
        instrument = inst;
    }

    public Musician(String n, int a, String inst) {
        super(n, a); // Still has to be the first line
        instrument = inst;
    }

    public String getInstrument() {
        return instrument;
    }

    // Overridden method: uses this method instead of the one in superclass performer
    public void perform() {
        System.out.println("Playing my " + instrument);
    }
}

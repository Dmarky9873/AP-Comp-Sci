package examples;

public class TrumpetPlayer extends Musician {

    public void solo() {
        System.out.println("Soloing...");
    }
    
    public void perform() {
        // The super doesn't have to be first if you're calling a superclass method (but a constructor does)
        super.perform(); // Superclass's perform method
        solo();
    }
}

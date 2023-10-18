package tower_of_hanoi;

class Runner {
    public static void main(String[] args) {
        System.out.println("Run");
        Graphics graphics = new Graphics();
        Graphics.Pages pages = graphics.new Pages();

        graphics.init();
        pages.home();
        graphics.finalize();
    }
}

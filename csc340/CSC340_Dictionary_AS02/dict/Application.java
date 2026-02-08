public class Application {
    private UserInterface userInterface;
    private Dictionary dictionary;

    public Application() {
        loadApplication();
    }

    private void loadApplication() {
        displayLoadingStart();
        this.dictionary = DataLoader.load();
        displayLoadingComplete();
        this.userInterface = new UserInterface(dictionary);
    }

    private void displayLoadingStart() {
        System.out.println("! Loading data...");
    }

    private void displayLoadingComplete() {
        System.out.println("! Loading completed...");
    }

    public void run() {
        userInterface.displayBanner();
        userInterface.start();
    }
}

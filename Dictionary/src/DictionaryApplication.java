/**
 * DictionaryApplication - Main entry point for the interactive dictionary
 * Initializes all components and starts the application
 */
public class DictionaryApplication {

    public static void main(String[] args) {
        // Step 1: Load the dictionary
        DictionaryManager manager = new DictionaryManager();

        // Load all data from enum into data structures
        manager.loadDictionary();

        // Step 2: Start the user interface
        DictionaryUI ui = new DictionaryUI(manager);
        ui.start();
    }
}

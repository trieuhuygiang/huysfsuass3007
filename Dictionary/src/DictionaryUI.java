import java.util.Scanner;

/**
 * DictionaryUI - User Interface for the interactive dictionary
 * Handles user input, displays results, and manages the search loop
 */
public class DictionaryUI {

    private DictionaryManager manager;
    private SearchEngine engine;
    private Scanner scanner;
    private int searchCounter;

    /**
     * Constructor - initializes UI with manager and search engine
     * 
     * @param manager The loaded DictionaryManager
     */
    public DictionaryUI(DictionaryManager manager) {
        this.manager = manager;
        this.engine = new SearchEngine(manager);
        this.scanner = new Scanner(System.in);
        this.searchCounter = 1;
    }

    /**
     * Displays the loading completion message with dictionary statistics
     * Format matches the required output exactly
     */
    public void displayLoadingCompleted() {
        System.out.println("! Loading completed...\n");

        // Display dictionary header with statistics
        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + manager.getKeywordCount() + " -----");
        System.out.println("Definitions: " + manager.getDefinitionCount());
        System.out.println();
    }

    /**
     * Starts the interactive search loop
     */
    public void start() {
        displayLoadingCompleted();

        while (true) {
            displaySearchPrompt();
            String input = scanner.nextLine().trim();

            // Check for exit command
            if (input.equalsIgnoreCase("!q")) {
                displayThankYou();
                break;
            }

            // Check for help command
            if (input.equalsIgnoreCase("!help")) {
                displayHelp();
                searchCounter++;
                continue;
            }

            // Check for empty input
            if (input.isEmpty()) {
                displayHelp();
                searchCounter++;
                continue;
            }

            // Process search
            processSearch(input);
            searchCounter++;
        }

        scanner.close();
    }

    /**
     * Displays the search prompt with counter
     */
    private void displaySearchPrompt() {
        System.out.print("Search [" + searchCounter + "]: ");
    }

    /**
     * Displays help information about parameters
     */
    private void displayHelp() {
        System.out.println(" | ");
        System.out.println("  PARAMETER HOW-TO,  please enter: ");
        System.out.println("  1. A search key -then 2. An optional part of speech -then ");
        System.out.println("  3. An optional 'distinct' -then 4. An optional 'reverse' ");
        System.out.println(" | ");
    }

    /**
     * Displays thank you message and exits
     */
    private void displayThankYou() {
        System.out.println(" -----THANK YOU-----");
    }

    /**
     * Processes a search query
     * 
     * @param input The user input string
     */
    private void processSearch(String input) {
        // Parse input into parameters
        String[] params = input.split("\\s+");

        // Perform search
        SearchEngine.SearchResult result = engine.search(params);

        System.out.println(" | ");

        // Display error messages if any
        if (!result.getErrorMessages().isEmpty()) {
            for (String error : result.getErrorMessages()) {
                System.out.println("  " + error);
            }
            System.out.println(" | ");
        }

        // Check if too many parameters (more than 4)
        if (result.hasExtraParameters()) {
            displayHelp();
            return;
        }

        // Display results or not found message
        if (result.isNotFound()) {
            System.out.println("  <NOT FOUND> To be considered for the next release. Thank you.");
            System.out.println(" | ");
        } else {
            for (SearchEngine.SearchResult.ResultEntry entry : result.getResults()) {
                System.out.println("  " + entry);
            }
            System.out.println(" | ");
        }
    }
}

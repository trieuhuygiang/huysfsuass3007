import java.util.*;

public class UserInterface {
    private Dictionary dictionary;
    private Scanner scanner;

    public UserInterface(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    public void displayBanner() {
        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + dictionary.getKeywordCount());
        System.out.println("----- Definitions: " + dictionary.getDefinitionCount());
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.print("\nEnter search term (or 'quit'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                running = false;
                continue;
            }

            if (input.isEmpty()) {
                continue;
            }

            processSearch(input);
        }

        close();
    }

    private void processSearch(String input) {
        // Parse input: keyword [partOfSpeech] [distinct] [reverse]
        String[] tokens = input.split("\\s+");

        String keyword = tokens[0];
        String partOfSpeech = null;
        boolean filterDistinct = false;
        boolean reverse = false;

        // Parse optional parameters
        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i].toLowerCase();

            if (token.equals("distinct")) {
                filterDistinct = true;
            } else if (token.equals("reverse")) {
                reverse = true;
            } else {
                // Check if it's a valid part of speech
                if (isValidPartOfSpeech(token)) {
                    partOfSpeech = token;
                } else {
                    System.out.println("<The entered " + (i + 1) + getOrdinalSuffix(i + 1)
                            + " parameter '" + tokens[i] + "' is NOT a part of speech.>");
                }
            }
        }

        // Perform search
        List<DataSource> results = dictionary.search(keyword, partOfSpeech, filterDistinct, reverse);

        displayResults(keyword, results);
    }

    private void displayResults(String keyword, List<DataSource> results) {
        if (results.isEmpty()) {
            System.out.println("<NOT FOUND> " + keyword);
        } else {
            System.out.println(results.size() + ": " + keyword);
            for (DataSource ds : results) {
                System.out.println("  [" + ds.getType() + "] " + ds.getDefinition());
            }
        }
    }

    /**
     * Check if a token is a valid part of speech
     */
    private boolean isValidPartOfSpeech(String token) {
        String[] validPOS = {
                "noun", "verb", "adjective", "adverb", "pronoun", "preposition",
                "conjunction", "interjection", "article", "determiner"
        };
        for (String pos : validPOS) {
            if (token.equalsIgnoreCase(pos)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get ordinal suffix for numbers (1st, 2nd, 3rd, etc.)
     */
    private String getOrdinalSuffix(int num) {
        if (num >= 11 && num <= 13) {
            return "th";
        }
        switch (num % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public void close() {
        scanner.close();
    }
}

import java.util.*;

/**
 * DictionaryEntry enum - Data source for the interactive dictionary
 * Each entry contains a keyword, part of speech, and definition as separate
 * fields
 * No hard-coded combinations - each piece of data is stored independently
 */
enum DictionaryEntry {
    // ARROW (1 keyword)
    ARROW_NOUN_1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),

    // BOOK (1 keyword)
    BOOK_NOUN_1("Book", "noun", "A set of pages."),
    BOOK_NOUN_2("Book", "noun", "A written work published in printed or electronic form."),
    BOOK_VERB_1("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK_VERB_2("Book", "verb", "To arrange something on a particular date."),

    // DISTINCT (1 keyword)
    DISTINCT_ADJECTIVE_1("Distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT_ADJECTIVE_2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT_ADVERB_1("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT_NOUN_1("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_2("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_3("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_4("Distinct", "noun", "An advanced search option."),
    DISTINCT_NOUN_5("Distinct", "noun", "Distinct is a parameter in this assignment."),

    // PLACEHOLDER (1 keyword)
    PLACEHOLDER_ADJECTIVE_1("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_ADJECTIVE_2("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_ADVERB_1("Placeholder", "adverb", "To be updated..."),
    PLACEHOLDER_CONJUNCTION_1("Placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER_INTERJECTION_1("Placeholder", "interjection", "To be updated..."),
    PLACEHOLDER_NOUN_1("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_NOUN_2("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_NOUN_3("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_PREPOSITION_1("Placeholder", "preposition", "To be updated..."),
    PLACEHOLDER_PRONOUN_1("Placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER_VERB_1("Placeholder", "verb", "To be updated..."),

    // REVERSE (1 keyword)
    REVERSE_ADJECTIVE_1("Reverse", "adjective", "On back side."),
    REVERSE_ADJECTIVE_2("Reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE_NOUN_1("Reverse", "noun", "A dictionary program's parameter."),
    REVERSE_NOUN_2("Reverse", "noun", "Change to opposite direction."),
    REVERSE_NOUN_3("Reverse", "noun", "The opposite."),
    REVERSE_NOUN_4("Reverse", "noun", "To be updated..."),
    REVERSE_NOUN_5("Reverse", "noun", "To be updated..."),
    REVERSE_NOUN_6("Reverse", "noun", "To be updated..."),
    REVERSE_NOUN_7("Reverse", "noun", "To be updated..."),
    REVERSE_VERB_1("Reverse", "verb", "Change something to opposite."),
    REVERSE_VERB_2("Reverse", "verb", "Go back"),
    REVERSE_VERB_3("Reverse", "verb", "Revoke ruling."),
    REVERSE_VERB_4("Reverse", "verb", "To be updated..."),
    REVERSE_VERB_5("Reverse", "verb", "To be updated..."),
    REVERSE_VERB_6("Reverse", "verb", "Turn something inside out."),

    // Additional keywords (14 more needed to reach 19 total)
    HELP_NOUN_1("Help", "noun", "Assistance or support."),
    HELP_VERB_1("Help", "verb", "To provide assistance."),

    SEARCH_NOUN_1("Search", "noun", "An attempt to find something."),
    SEARCH_VERB_1("Search", "verb", "To look for something."),

    PARAMETER_NOUN_1("Parameter", "noun", "A value used in a function or operation."),
    PARAMETER_NOUN_2("Parameter", "noun", "A setting or configuration option."),

    OPTIONAL_ADJECTIVE_1("Optional", "adjective", "Not required; able to be left out."),
    OPTIONAL_ADJECTIVE_2("Optional", "adjective", "Available to be chosen but not necessary."),

    PROGRAM_NOUN_1("Program", "noun", "A set of instructions for a computer."),
    PROGRAM_NOUN_2("Program", "noun", "A series of activities or presentations."),

    KEYWORD_NOUN_1("Keyword", "noun", "A word used as a search term."),
    KEYWORD_NOUN_2("Keyword", "noun", "A significant or important word."),

    DEFINITION_NOUN_1("Definition", "noun", "A statement of the meaning of a word or term."),
    DEFINITION_NOUN_2("Definition", "noun", "The act of defining or making clear."),

    INTERFACE_NOUN_1("Interface", "noun", "A point where two systems meet and interact."),
    INTERFACE_NOUN_2("Interface", "noun", "A device for connecting components."),

    INPUT_NOUN_1("Input", "noun", "Data or information provided to a system."),

    OUTPUT_NOUN_1("Output", "noun", "Result or information produced by a system."),

    DATA_NOUN_1("Data", "noun", "Information in the form of facts or statistics."),

    STRUCTURE_NOUN_1("Structure", "noun", "The way something is organized or constructed."),

    EFFICIENT_ADJECTIVE_1("Efficient", "adjective", "Working well and using minimal resources."),

    DYNAMIC_ADJECTIVE_1("Dynamic", "adjective", "Characterized by energy or effective action.");

    // Private fields for each entry
    private final String keyword;
    private final String partOfSpeech;
    private final String definition;

    DictionaryEntry(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] : %s", keyword, partOfSpeech, definition);
    }
}

public class DictionaryManager {

    // ArrayList to store all dictionary entries
    private List<DictionaryEntry> allEntries;

    // Set to track all unique keywords
    private Set<String> allKeywords;

    // Set to track all valid parts of speech
    private Set<String> validPartsOfSpeech;

    // Total count of definitions
    private static int totalDefinitions = 0;

    /**
     * Constructor - initializes the data structures
     */
    public DictionaryManager() {
        this.allEntries = new ArrayList<>();
        this.allKeywords = new LinkedHashSet<>();
        this.validPartsOfSpeech = new LinkedHashSet<>();
    }

    /**
     * Loads all dictionary data from the DictionaryEntry enum
     * Must be called before any search operations
     */
    public void loadDictionary() {
        for (DictionaryEntry entry : DictionaryEntry.values()) {
            String pos = entry.getPartOfSpeech().toLowerCase();

            // Add to entries list
            allEntries.add(entry);

            // Track unique keywords
            allKeywords.add(entry.getKeyword());

            // Track valid parts of speech
            validPartsOfSpeech.add(pos);

            // Increment definition count
            totalDefinitions++;
        }
    }

    /**
     * Gets all entries for a keyword (case-insensitive)
     * 
     * @param keyword The keyword to search for
     * @return List of DictionaryEntry objects, empty if not found
     */
    public List<DictionaryEntry> getEntriesByKeyword(String keyword) {
        List<DictionaryEntry> results = new ArrayList<>();
        String keywordLower = keyword.toLowerCase();

        for (DictionaryEntry entry : allEntries) {
            if (entry.getKeyword().toLowerCase().equals(keywordLower)) {
                results.add(entry);
            }
        }
        return results;
    }

    /**
     * Gets all entries for a keyword with a specific part of speech
     * 
     * @param keyword      The keyword to search for
     * @param partOfSpeech The part of speech to filter by
     * @return List of DictionaryEntry objects matching both criteria
     */
    public List<DictionaryEntry> getEntriesByKeywordAndPOS(String keyword, String partOfSpeech) {
        List<DictionaryEntry> results = new ArrayList<>();
        String keywordLower = keyword.toLowerCase();
        String posLower = partOfSpeech.toLowerCase();

        for (DictionaryEntry entry : allEntries) {
            if (entry.getKeyword().toLowerCase().equals(keywordLower) &&
                    entry.getPartOfSpeech().toLowerCase().equals(posLower)) {
                results.add(entry);
            }
        }
        return results;
    }

    /**
     * Gets unique definitions for a keyword (removes duplicates)
     * 
     * @param keyword The keyword to search for
     * @return List of unique definitions
     */
    public List<String> getUniqueDefinitions(String keyword) {
        Set<String> uniqueDefs = new LinkedHashSet<>();
        String keywordLower = keyword.toLowerCase();

        for (DictionaryEntry entry : allEntries) {
            if (entry.getKeyword().toLowerCase().equals(keywordLower)) {
                uniqueDefs.add(entry.getDefinition());
            }
        }
        return new ArrayList<>(uniqueDefs);
    }

    /**
     * Gets unique definitions for a keyword with a specific part of speech
     * 
     * @param keyword      The keyword to search for
     * @param partOfSpeech The part of speech filter
     * @return List of unique definitions for that part of speech
     */
    public List<String> getUniqueDefinitionsByPOS(String keyword, String partOfSpeech) {
        Set<String> uniqueDefs = new LinkedHashSet<>();
        String keywordLower = keyword.toLowerCase();
        String posLower = partOfSpeech.toLowerCase();

        for (DictionaryEntry entry : allEntries) {
            if (entry.getKeyword().toLowerCase().equals(keywordLower) &&
                    entry.getPartOfSpeech().toLowerCase().equals(posLower)) {
                uniqueDefs.add(entry.getDefinition());
            }
        }
        return new ArrayList<>(uniqueDefs);
    }

    /**
     * Validates if a part of speech is valid in the dictionary
     * 
     * @param partOfSpeech The part of speech to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidPartOfSpeech(String partOfSpeech) {
        return validPartsOfSpeech.contains(partOfSpeech.toLowerCase());
    }

    /**
     * Gets the count of unique keywords
     * 
     * @return Number of unique keywords
     */
    public int getKeywordCount() {
        return allKeywords.size();
    }

    /**
     * Gets the total count of definitions
     * 
     * @return Total number of definitions
     */
    public int getDefinitionCount() {
        return totalDefinitions;
    }

    /**
     * Checks if a keyword exists in the dictionary
     * 
     * @param keyword The keyword to check
     * @return true if exists, false otherwise
     */
    public boolean keywordExists(String keyword) {
        String keywordLower = keyword.toLowerCase();
        for (String key : allKeywords) {
            if (key.toLowerCase().equals(keywordLower)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the canonical form of a keyword (with proper capitalization)
     * 
     * @param keyword The keyword (any case)
     * @return The canonical form with first letter capitalized
     */
    public String getCanonicalKeyword(String keyword) {
        if (!keywordExists(keyword)) {
            return null;
        }
        for (String key : allKeywords) {
            if (key.equalsIgnoreCase(keyword)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Gets all valid parts of speech in the dictionary
     * 
     * @return Set of valid parts of speech
     */
    public Set<String> getAllPartsOfSpeech() {
        return new HashSet<>(validPartsOfSpeech);
    }
}

public enum DataSource {
    // I define vocabulary by using enum constant according to the sample out put.
    // Each consant include 3 data fields: word, type, definition.
    // provided PDF file.
    // WORLD ("word", "type", "definition")

    ARROW("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),

    BOOK_NOUN("Book", "noun", "A set of pages."),
    BOOK_NOUN_2("Book", "noun", "A written work published in printed or electronic form."),
    BOOK_VERB("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK_VERB_2("Book", "verb", "To arrange something on a particular date."),

    DISTINCT_ADJECTIVE("Distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT_ADJECTIVE_2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT_ADVERB("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT_NOUN("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_2("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_3("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_NOUN_4("Distinct", "noun", "An advanced search option."),
    DISTINCT_NOUN_5("Distinct", "noun", "Distinct is a parameter in this assignment."),

    // PLACEHOLDER
    PLACEHOLDER_ADJECTIVE("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_ADJECTIVE_2("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_ADVERB("Placeholder", "adverb", "To be updated..."),
    PLACEHOLDER_CONJUNCTION("Placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER_INTERJECTION("Placeholder", "interjection", "To be updated..."),
    PLACEHOLDER_NOUN("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_NOUN_2("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_NOUN_3("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_PREPOSITION("Placeholder", "preposition", "To be updated..."),
    PLACEHOLDER_PRONOUN("Placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER_VERB("Placeholder", "verb", "To be updated..."),

    // REVERSE
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

    HELP_NOUN("Help", "noun", "Assistance or support."),
    HELP_VERB("Help", "verb", "To provide assistance."),

    SEARCH_NOUN("Search", "noun", "An attempt to find something."),
    SEARCH_VERB("Search", "verb", "To look for something."),

    PARAMETER_NOUN("Parameter", "noun", "A value used in a function or operation."),
    PARAMETER_NOUN_2("Parameter", "noun", "A setting or configuration option."),

    OPTIONAL_ADJECTIVE("Optional", "adjective", "Not required; able to be left out."),
    OPTIONAL_ADJECTIVE_2("Optional", "adjective", "Available to be chosen but not necessary."),

    PROGRAM_NOUN("Program", "noun", "A set of instructions for a computer."),
    PROGRAM_NOUN_2("Program", "noun", "A series of activities or presentations."),

    KEYWORD_NOUN("Keyword", "noun", "A word used as a search term."),
    KEYWORD_NOUN_2("Keyword", "noun", "A significant or important word."),

    DEFINITION_NOUN("Definition", "noun", "A statement of the meaning of a word or term."),
    DEFINITION_NOUN_2("Definition", "noun", "The act of defining or making clear."),

    INTERFACE_NOUN_1("Interface", "noun", "A point where two systems meet and interact."),
    INTERFACE_NOUN_2("Interface", "noun", "A device for connecting components."),

    INPUT_NOUN("Input", "noun", "Data or information provided to a system."),

    OUTPUT_NOUN_2("Output", "noun", "Result or information produced by a system."),

    DATA_NOUN("Data", "noun", "Information in the form of facts or statistics."),

    STRUCTURE_NOUN("Structure", "noun", "The way something is organized or constructed."),

    EFFICIENT_ADJECTIVE("Efficient", "adjective", "Working well and using minimal resources."),

    DYNAMIC_ADJECTIVE_2("Dynamic", "adjective", "Characterized by energy or effective action.");

    // instances
    private String word;
    private String type;
    private String definition;

    // Constructor
    DataSource(String word, String type, String definition) {
        this.word = word;
        this.type = type;
        this.definition = definition;
    }

    // getter
    public String getWord() {
        return this.word;
    }

    public String getType() {
        return this.type;
    }

    public String getDefinition() {
        return this.definition;
    }

    // toString
    @Override
    public String toString() {
        return word + " [" + type + "] " + ": " + definition;
    }

}

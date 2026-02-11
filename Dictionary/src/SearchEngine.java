import java.util.*;

public class SearchEngine {

    private DictionaryManager manager;

    public SearchEngine(DictionaryManager manager) {
        this.manager = manager;
    }

    public SearchResult search(String[] params) {
        SearchResult result = new SearchResult();

        // Validate that we have at least the search key
        if (params == null || params.length == 0 || params[0].trim().isEmpty()) {
            return result;
        }

        String keyword = params[0].trim();
        String posFilter = null;
        boolean distinctMode = false;
        boolean reverseMode = false;

        // Parse optional parameters (indices 1-3 map to params 2-4)
        for (int i = 1; i < Math.min(params.length, 4); i++) {
            String param = params[i].trim().toLowerCase();
            if (param.isEmpty())
                continue;

            // Parameter 2 can be POS, distinct, or reverse
            if (i == 1) {
                if (manager.isValidPartOfSpeech(param)) {
                    posFilter = param;
                } else if (param.equals("distinct")) {
                    distinctMode = true;
                } else if (param.equals("reverse")) {
                    reverseMode = true;
                } else {
                    addParameterError(result, i, params[i].trim(), true);
                }
            }
            // Parameters 3-4 can be distinct or reverse
            else {
                if (param.equals("distinct")) {
                    distinctMode = true;
                } else if (param.equals("reverse")) {
                    reverseMode = true;
                } else {
                    addParameterError(result, i, params[i].trim(), false);
                }
            }
        }

        if (params.length > 4) {
            result.setHasExtraParameters(true);
        }

        // Check if keyword exists
        if (!manager.keywordExists(keyword)) {
            result.setNotFound(true);
            return result;
        }

        // Fetch entries based on POS filter
        Collection<DictionaryEntry> entries = posFilter != null
                ? manager.getEntriesByKeywordAndPOS(keyword, posFilter)
                : manager.getEntriesByKeyword(keyword);

        if (entries.isEmpty()) {
            result.setNotFound(true);
            return result;
        }

        // Apply distinct filter
        List<DictionaryEntry> processedEntries = new ArrayList<>(entries);
        if (distinctMode) {
            Set<String> seenDefs = new HashSet<>();
            processedEntries.removeIf(e -> !seenDefs.add(e.getDefinition()));
        }

        // Build results
        String displayKeyword = manager.getCanonicalKeyword(keyword);
        for (DictionaryEntry entry : processedEntries) {
            result.addResultEntry(displayKeyword, entry.getPartOfSpeech(), entry.getDefinition());
        }

        // Apply reverse if requested
        if (reverseMode) {
            result.reverseResults();
        }

        return result;
    }

    private void addParameterError(SearchResult result, int paramIndex, String value, boolean canBePOS) {
        String paramNum = paramIndex == 1 ? "2nd" : paramIndex == 2 ? "3rd" : "4th";

        if (canBePOS) {
            result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' is NOT a part of speech.>");
            result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' is NOT 'distinct'.>");
            result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' is NOT 'reverse'.>");
        } else {
            result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' is NOT 'distinct'.>");
            result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' is NOT 'reverse'.>");
        }

        result.addErrorMessage("<The entered " + paramNum + " parameter '" + value + "' was disregarded.>");
        result.addErrorMessage("<The " + paramNum + " parameter should be " +
                (canBePOS ? "a part of speech or 'distinct' or 'reverse'." : "'distinct' or 'reverse'.") + ">");
    }

    /**
     * Inner class to hold search results
     */
    public static class SearchResult {
        private List<ResultEntry> results;
        private List<String> errorMessages;
        private boolean notFound;
        private boolean hasExtraParameters;

        public SearchResult() {
            this.results = new ArrayList<>();
            this.errorMessages = new ArrayList<>();
            this.notFound = false;
            this.hasExtraParameters = false;
        }

        public void addResultEntry(String keyword, String pos, String definition) {
            results.add(new ResultEntry(keyword, pos, definition));
        }

        public void addErrorMessage(String message) {
            errorMessages.add(message);
        }

        public List<ResultEntry> getResults() {
            return results;
        }

        public List<String> getErrorMessages() {
            return errorMessages;
        }

        public boolean isNotFound() {
            return notFound;
        }

        public void setNotFound(boolean notFound) {
            this.notFound = notFound;
        }

        public void reverseResults() {
            Collections.reverse(results);
        }

        public boolean hasExtraParameters() {
            return hasExtraParameters;
        }

        public void setHasExtraParameters(boolean hasExtra) {
            this.hasExtraParameters = hasExtra;
        }

        public static class ResultEntry {
            private String keyword;
            private String pos;
            private String definition;

            public ResultEntry(String keyword, String pos, String definition) {
                this.keyword = keyword;
                this.pos = pos;
                this.definition = definition;
            }

            public String getKeyword() {
                return keyword;
            }

            public String getPos() {
                return pos;
            }

            public String getDefinition() {
                return definition;
            }

            @Override
            public String toString() {
                return String.format("%s [%s] : %s", keyword, pos, definition);
            }
        }
    }
}

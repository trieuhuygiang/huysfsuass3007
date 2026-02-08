import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private Map<String, List<DataSource>> entries;

    public Dictionary() {
        this.entries = new HashMap<>();
    }

    public void loadAll(Collection<DataSource> sources) {
        for (DataSource ds : sources) {
            String key = ds.getWord().toLowerCase();
            entries.computeIfAbsent(key, k -> new ArrayList<>()).add(ds);
        }
    }

    public List<DataSource> search(String key) {
        String normalized = key.toLowerCase();
        return entries.getOrDefault(normalized, Collections.emptyList());
    }

    public List<DataSource> search(String key, String partOfSpeech, boolean filterDistinct, boolean reverse) {
        List<DataSource> results = search(key);

        // Filter by part of speech if provided
        if (partOfSpeech != null && !partOfSpeech.isEmpty()) {
            results = results.stream()
                    .filter(ds -> ds.getType().equalsIgnoreCase(partOfSpeech))
                    .collect(Collectors.toList());
        }

        // Filter distinct definitions if requested
        if (filterDistinct) {
            Set<String> seenDefinitions = new HashSet<>();
            results = results.stream()
                    .filter(ds -> seenDefinitions.add(ds.getDefinition()))
                    .collect(Collectors.toList());
        }

        // Reverse results if requested
        if (reverse) {
            Collections.reverse(results);
        }

        return results;
    }

    public int getKeywordCount() {
        return entries.size();
    }

    public int getDefinitionCount() {
        return entries.values().stream().mapToInt(List::size).sum();
    }
}

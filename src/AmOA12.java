import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmOA12 {
    List<List<String>> threeKeyWordSuggestions(int numReviews, List<String> repository, String customerQuery) {
        List<List<String>> result = new ArrayList<>();
        if (repository == null || numReviews == 0 || customerQuery.length() < 2) {
            return result;
        }
        Collections.sort(repository);
        for (int i = 2; i <= customerQuery.length(); i++) {
            List<String> level = new ArrayList<>();
            String prefix = customerQuery.substring(0, i);
            for (int j = 0; j < numReviews; j++) {
                if (prefix.equalsIgnoreCase(repository.get(j).substring(0, i))) {
                    level.add(repository.get(j));
                    if (level.size() == 3) {
                        break;
                    }
                }
            }
            result.add(new ArrayList<>(level));
        }
        return result;
    }
}

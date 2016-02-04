import java.util.HashSet;
import java.util.Set;

public class Task22 {
	static int uniqueWordsCount(String[] words) {
		Set<String> uniqueWords = new HashSet<>();
		for (String word : words) {
			uniqueWords.add(word);
		}
		
		return uniqueWords.size();
	}
}

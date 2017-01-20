import java.util.ArrayList;
import java.util.List;

public class Library {
    String[] wordList;

    Library(String[] wordList) {
        this.wordList = wordList;
    }

    public List<Integer> getLetterCounts() {
        List<Integer> result = new ArrayList<>();
        for (String s : wordList) {
            if (s.equals("secret") || s.equals("hidden") || s.equals("shhh")) {
                result.add(-1);
            } else {
                result.add(s.length());
            }

        }
        return result;
    }
}

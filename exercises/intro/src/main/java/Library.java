import java.util.ArrayList;
import java.util.List;

public class Library {

    String[] args;

    public Library(String[] args) {
        this.args = args;
    }

    public List<Integer> getLetterCounts() {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            counts.add(args[i].length());
        }
        return counts;
    }

}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Library library = new Library(args);
        List<Integer> counts = library.getLetterCounts();
        for(int i = 0; i < args.length; i++) {
            logger.info(args[i] + "=" + counts.get(i));
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOps {

    /**
     * Returns true if provided function returns true for all elements, else false
     *
     * @param list A List of elements to test
     * @param func A Predicate function to test input List
     * @param <T> The type of element in the List
     * @return true if provided function returns true for all elements, else false
     */
    public static <T> boolean all(List<T> list, Predicate<T> func) {
        if(list == null) {
            throw new IllegalArgumentException("list must not be null");
        }
        if(func == null) {
            return true;
        }
        for(T item : list) {
            if(!func.test(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the provided function returns true for any element
     *
     * @param list A List of elements to test
     * @param func A Predicate function to test input List
     * @param <T> The type of element in the List
     * @return true if the provided function returns true for any element
     */
    public static <T> boolean any(List<T> list, Predicate<T> func) {
        if(list == null) {
            throw new IllegalArgumentException("list must not be null");
        }
        if(func == null) {
            return false;
        }
        if(list.isEmpty()) {
            return false;
        }
        for(T item : list) {
            if(func.test(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executes a Consumer function on all elements in input List
     *
     * @param list A List of elements to evaluate
     * @param func A Consumer function
     * @param <T> The type of element
     */
    public static <T> void forEach(List<T> list, Consumer<T> func) {
        if(list == null) {
            throw new IllegalArgumentException("list must not be null");
        }
        if(func == null) {
            return;
        }
        for(T item : list) {
            func.accept(item);
        }
    }

    /**
     * Returns a mapped List given an input List and a mapper Function
     *
     * @param list The list to map over
     * @param func The function to apply
     * @param <T> The type of elements in the List
     * @param <R> The type of elements in the output
     * @return a mapped List given an input List and a mapper Function
     */
    public static <T,R> List<R> map(List<T> list, Function<T,R> func) {
        if(list == null) {
            list = new ArrayList<T>();
        }
        if(func == null) {
            throw new IllegalArgumentException("func must not be null");
        }
        List<R> result = new ArrayList<R>();
        for(T item : list) {
            result.add(func.apply(item));
        }
        return result;
    }

    /**
     * Takes a list of words and returns the average length of all the words greater than ten characters long
     *
     * @param words The list of words
     * @return the average length of all the words greater than ten characters long
     */
    public static double stretchAverageLengthMoreThanTenLong(List<String> words) {
        List<String> filtered = words.stream()
                .filter(word -> word.length() > 10)
                .collect(Collectors.toList());
        if(filtered.isEmpty()) {
            return 0;
        }
        return (double)filtered.stream()
                .map(String::length)
                .reduce((acc, com) -> acc == null ? com : com + acc)
                .orElse(0) / filtered.size();
    }
}

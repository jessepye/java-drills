import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

public class Counter {
    public static IntSupplier createCounter() {
        final AtomicInteger count = new AtomicInteger();
        return count::getAndIncrement;
    }
}

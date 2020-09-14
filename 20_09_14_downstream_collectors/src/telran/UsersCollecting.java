package telran;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UsersCollecting<LogEntry> implements Collector<LogEntry, Set<LogEntry>, Integer> {
    @Override
    public Supplier<Set<LogEntry>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<LogEntry>, LogEntry> accumulator() {
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<LogEntry>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<LogEntry>, Integer> finisher() {
        return Set::size;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}

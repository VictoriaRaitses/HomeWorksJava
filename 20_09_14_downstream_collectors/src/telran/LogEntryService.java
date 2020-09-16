package telran;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class LogEntryService {

    public Map<String, Long> getAttendanceByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(log -> log.getUrl(), counting()));
    }

    public Map<String, Integer> getUniqueUsersNumberByUrl(List<LogEntry> logs) {
        return logs.stream()
                .collect(groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getUsername,
//                                collectingAndThen(toSet(), Set::size))
                                new UsersCollecting<>()
                        ))
                );
    }
}
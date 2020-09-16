package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueUsersCollectorTest {
    LogEntryService logEntryService = new LogEntryService();

    String oleg = "oleg";
    String nina = "Nina";
    String dima = "Dima";

    String url1 = "url1";
    String url2 = "url2";

    List<LogEntry> logs;


    @BeforeEach
    public void init() {
        logs = new ArrayList<>();
    }

    @Test
    void testGetUniqueUsersNumberByUrl_2() {
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url1, nina));

        assertEquals(2, logEntryService.getUniqueUsersNumberByUrl(logs).get(url1));
    }

    @Test
    void testGetUniqueUsersNumberByUrl_1() {
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url2, nina));

        assertEquals(1, logEntryService.getUniqueUsersNumberByUrl(logs).get(url1));
    }

    @Test
    void testGetUniqueUsersNumberByUrl_3() {
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url1, nina));
        logs.add(new LogEntry(url1, dima));

        assertEquals(3, logEntryService.getUniqueUsersNumberByUrl(logs).get(url1));
    }

    @Test
    void testGetUniqueUsersNumberByUrl_() {
        logs.add(new LogEntry(url1, oleg));
        logs.add(new LogEntry(url1, nina));
        logs.add(new LogEntry(url1, dima));
        logs.add(new LogEntry(url2, dima));

        assertEquals(1, logEntryService.getUniqueUsersNumberByUrl(logs).get(url2));
    }

}
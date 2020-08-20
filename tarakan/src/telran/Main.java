package telran;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
// Initialize scores list. Then initialize and start all tarakans.
// Then join all the tarakans. Then print the scores out.

        List<Score> scores = new ArrayList<>();
        Thread tarakan1 = new Thread(new Tarakan(10, "Schastlivchik", scores));
        Thread tarakan2 = new Thread(new Tarakan(10, "Pushok", scores));
        Thread tarakan3 = new Thread(new Tarakan(10, "Krasavchik", scores));

        tarakan1.start();
        tarakan2.start();
        tarakan3.start();

        tarakan1.join();
        tarakan2.join();
        tarakan3.join();

        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Place number: '" + (i + 1) + "' " + scores.get(i));
        }
    }
}
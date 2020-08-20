package telran;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable {

    private static final int FASTEST_STEP = 50;
    private static final int LONGEST_STEP = 100;

    int stepsNum;
    String name;
    List<Score> scores;
    Random random = new Random();

    public Tarakan(int stepsNum, String name, List<Score> scores) {
        this.stepsNum = stepsNum;
        this.name = name;
        this.scores = scores;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < stepsNum; i++) {
            int stepLength = FASTEST_STEP + random.nextInt(LONGEST_STEP - FASTEST_STEP + 1);

            try {
                Thread.sleep(stepLength);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int raceTime = (int) (System.currentTimeMillis() - startTime);
        scores.add(new Score(name, raceTime));
    }
}
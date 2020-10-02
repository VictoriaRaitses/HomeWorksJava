package telran;

public class Casino {

    public int stepsToWin(int N, int M) {
        int count = 0;
        while (N > 1) {
            if (N % 2 == 0 && M > 0) {
                N /= 2;
                M--;
            } else {
                N--;
            }
            count++;
        }
        return count;
    }
}


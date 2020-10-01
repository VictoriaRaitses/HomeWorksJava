package telran;

public class Casino {

    public int stepsToWin(int N, int M) {
        if (N == 1)
            return 0;

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (N % 2 != 0 && N != 1) {
                N--;
                count++;
            }
            N = N / 2;
            count++;
        }

        return N + count - 1;
    }
}

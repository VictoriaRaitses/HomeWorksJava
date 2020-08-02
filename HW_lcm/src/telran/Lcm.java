package telran;

public class Lcm {
    public long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long lcm(long a, long b, long c) {
        return lcm(a, lcm(b, c));
    }

    private long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

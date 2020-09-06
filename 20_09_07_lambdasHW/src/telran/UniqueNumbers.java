package telran;

public class UniqueNumbers implements TernaryIntPredicate {

    @Override
    public boolean test(int arg1, int arg2, int arg3) {
        if (arg1 == arg2 || arg2 == arg3 || arg1 == arg3) return false;
        return true;
    }

}

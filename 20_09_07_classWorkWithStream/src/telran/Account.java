package telran;

public class Account {
    String id;
    Long sum;
    Boolean isLocked;

    public Account(String id, Long sum, Boolean isLocked) {
        this.id = id;
        this.sum = sum;
        this.isLocked = isLocked;
    }

    public String getId() {
        return id;
    }

    public Long getSum() {
        return sum;
    }

    public Boolean getLocked() {
        return isLocked;
    }
}

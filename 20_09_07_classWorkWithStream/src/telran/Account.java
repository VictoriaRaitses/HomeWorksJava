package telran;

public class Account {
    private String id;
    private Long sum;
    private Boolean isLocked;

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

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", sum=" + sum +
                ", isLocked=" + isLocked +
                '}';
    }
}

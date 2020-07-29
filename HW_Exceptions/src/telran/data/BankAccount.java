package telran.data;

public class BankAccount {
    String iban;

    public BankAccount(String ibann) {
        this.iban = ibann;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "BankAccount( ibann: '" + iban + "')";
    }
}

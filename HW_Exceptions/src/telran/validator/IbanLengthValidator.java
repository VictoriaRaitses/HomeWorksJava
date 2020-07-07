package telran.validator;

import telran.data.Customer;
import telran.exceptions.TooShortIbannException;

public class IbanLengthValidator implements Validator {
    @Override
    public void validate(Customer customer) throws TooShortIbannException {
        if (customer.getAccount().getIban().length() < 16)
            throw new TooShortIbannException(customer.toString() + " this iban is too short");

    }
}

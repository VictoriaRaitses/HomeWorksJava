package telran.validator;

import telran.data.Customer;
import telran.exceptions.NonGermanBankAccountException;

public class CountryValidator implements Validator {
    @Override
    public void validate(Customer customer) throws NonGermanBankAccountException {
        String country = customer.getAccount().getIban().substring(0, 2);
        if (!country.equals("DE"))
            throw new NonGermanBankAccountException(customer.toString() + " this is not a germany iban");

    }
}

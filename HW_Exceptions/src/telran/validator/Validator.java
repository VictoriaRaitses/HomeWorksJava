package telran.validator;

import telran.data.Customer;
import telran.exceptions.NonGermanBankAccountException;
import telran.exceptions.TooShortIbannException;
import telran.exceptions.TooYoungCustomerException;

public interface Validator {

    void validate(Customer customer) throws TooYoungCustomerException,
            NonGermanBankAccountException,
            TooShortIbannException;
}

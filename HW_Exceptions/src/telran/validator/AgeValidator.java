package telran.validator;

import telran.data.Customer;
import telran.exceptions.TooYoungCustomerException;

public class AgeValidator implements Validator {
    @Override
    public void validate(Customer customer) throws TooYoungCustomerException {
        if (customer.getAge() < 17)
            throw new TooYoungCustomerException(customer.toString() + " is to young!");

    }
}

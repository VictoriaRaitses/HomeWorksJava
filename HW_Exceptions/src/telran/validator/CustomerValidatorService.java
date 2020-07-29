package telran.validator;

import telran.data.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidatorService {
    private List<Validator> validatorCollection;

    public CustomerValidatorService(List<Validator> validatorCallection) {
        this.validatorCollection = validatorCallection;
    }

    public List<String> validateCustomer(Customer customer) {
        List<String> notifications = new ArrayList<>();
        for (Validator validator : validatorCollection) {
            try {
                validator.validate(customer);
            } catch (Exception ex) {
                notifications.add(ex.getMessage());
            }
        }
        return notifications;
    }
}

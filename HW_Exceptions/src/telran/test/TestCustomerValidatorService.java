package telran.test;

import org.junit.Assert;
import org.junit.Test;
import telran.data.BankAccount;
import telran.data.Customer;
import telran.exceptions.NonGermanBankAccountException;
import telran.exceptions.TooShortIbannException;
import telran.exceptions.TooYoungCustomerException;
import telran.validator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCustomerValidatorService {

    List<Validator> validatorCollection = Arrays.asList(
            new AgeValidator(),
            new CountryValidator(),
            new IbanLengthValidator()
    );

    CustomerValidatorService customerValidatorService = new CustomerValidatorService(validatorCollection);

    @Test
    public void testValidateCustomer() {
        Customer suitableСustomer = new Customer("Ivanov", 18, new BankAccount("DE48558645689456"));

        Assert.assertEquals(new ArrayList<>()
                , customerValidatorService.validateCustomer(suitableСustomer));

    }

    @Test(expected = TooYoungCustomerException.class)
    public void testAgeValidator() throws TooYoungCustomerException {
        Customer customer = new Customer("Ivanov", 16, new BankAccount("DE48558645689456"));

        AgeValidator ageValidator = new AgeValidator();
        ageValidator.validate(customer);
    }

    @Test(expected = TooShortIbannException.class)
    public void testIbanLengthValidator() throws TooShortIbannException {
        Customer customer = new Customer("Ivanov", 18, new BankAccount("DE4855864568"));

        IbanLengthValidator ibanLengthValidator = new IbanLengthValidator();
        ibanLengthValidator.validate(customer);
    }

    @Test(expected = NonGermanBankAccountException.class)
    public void testCountryValidator() throws NonGermanBankAccountException {
        Customer customer = new Customer("Ivanov", 18, new BankAccount("DO48558645685647"));

        CountryValidator countryValidator = new CountryValidator();
        countryValidator.validate(customer);
    }
}

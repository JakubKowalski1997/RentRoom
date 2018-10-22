package com.rentaroom.rentaroom.user;

import com.rentaroom.rentaroom.login.User;
import com.rentaroom.rentaroom.login.UserValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserValidatorTest {

    @Autowired
    private UserValidator userValidator;

    @Test
    public void emptyUsernameField() {
        User invalidUser = new User();
        invalidUser.setId(1L);
        invalidUser.setUsername("");
        invalidUser.setPassword("dupa123");
        invalidUser.setPasswordConfirm("dupa123");

        Errors errors = new BeanPropertyBindingResult(invalidUser, "invalidUser");
        userValidator.validate(invalidUser, errors);

        FieldError usernameFieldError = errors.getFieldError("username");
        assertThat("username", is(usernameFieldError.getField()));

        List<String> errorCodes = Arrays.asList(usernameFieldError.getCodes());
        assertThat(4, is(errorCodes.size()));
        assertTrue(errorCodes.contains("NotEmpty.invalidUser.username"));
        assertTrue(errorCodes.contains("NotEmpty.username"));
        assertTrue(errorCodes.contains("NotEmpty.java.lang.String"));
        assertTrue(errorCodes.contains("NotEmpty"));
    }

    @Test
    public void usernameLengthUpperBoundaryTesting() {
        User invalidUser = new User();
        invalidUser.setId(1L);
        invalidUser.setUsername("fapllllololololololololollololss2");
        invalidUser.setPassword("faplllosss");
        invalidUser.setPasswordConfirm("faplllosss");

        Errors errors = new BeanPropertyBindingResult(invalidUser, "invalidUser");
        userValidator.validate(invalidUser, errors);

        FieldError usernameFieldError = errors.getFieldError("username");
        assertThat("username", is(usernameFieldError.getField()));
        List<String> usernameErrorCodes = Arrays.asList(usernameFieldError.getCodes());
        assertThat(4, is(usernameErrorCodes.size()));

        assertTrue(usernameErrorCodes.contains("Size.userForm.username.invalidUser.username"));
        assertTrue(usernameErrorCodes.contains("Size.userForm.username"));
        assertTrue(usernameErrorCodes.contains("Size.userForm.username.java.lang.String"));
        assertTrue(usernameErrorCodes.contains("Size.userForm.username"));

        User validUser = new User();
        validUser.setId(1L);
        validUser.setUsername("fapllllololololololololollololss");
        validUser.setPassword("faplllosss");
        validUser.setPasswordConfirm("faplllosss");

        Errors errorsValid = new BeanPropertyBindingResult(validUser, "validUser");
        userValidator.validate(validUser, errorsValid);
        assertNull(errorsValid.getFieldError("username"));
    }
}

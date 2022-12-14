package com.marktProject.GroceryMarket.validations;

import com.marktProject.GroceryMarket.annotation.SecuredPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecuredPasswordValidator implements ConstraintValidator<SecuredPassword, String> {

    @Override
    public void initialize(SecuredPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8,30),   // min 8, max 30
                new CharacterRule(EnglishCharacterData.UpperCase, 1),   // at least 1 uppercase
                new CharacterRule(EnglishCharacterData.LowerCase, 1),   // at least 1 lowercase
                new CharacterRule(EnglishCharacterData.Digit, 1),       // at least 1 number
                new CharacterRule(EnglishCharacterData.Special, 1),     // at least 1 special character
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid())
            return true;

        List<String> messages = validator.getMessages(result);

        String errors = messages.stream()
                .collect(Collectors.joining(" "));

        context.buildConstraintViolationWithTemplate(errors)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}

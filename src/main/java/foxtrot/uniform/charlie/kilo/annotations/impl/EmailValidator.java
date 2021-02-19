package foxtrot.uniform.charlie.kilo.annotations.impl;

import foxtrot.uniform.charlie.kilo.annotations.ValidateEmail;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {
    private static final String EMAIL_PATTERN = "\\w+@[a-z]+.[a-z]+";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(EMAIL_PATTERN);
    }
}

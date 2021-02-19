package foxtrot.uniform.charlie.kilo.annotations.impl;

import foxtrot.uniform.charlie.kilo.annotations.ValidatePassword;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, Object> {
    private String password;
    private String repeatPassword;

    @Override
    public void initialize(ValidatePassword constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.repeatPassword = constraintAnnotation.repeatPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object field = new BeanWrapperImpl(o).getPropertyValue(password);
        Object repeatField = new BeanWrapperImpl(o).getPropertyValue(repeatPassword);
        return field != null && field.equals(repeatField);
    }
}

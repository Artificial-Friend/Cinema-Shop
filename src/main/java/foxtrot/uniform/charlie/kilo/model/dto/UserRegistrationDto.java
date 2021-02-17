package foxtrot.uniform.charlie.kilo.model.dto;

import foxtrot.uniform.charlie.kilo.annotations.ValidateEmail;
import foxtrot.uniform.charlie.kilo.annotations.ValidatePassword;
import javax.validation.constraints.Size;

@ValidatePassword(password = "password", repeatPassword = "repeatPassword",
        message = "Passwords do not match!")
public class UserRegistrationDto {
    @ValidateEmail
    private String email;
    @Size(min = 5, max = 16)
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" + "email='" + email + '\''
                + ", password='" + password + '\'' + '}';
    }
}

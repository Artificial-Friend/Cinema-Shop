package foxtrot.uniform.charlie.kilo.model.dto;

import org.springframework.lang.NonNull;

public class UserRequestDto {
    @NonNu
    private String email;

    private String password;

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

    @Override
    public String toString() {
        return "UserRequestDto{" + "email='" + email + '\''
                + ", password='" + password + '\'' + '}';
    }
}
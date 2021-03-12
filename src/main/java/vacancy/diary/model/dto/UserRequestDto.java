package vacancy.diary.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vacancy.diary.lib.EmailValidator;
import vacancy.diary.lib.PasswordValidator;

@PasswordValidator(message = "Passwords are different")
public class UserRequestDto {
    @EmailValidator
    private String email;
    @NotNull
    @Size(min = 6)
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}

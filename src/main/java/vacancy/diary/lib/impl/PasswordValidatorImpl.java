package vacancy.diary.lib.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vacancy.diary.lib.PasswordValidator;
import vacancy.diary.model.dto.UserRequestDto;

public class PasswordValidatorImpl
        implements ConstraintValidator<PasswordValidator, UserRequestDto> {
    @Override
    public boolean isValid(UserRequestDto userRequestDto,
                           ConstraintValidatorContext constraintValidatorContext) {
        return userRequestDto != null && userRequestDto.getPassword() != null
                && userRequestDto.getPassword().equals(userRequestDto.getRepeatPassword());
    }
}

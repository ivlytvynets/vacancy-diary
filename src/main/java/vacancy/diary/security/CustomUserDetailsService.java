package vacancy.diary.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vacancy.diary.model.User;
import vacancy.diary.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserService userService,
                                    PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found."));
        UserBuilder userBuilder = withUsername(username);
        userBuilder.password(passwordEncoder.encode(user.getPassword()));
        userBuilder.roles("USER");
        return userBuilder.build();
    }
}

package vacancy.diary.security;

import vacancy.diary.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}

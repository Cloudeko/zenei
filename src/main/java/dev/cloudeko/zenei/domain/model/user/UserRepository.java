package dev.cloudeko.zenei.domain.model.user;

import java.util.Optional;

public interface UserRepository {

    void createUser(User user);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);
}

package dev.cloudeko.zenei.infrastructure.provider;

import dev.cloudeko.zenei.domain.provider.HashProvider;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BCryptHashProvider implements HashProvider {

    @Override
    public String hashPassword(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    @Override
    public boolean checkPassword(String plaintext, String hashed) {
        return BcryptUtil.matches(plaintext, hashed);
    }
}

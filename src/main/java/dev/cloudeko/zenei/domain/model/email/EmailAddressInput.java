package dev.cloudeko.zenei.domain.model.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailAddressInput {
    private EmailAddress emailAddress;
}

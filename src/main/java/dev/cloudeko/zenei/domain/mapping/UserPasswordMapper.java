package dev.cloudeko.zenei.domain.mapping;

import dev.cloudeko.zenei.domain.model.user.UserPassword;
import dev.cloudeko.zenei.infrastructure.repository.hibernate.entity.UserPasswordEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = QuarkusMappingConfig.class, uses = UserMapper.class)
public interface UserPasswordMapper {

    List<UserPassword> toDomainList(List<UserPasswordEntity> entities);

    UserPassword toDomain(UserPasswordEntity entity);

    void updateDomainFromEntity(UserPasswordEntity entity, @MappingTarget UserPassword domain);
}

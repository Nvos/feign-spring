package com.czort.app.backend;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(source = "name", target = "username")
    public User fromEntity(UserEntity entity);

    @Mapping(source = "username", target = "name")
    public UserEntity fromDto(User user);

    @Mapping(source = "username", target = "name")
    public void toEntity(User source, @MappingTarget UserEntity target);
}

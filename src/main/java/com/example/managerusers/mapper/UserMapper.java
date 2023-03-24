package com.example.managerusers.mapper;

import com.example.managerusers.dto.PatchUserDTO;
import com.example.managerusers.dto.UserDTO;
import com.example.managerusers.dto.UserInDTO;
import com.example.managerusers.models.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO asUserDTO(User user);

    User asUser(UserInDTO user);

    @Mappings({@Mapping(target = "id", source = "id"),})
    User asUserIdInDTO(Long id, UserInDTO userInDTO);

    @Mappings({
            @Mapping(target = "id", source = "id"),
    })
    User asUserIdPatchDTO(Long id, PatchUserDTO patchUserDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(@MappingTarget User user, PatchUserDTO patchUserDTO);

    /*
    @Mappings({
            @Mapping(target = "metadata.itemsFrom", source = "src.itemsFrom"),
            @Mapping(target = "metadata.itemsTo", source = "src.itemsTo"),
            @Mapping(target = "metadata.itemsTotal", source = "src.itemsTotal"),
            @Mapping(target = "metadata.itemsCount", source = "src.itemsCount")
    })
    StoresPaginatedDTO asStoresPaginated(StoresPaginatedViewObject src);
    */
}

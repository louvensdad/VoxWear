package com.ldcn.git.user_service.Mapper;

import com.ldcn.git.user_service.dto.UserRequestDTO;
import com.ldcn.git.user_service.dto.UserResponseDTO;
import com.ldcn.git.user_service.model.User;

public class UsuarioMapper {

    public static UserResponseDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTelefone()
        );
    }

    public static User toEntity(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) {
            return null;
        }
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setTelefone(userRequestDTO.getTelefone());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }
}

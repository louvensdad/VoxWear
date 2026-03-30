package com.ldcn.git.user_service.service;

import org.springframework.stereotype.Service;

import com.ldcn.git.user_service.Mapper.UsuarioMapper;
import com.ldcn.git.user_service.dto.UserRequestDTO;
import com.ldcn.git.user_service.dto.UserResponseDTO;
import com.ldcn.git.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

public UserResponseDTO createUser (UserRequestDTO userRequestDTO) {
    var user = UsuarioMapper.toEntity(userRequestDTO);
    var savedUser = userRepository.save(user);
    return UsuarioMapper.toDTO(savedUser);
  }

  public UserResponseDTO getUserByEmail(String email) {
    var user = userRepository.findByEmail(email);
    return UsuarioMapper.toDTO(user);
  }

  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }
}
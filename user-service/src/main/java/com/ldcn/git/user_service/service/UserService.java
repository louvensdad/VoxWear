package com.ldcn.git.user_service.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder passwordEncoderencoder = new BCryptPasswordEncoder();

public UserResponseDTO createUser (UserRequestDTO userRequestDTO) {

  if (userRepository.findByEmail(userRequestDTO.getEmail()) != null) {
    
  }
    var user = UsuarioMapper.toEntity(userRequestDTO);
    user.setPassword(passwordEncoderencoder.encode(user.getPassword()));
    var savedUser = userRepository.save(user);
    return UsuarioMapper.toDTO(savedUser);
  }

  public UserResponseDTO getUserByEmail(String email) {
    var user = userRepository.findByEmail(email)
   .orElseThrow (()-> new RuntimeException("User not found" + email));
    return UsuarioMapper.toDTO(user);
  }

  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }
}
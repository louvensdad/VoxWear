package com.ldcn.git.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String phone;
    private double height;
    private double weight;
    private String password;

}

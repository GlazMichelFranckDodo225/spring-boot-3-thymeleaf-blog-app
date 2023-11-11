package com.dgmf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserForm {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String address;
    private boolean married;
    private String profession;
}

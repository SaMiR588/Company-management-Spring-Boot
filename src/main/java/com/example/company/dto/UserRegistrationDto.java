package com.example.company.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private int userId;
    private String UserName;
    private String email;
    private String adress;
    private int mobile;
    private String password;

    public UserRegistrationDto() {

    }
    public UserRegistrationDto(int userId, String userName, String email, String adress, int mobile,
                               String password) {
        super();
        this.userId = userId;
        UserName = userName;
        this.email = email;
        this.adress = adress;
        this.mobile = mobile;
        this.password = password;
    }

}

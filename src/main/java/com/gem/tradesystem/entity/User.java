package com.gem.tradesystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private Integer account;
    private Date regTime;
}

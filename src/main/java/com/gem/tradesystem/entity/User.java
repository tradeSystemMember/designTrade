package com.gem.tradesystem.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private Integer account;
    private Date regTime;
    private String sex;
    private String avatar;
}

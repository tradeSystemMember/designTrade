package com.gem.tradesystem.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Sucai {
    private Integer id;
    private String num;
    private String name;
    private Integer money;
    private Integer downnum;
    private Integer favnum;
    private Integer tagid;
    private String suffix;
    private String size;
    private String pix;
    private Integer picid;
    private Date createtime;
    private String author;
    private String save;
}

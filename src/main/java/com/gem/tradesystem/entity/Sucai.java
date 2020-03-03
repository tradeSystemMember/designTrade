package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.util.Date;
@Data
@TableName("sucai")
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private String author;
    private String save;
    private String description;
}

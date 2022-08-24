package com.tintuc.dunews.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     @Column
    private Date createDate;
    @Column
    private Date updateDate;
     @Column
    private Long idCreateUser;

}

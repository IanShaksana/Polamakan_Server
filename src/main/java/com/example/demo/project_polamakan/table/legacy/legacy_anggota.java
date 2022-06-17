package com.example.demo.project_polamakan.table.legacy;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

@Entity
@Getter
@Setter

public class legacy_anggota {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 50)
    private String id;

    @Column(length = 50)
    private String noMember;
    
    @Column(columnDefinition = "LONGTEXT")
    private String jsonencode;
    @Column(length = 50)
    private Integer version;
    @Column(columnDefinition = "DATETIME")
    private Date createdAt;
    
    
}
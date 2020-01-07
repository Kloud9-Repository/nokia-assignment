package com.nokia.image.store.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALBUM")
public class Album {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @CreationTimestamp
    private Date createTime;
    private int status=1;
}

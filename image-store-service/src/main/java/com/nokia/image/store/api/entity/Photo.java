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
@Table(name = "PHOTO")
public class Photo {
    @Id
    @GeneratedValue
    private int id;
    private String imageURL;
    private Integer status=1;
    private int albumId;
    @CreationTimestamp
    private Date createTime;
}

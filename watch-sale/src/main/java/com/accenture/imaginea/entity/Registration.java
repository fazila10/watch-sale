package com.accenture.imaginea.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="registration")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int regId;

    @CreationTimestamp
    private Date regTime;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "userId",unique = true)
    private User user;

}

package com.scaler.userservicesept25.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
    private Long id; // Unique identifier for the model

    @CreatedDate
    private Date createdAt; // Timestamp for when the model was created

    @LastModifiedDate
    private Date lastUpdatedAt; // Timestamp for when the model was last updated

    @CreatedBy
    private String createdBy; // Identifier for the user who created the model

    private State state; // State of the model (e.g., ACTIVE, INACTIVE)
}

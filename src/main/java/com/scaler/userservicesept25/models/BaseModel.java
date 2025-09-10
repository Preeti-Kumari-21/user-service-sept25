package com.scaler.userservicesept25.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENT
    private Long id; // Unique identifier for the model

    private Date createdAt; // Timestamp for when the model was created

    private Date lastUpdatedAt; // Timestamp for when the model was last updated

    private String createdBy; // Identifier for the user who created the model

    private State state; // State of the model (e.g., ACTIVE, INACTIVE)
}

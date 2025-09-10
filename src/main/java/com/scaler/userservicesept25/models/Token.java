package com.scaler.userservicesept25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "tokens")
public class Token extends BaseModel{
    private String value;
    private Date expiryDate;

    @ManyToOne
    private User user;
}

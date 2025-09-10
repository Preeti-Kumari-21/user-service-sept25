package com.scaler.userservicesept25.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "role")
public class Role extends BaseModel {

    private String roleName;

    //if needed we will add list of role permissions in future
}

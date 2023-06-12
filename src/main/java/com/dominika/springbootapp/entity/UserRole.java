package com.dominika.springbootapp.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
    @EmbeddedId
    private UserRolesKey userRolesKey;

    public UserRole(User user, Role role) {
        this.userRolesKey = new UserRolesKey(user.getId(), role.getId());
    }
}

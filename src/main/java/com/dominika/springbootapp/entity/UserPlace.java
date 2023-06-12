package com.dominika.springbootapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_places")
public class UserPlace {
    @EmbeddedId
    private UserPlacesKey userPlacesKey;

    private boolean shared;

    public UserPlace(User user, Place place, boolean shared) {
        this.userPlacesKey = new UserPlacesKey(user.getId(), place.getId());
        this.shared = shared;
    }

    public UserPlace(){}

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}

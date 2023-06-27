package com.dominika.springbootapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_places")
public class UserPlace {
    @EmbeddedId
    private UserPlacesKey userPlacesKey;


    public UserPlace(User user, Place place) {
        this.userPlacesKey = new UserPlacesKey(user.getId(), place.getId());
    }

    public UserPlace(){}


}

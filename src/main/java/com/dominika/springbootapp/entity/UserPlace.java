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

    public UserPlacesKey getUserPlacesKey() {
        return userPlacesKey;
    }

    public void setUserPlacesKey(UserPlacesKey userPlacesKey) {
        this.userPlacesKey = userPlacesKey;
    }

    @Override
    public String toString() {
        return "UserPlace{" +
                "userPlacesKey=" + userPlacesKey +
                '}';
    }
}

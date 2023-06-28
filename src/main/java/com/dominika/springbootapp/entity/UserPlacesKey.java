package com.dominika.springbootapp.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPlacesKey {

    private Long userId;
    private Long placeId;

    public UserPlacesKey() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public UserPlacesKey(Long userId, Long placeId) {
        this.userId = userId;
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "UserPlacesKey{" +
                "userId=" + userId +
                ", placeId=" + placeId +
                '}';
    }
}

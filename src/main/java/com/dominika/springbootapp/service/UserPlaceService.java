package com.dominika.springbootapp.service;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.entity.UserPlace;
import com.dominika.springbootapp.repository.UserPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPlaceService {
    UserPlaceRepository repository;

    @Autowired
    public UserPlaceService(UserPlaceRepository repository) {
        this.repository = repository;
    }

    public void saveUserPlace(User user, Place place) {
        repository.save(new UserPlace(user, place));
    }
}

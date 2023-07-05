package com.dominika.springbootapp.service;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.entity.UserPlace;
import com.dominika.springbootapp.repository.PlaceRepository;
import com.dominika.springbootapp.repository.UserPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserPlaceService {
    PlaceRepository placeRepository;
    UserPlaceRepository userPlaceRepository;

    @Autowired
    public UserPlaceService(UserPlaceRepository userPlaceRepository, PlaceRepository placeRepository) {
        this.userPlaceRepository = userPlaceRepository;
        this.placeRepository = placeRepository;
    }

    public List<Place> findUserPlaces(Long userId) {
        List<UserPlace> userPlaces = userPlaceRepository.findUserPlaces(userId);
        List<Long> ids = new LinkedList<>();
        for(UserPlace up : userPlaces) {
            ids.add(up.getUserPlacesKey().getPlaceId());
        }
        List<Place> places = new LinkedList<>();
        for(UserPlace up : userPlaces) {
            places = placeRepository.findAllById(ids);
        }
        return places;
    }
    public void saveUserPlace(User user, Place place) {
        userPlaceRepository.save(new UserPlace(user, place));
    }

    public int countUserPlaces(User user) {
        return userPlaceRepository.countUserPlaces(user.getId());
    }

    public int countSharedPlaces() {
        return placeRepository.countSharedPlaces();
    }

}

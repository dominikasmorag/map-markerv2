package com.dominika.springbootapp.service;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    PlaceRepository placeRepository;
    UserService userService;
    UserPlaceService userPlaceService;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, UserService userService, UserPlaceService userPlaceService) {
        this.placeRepository = placeRepository;
        this.userService = userService;
        this.userPlaceService = userPlaceService;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public List<Place> getUserPlaces(Long userId) { return userPlaceService.findUserPlaces(userId);}

    public void savePlace(Place place) {
        Place newPlace = placeRepository.save(place);
        User user = userService.currentUser();
        userPlaceService.saveUserPlace(user, newPlace);
    }

    public List<Place> findSharedPlaces() {
        return placeRepository.findSharedPlaces();
    }
}

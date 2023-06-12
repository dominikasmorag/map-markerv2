package com.dominika.springbootapp.service;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    PlaceRepository repository;

    @Autowired
    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public List<Place> getPlaces() {
        return repository.findAll();
    }

    public void savePlace(Place place) {
        repository.save(place);
    }

}

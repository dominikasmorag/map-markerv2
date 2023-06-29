package com.dominika.springbootapp.repository;

import com.dominika.springbootapp.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p WHERE p.shared=true")
    List<Place> findSharedPlaces();
}

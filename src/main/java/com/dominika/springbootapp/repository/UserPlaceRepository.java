package com.dominika.springbootapp.repository;

import com.dominika.springbootapp.entity.UserPlace;
import com.dominika.springbootapp.entity.UserPlacesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPlaceRepository extends JpaRepository<UserPlace, UserPlacesKey> {

    @Query("SELECT up FROM UserPlace up WHERE up.userPlacesKey.userId = :userId")
    List<UserPlace> findUserPlaces(@Param("userId") Long userId);

    @Query("SELECT COUNT(*) FROM UserPlace up WHERE up.userPlacesKey.userId = :userId")
    int countUserPlaces(@Param("userId") Long userId);
}

package com.dominika.springbootapp.repository;

import com.dominika.springbootapp.entity.UserPlace;
import com.dominika.springbootapp.entity.UserPlacesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlaceRepository extends JpaRepository<UserPlace, UserPlacesKey> {
}

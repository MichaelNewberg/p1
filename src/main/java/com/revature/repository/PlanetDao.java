package com.revature.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Planet;

public interface PlanetDao extends JpaRepository<Planet, Integer>{

	Optional<Planet> findByName(String planetName);
    
	
    @Transactional
    @Modifying 
    @Query(value= "insert into planets values (default, :name , :ownerId)", nativeQuery = true)
    void createPlanet(@Param("name") String name, @Param("ownerId") int ownerId);

	@Transactional
    @Modifying 
    @Query(value= "update planets set name = :name , owner_Id = :ownerId where planet_id = :id", nativeQuery = true)
    int updatePlanet(@Param("name") String name, @Param("ownerId") int ownerId);
}



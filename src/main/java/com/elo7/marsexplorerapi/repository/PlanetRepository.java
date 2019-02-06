package com.elo7.marsexplorerapi.repository;
import com.elo7.marsexplorerapi.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

}

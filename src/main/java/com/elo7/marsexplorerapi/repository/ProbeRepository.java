package com.elo7.marsexplorerapi.repository;
import com.elo7.marsexplorerapi.model.Probe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends CrudRepository<Probe, Long> {
}

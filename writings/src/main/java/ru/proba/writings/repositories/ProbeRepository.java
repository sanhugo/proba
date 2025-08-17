package ru.proba.writings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.writings.model.Probe;

@Repository
public interface ProbeRepository extends JpaRepository<Probe, Integer> {
}

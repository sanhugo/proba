package ru.proba.writings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.writings.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}

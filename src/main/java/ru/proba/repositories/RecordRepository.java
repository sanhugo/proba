package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}

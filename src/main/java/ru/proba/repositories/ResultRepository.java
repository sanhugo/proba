package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
}

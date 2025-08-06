package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proba.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}

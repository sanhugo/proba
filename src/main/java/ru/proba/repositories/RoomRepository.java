package ru.proba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.proba.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("select count(b) from Room b where b.active = true and b.building.id=:buildingId")
    long countByBuilding_ActiveTrue(Long buildingId);
}

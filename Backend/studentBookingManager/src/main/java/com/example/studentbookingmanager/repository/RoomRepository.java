package com.example.studentbookingmanager.repository;

import com.example.studentbookingmanager.module.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

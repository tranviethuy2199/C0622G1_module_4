package com.example.repository.FacilityRepo;

import com.example.model.facility.StandardRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardRoomRepository extends JpaRepository<StandardRoom, Integer> {
}

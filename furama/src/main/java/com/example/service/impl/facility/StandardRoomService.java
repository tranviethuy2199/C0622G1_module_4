package com.example.service.impl.facility;

import com.example.model.facility.StandardRoom;
import com.example.repository.FacilityRepo.StandardRoomRepository;
import com.example.service.IFacility.IStandardRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardRoomService implements IStandardRoomService {

    @Autowired
    private StandardRoomRepository standardRoomRepository;

    @Override
    public List<StandardRoom> findAll() {
        return standardRoomRepository.findAll();
    }

    @Override
    public StandardRoom findById(int id) {
        return standardRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void save(StandardRoom standardRoom) {
        standardRoomRepository.save(standardRoom);
    }

    @Override
    public void remove(StandardRoom standardRoom) {
        standardRoomRepository.delete(standardRoom);
    }
}

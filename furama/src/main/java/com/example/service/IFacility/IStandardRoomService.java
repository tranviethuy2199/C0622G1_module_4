package com.example.service.IFacility;

import com.example.model.facility.StandardRoom;

import java.util.List;

public interface IStandardRoomService {
    List<StandardRoom> findAll();

    StandardRoom findById(int id);

    void save(StandardRoom standardRoom);

    void remove(StandardRoom standardRoom);
}

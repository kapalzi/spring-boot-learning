package com.kapala.gifts.dao;

import com.kapala.gifts.model.Present;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PresentDao {

    int insertPresent(UUID id, Present present);

    default  int insertPresent(Present present) {
        UUID id = UUID.randomUUID();
        return  insertPresent(id, present);
    }

    List<Present> selectAllPresents();

    Optional<Present> selectPresentById(UUID id);

    int deletePresentById(UUID id);

    int updatePersonById(UUID id, Present present);
}

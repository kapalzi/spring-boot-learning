package com.kapala.gifts.service;

import com.kapala.gifts.dao.PresentDao;
import com.kapala.gifts.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PresentService {

    private  final PresentDao presentDao;

    @Autowired
    public PresentService(@Qualifier("fakeDao") PresentDao presentDao) {
        this.presentDao = presentDao;
    }

    public int addPresent(Present present) {
        return presentDao.insertPresent(present);
    }

    public List<Present> getAllPresents() {
        return presentDao.selectAllPresents();
    }

    public Optional<Present> getPresentById(UUID id) {
        return presentDao.selectPresentById(id);
    }

    public int deletePresent(UUID id) {
        return presentDao.deletePresentById(id);
    }

    public int updatePresent(UUID id, Present newPresent) {
        return presentDao.updatePersonById(id, newPresent);
    }
}

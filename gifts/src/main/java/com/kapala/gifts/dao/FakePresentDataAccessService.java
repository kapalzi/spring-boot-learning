package com.kapala.gifts.dao;

import com.kapala.gifts.model.Present;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePresentDataAccessService implements PresentDao {

    private static List<Present> DB = new ArrayList<>();

    @Override
    public int insertPresent(UUID id, Present present) {
        DB.add(new Present(id, present.getTitle(), present.getDepiction(), present.getQuantity(), present.getPrice(), present.getCategoryId(), present.getLink(), present.getIsReserved(), present.getRegistry()));
        return 1;
    }

    @Override
    public List<Present> selectAllPresents() {
        return DB;
    }

    @Override
    public Optional<Present> selectPresentById(UUID id) {
        return DB.stream()
                .filter(present -> present.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePresentById(UUID id) {
        Optional<Present> presentMaybe = selectPresentById(id);
        if (presentMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(presentMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Present presentToUpdate) {
        return selectPresentById(id)
                .map(present -> {
                    int indexOfPresentToUpdate = DB.indexOf(present);
                    if (indexOfPresentToUpdate >= 0) {
                        DB.set(indexOfPresentToUpdate, new Present(id, presentToUpdate.getTitle(), presentToUpdate.getDepiction(), presentToUpdate.getQuantity(), presentToUpdate.getPrice(), presentToUpdate.getCategoryId(), presentToUpdate.getLink(), presentToUpdate.getIsReserved(), presentToUpdate.getRegistry()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}

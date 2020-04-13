package com.kapala.gifts.api;

import com.kapala.gifts.dao.PresentDao;
import com.kapala.gifts.model.Present;
import com.kapala.gifts.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/present")
@RestController
public class PresentController {

    private final PresentService presentService;

    @Autowired
    public PresentController(PresentService presentService) {
        this.presentService = presentService;
    }

    @PostMapping
    public int addPresent(@Valid @NonNull @RequestBody Present present) {
        return presentService.addPresent(present);
    }

    @GetMapping
    public List<Present> getAllPresents() {

        return presentService.getAllPresents();
    }

    @GetMapping(path = "{id}")
    public Present getPresentById(@PathVariable("id") UUID id) {
        return presentService.getPresentById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePresentById(@PathVariable("id") UUID id) {
        presentService.deletePresent(id);
    }

    @PutMapping(path = "{id}")
    public void updatePresent(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Present presentToUpdate) {
        presentService.updatePresent(id, presentToUpdate);
    }

}

package com.example.touriste.Controllers;

import com.example.touriste.Entities.Activite;
import com.example.touriste.Services.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activites")
public class ActiviteController {
    @Autowired
    private ActiviteService activiteService ;

    @GetMapping("/")
    public List<Activite> getAllActivites() {

        return activiteService.findAllActivites();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Activite> getActiviteById(@PathVariable Long id) {
        Activite activite = activiteService.findActiviteById(id);
        return ResponseEntity.ok(activite);
    }

    @PostMapping("/")
    public ResponseEntity<Activite> createActivite(@RequestBody Activite activite) {
        Activite newActivite = activiteService.saveActivite(activite);
        return ResponseEntity.status(HttpStatus.CREATED).body(newActivite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Long id) {
        activiteService.deleteActivite(id);
        return ResponseEntity.noContent().build();
    }



}

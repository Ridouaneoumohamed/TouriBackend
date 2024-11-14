package com.example.touriste.Services;
import com.example.touriste.Repositories.ActiviteRepository;
import java.util.List;
import com.example.touriste.Entities.Activite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    public List<Activite> findAllActivites() {
        return activiteRepository.findAll();
    }

    public Activite findActiviteById(Long id) {
        return activiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activité non trouvée avec l'ID : " + id));
    }

    public Activite saveActivite(Activite activite) {

        return activiteRepository.save(activite);
    }



    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }
}

package org.xproce.pfaram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xproce.pfaram.entity.Rapport;
import org.xproce.pfaram.repository.RapportRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RapportServiceImpl implements RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public List<Rapport> findAllRapports() {
        return rapportRepository.findAll();
    }

    @Override
    public Rapport findRapportById(Long id) {
        Optional<Rapport> optionalRapport = rapportRepository.findById(id);
        return optionalRapport.orElse(null);
    }

    @Override
    public Rapport saveRapport(Rapport rapport) {
        rapport.setDateCreation(LocalDateTime.now()); // Définir la date de création
        return rapportRepository.save(rapport);
    }

    @Override
    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }

    public static String truncateWords(String text, int wordCount) {
        String[] words = text.split(" ");
        if (words.length <= wordCount) {
            return text;
        }
        return String.join(" ", Arrays.copyOfRange(words, 0, wordCount)) + "...";
    }
}

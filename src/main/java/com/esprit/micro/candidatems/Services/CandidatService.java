package com.esprit.micro.candidatems.Services;
import com.esprit.micro.candidatems.Repositories.CandidatRepository;
import com.esprit.micro.candidatems.entities.Candidat;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidateRepository;
    public Candidat addCandidat(Candidat candidate) {
        return candidateRepository.save(candidate);
    }
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {
            Candidat existingCandidat = candidateRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidateRepository.save(existingCandidat);
        } else
            return null;
    }
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}

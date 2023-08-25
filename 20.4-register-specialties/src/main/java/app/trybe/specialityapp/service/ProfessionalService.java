package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * The type Professional service.
 */
@Service
@Component
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository professionalRepository;

  /**
   * Gets all professionals.
   *
   * @return the all professionals
   */
  public List<Professional> getAllProfessionals() {
    return professionalRepository.findAll();
  }

  /**
   * Add professional professional.
   *
   * @param professional the professional
   * @return the professional
   */
  public Professional addProfessional(Professional professional) {
    return professionalRepository.save(professional);
  }

  /**
   * Método update.
   */
  public Boolean editProfessional(Integer id, Professional professional) {
    if (professionalRepository.findById(id).isPresent()) {
      Professional professionalToEdit = professionalRepository.findById(id).get();
      professionalToEdit.setName(professional.getName());
      professionalToEdit.setSpeciality(professional.getSpeciality());
      return true;
    } else {
      return false;
    }

  }

  /**
   * Delete professional.
   *
   * @param id the id
   */
  public Boolean deleteProfessional(Integer id) {
    if (professionalRepository.findById(id).isPresent()) {
      professionalRepository.deleteById(id);
      return true;
    }
    return false;
  }

}

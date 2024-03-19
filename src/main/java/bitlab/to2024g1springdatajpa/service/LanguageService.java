package bitlab.to2024g1springdatajpa.service;

import bitlab.to2024g1springdatajpa.model.Language;
import bitlab.to2024g1springdatajpa.repository.LanguageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
  @Autowired
  private LanguageRepository languageRepository;

  public List<Language> getLanguages() {
    return languageRepository.findAll();
  }
}

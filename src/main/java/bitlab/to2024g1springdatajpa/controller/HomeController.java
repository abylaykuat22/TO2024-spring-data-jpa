package bitlab.to2024g1springdatajpa.controller;

import bitlab.to2024g1springdatajpa.model.Developer;
import bitlab.to2024g1springdatajpa.model.Language;
import bitlab.to2024g1springdatajpa.service.DeveloperService;
import bitlab.to2024g1springdatajpa.service.LanguageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  @Autowired
  private DeveloperService developerService;
  @Autowired
  private LanguageService languageService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<Developer> developers = developerService.getSortedDevelopers();
    model.addAttribute("developers", developers);

    List<Language> languages = languageService.getLanguages();
    model.addAttribute("languages", languages);
    return "home";
  }

  @PostMapping("/developer/add")
  public String addDeveloper(Developer developer) {
    developerService.addDeveloper(developer);
    return "redirect:/";
  }

  @GetMapping("/developer/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    Developer developer = developerService.getDeveloperById(id);
    model.addAttribute("developer", developer);

    List<Language> languages = languageService.getLanguages();
    model.addAttribute("languages", languages);
    return "details";
  }

  @PostMapping("/developer/edit")
  public String editDeveloper(Developer developer) {
    developerService.editDeveloper(developer);
    return "redirect:/";
  }

  @GetMapping("/developer/search")
  public String search(@RequestParam String search, Model model) {
    List<Developer> developers = developerService.search(search);
    model.addAttribute("developers", developers);
    return "home";
  }
}

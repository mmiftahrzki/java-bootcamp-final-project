package mmiftahrzki.bootcamp.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mmiftahrzki.bootcamp.final_project.model.ArtistModel;
import mmiftahrzki.bootcamp.final_project.service.ArtistService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
  @Autowired
  private ArtistService artist_service;

  @GetMapping("/artists")
  public List<ArtistModel> get(@RequestParam(required = false) String genre) {
    return artist_service.getAll(genre);
  }
}

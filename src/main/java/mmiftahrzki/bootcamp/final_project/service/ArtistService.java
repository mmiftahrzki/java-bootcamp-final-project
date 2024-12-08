package mmiftahrzki.bootcamp.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mmiftahrzki.bootcamp.final_project.model.ArtistModel;
import mmiftahrzki.bootcamp.final_project.repository.ArtistRepository;

@Service
public class ArtistService {
  @Autowired
  private ArtistRepository repository;

  public List<ArtistModel> getAll(String genre) {
    List<ArtistModel> artists = repository.get(genre);

    return artists;
  }
}

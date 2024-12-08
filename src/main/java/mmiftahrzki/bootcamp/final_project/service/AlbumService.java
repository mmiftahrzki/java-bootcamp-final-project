package mmiftahrzki.bootcamp.final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mmiftahrzki.bootcamp.final_project.entity.AlbumEntity;
import mmiftahrzki.bootcamp.final_project.model.request.AlbumRequest;
import mmiftahrzki.bootcamp.final_project.repository.AlbumRepository;

@Service
public class AlbumService {
  @Autowired
  private AlbumRepository repository;

  private final String ERR_NULL_ALBUM_NAME = "The album name cannot be null.";
  private final String ERR_EMPTY_OR_BLANK_ALBUM_NAME = "The album name cannot be empty.";

  public AlbumEntity create(AlbumRequest request) {
    AlbumEntity entity = new AlbumEntity();

    if (request.getName() == null) {
      throw new NullPointerException(ERR_NULL_ALBUM_NAME);
    }

    if (request.getName().isEmpty() || request.getName().isBlank()) {
      throw new RuntimeException(ERR_EMPTY_OR_BLANK_ALBUM_NAME);
    }

    entity.setName(request.getName());
    entity.setRelease(request.getRelease());
    entity.setArtistId(request.getArtistId());

    return repository.saveAndFlush(entity);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }
}

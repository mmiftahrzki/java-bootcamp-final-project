package mmiftahrzki.bootcamp.final_project.service;

import java.util.Optional;

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
  private final String ERR_ALBUM_NOT_FOUND = "Album not found.";

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

  public AlbumEntity update(Integer id, AlbumRequest request) {
    Optional<AlbumEntity> check_album_from_db = repository.findById(id);

    if (check_album_from_db.isEmpty()) {
      throw new RuntimeException(ERR_ALBUM_NOT_FOUND);
    }

    AlbumEntity entity = check_album_from_db.get();

    entity.setName(request.getName());
    entity.setRelease(request.getRelease());
    entity.setArtistId(request.getArtistId());

    return repository.saveAndFlush(entity);
  }

  public AlbumEntity patch(Integer id, AlbumRequest request) {
    Optional<AlbumEntity> check_album_from_db = repository.findById(id);

    if (check_album_from_db.isEmpty()) {
      throw new RuntimeException(ERR_ALBUM_NOT_FOUND);
    }

    AlbumEntity entity = check_album_from_db.get();

    if (request.getName() != null) {
      if (!request.getName().isEmpty() || !request.getName().isBlank()) {
        entity.setName(request.getName());
      }
    }

    if (request.getRelease() != null) {
      entity.setRelease(request.getRelease());
    }

    if (request.getArtistId() != null) {
      entity.setArtistId(request.getArtistId());
    }

    return repository.saveAndFlush(entity);
  }
}

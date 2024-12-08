package mmiftahrzki.bootcamp.final_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mmiftahrzki.bootcamp.final_project.entity.AlbumEntity;
import mmiftahrzki.bootcamp.final_project.model.request.AlbumRequest;
import mmiftahrzki.bootcamp.final_project.service.AlbumService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {
  @Autowired
  private AlbumService service;

  @PostMapping()
  public ResponseEntity<Void> post(@RequestBody AlbumRequest request) {
    AlbumEntity album = service.create(request);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(album.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<AlbumEntity> update(@PathVariable Integer id, @RequestBody AlbumRequest request) {
    return ResponseEntity.ok(service.update(id, request));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<AlbumEntity> patch(@PathVariable Integer id, @RequestBody AlbumRequest request) {
    return ResponseEntity.ok(service.patch(id, request));
  }
}

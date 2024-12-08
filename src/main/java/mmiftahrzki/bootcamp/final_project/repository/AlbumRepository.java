package mmiftahrzki.bootcamp.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mmiftahrzki.bootcamp.final_project.entity.AlbumEntity;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
}

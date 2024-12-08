package mmiftahrzki.bootcamp.final_project.entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "album")
@Getter
@Setter
public class AlbumEntity {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "`release`")
  private Year release;

  @Column(name = "artist_id")
  private Integer artistId;
}

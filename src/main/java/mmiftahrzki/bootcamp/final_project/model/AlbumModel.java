package mmiftahrzki.bootcamp.final_project.model;

import java.time.Year;

public class AlbumModel {
  private Integer id;
  public String name;
  public Year release;
  public ArtistModel artist;

  public AlbumModel(Integer id, String name, Year release, ArtistModel artist) {
    this.id = id;
    this.name = name;
    this.release = release;
    this.artist = artist;
  }
}

package mmiftahrzki.bootcamp.final_project.model;

import java.util.List;

public class ArtistModel {
  public Integer id;
  public String name;
  public Boolean verified_user;
  public List<String> genres;

  public ArtistModel(Integer id, String name, Boolean verified_user, List<String> genres) {
    this.id = id;
    this.name = name;
    this.verified_user = verified_user;
    this.genres = genres;
  }
}

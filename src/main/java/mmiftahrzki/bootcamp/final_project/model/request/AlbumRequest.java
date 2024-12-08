package mmiftahrzki.bootcamp.final_project.model.request;

import java.time.Year;

import lombok.Data;

@Data
public class AlbumRequest {
  private String name;
  private Year release;
  private Integer artistId;
}

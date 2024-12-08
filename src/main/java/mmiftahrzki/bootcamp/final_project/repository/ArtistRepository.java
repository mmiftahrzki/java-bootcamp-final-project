package mmiftahrzki.bootcamp.final_project.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import mmiftahrzki.bootcamp.final_project.model.ArtistModel;

@Repository
public class ArtistRepository {
  @Autowired
  private JdbcTemplate jdbc_template;

  public List<ArtistModel> get(String genre) {
    String sql = "SELECT a.* FROM (SELECT a.id, a.name, a.verified_user, GROUP_CONCAT(g.name ORDER BY g.id SEPARATOR ', ') as genre FROM artist a LEFT JOIN artist_genre ag ON ag.artist_id = a.id LEFT JOIN genre g ON g.id = ag.genre_id GROUP BY a.id ) a WHERE 1 = 1";

    String genre_params = null;
    if (genre != null && (!genre.isEmpty() || !genre.isBlank())) {
      sql += " AND a.genre LIKE ?";
      genre_params = "%" + genre + "%";
    }

    sql += ";";

    if (genre_params == null) {
      return jdbc_template.query(
          sql,
          (result_set, row_num) -> {
            ArtistModel model = new ArtistModel(result_set.getInt("id"),
                result_set.getString("name"),
                result_set.getBoolean("verified_user"), null);
            model.genres = Arrays.asList(result_set.getString("genre").split(", "));

            return model;
          });
    } else {
      return jdbc_template.query(
          sql,
          (result_set, row_num) -> {
            ArtistModel model = new ArtistModel(result_set.getInt("id"),
                result_set.getString("name"),
                result_set.getBoolean("verified_user"), null);
            model.genres = Arrays.asList(result_set.getString("genre").split(", "));

            return model;
          }, genre_params);
    }
  }
}

package db;

import models.Actor;
import models.Film;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> searchActorsByName(String lastName) {
        List<Actor> actors = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?")) {
            statement.setString(1, lastName);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    int actorId = results.getInt("actor_id");
                    String firstName = results.getString("first_name");
                    String actorLastName = results.getString("last_name");

                    Actor actor = new Actor(actorId, firstName, actorLastName);
                    actors.add(actor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public List<Film> getFilmsByActorId(int actorId) {
        List<Film> films = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT film.film_id, film.title, film.description, film.release_year, film.length " +
                             "FROM film " +
                             "JOIN film_actor ON film.film_id = film_actor.film_id " +
                             "WHERE film_actor.actor_id = ?")) {
            statement.setInt(1, actorId);

            try(ResultSet results = statement.executeQuery()){
                while (results.next()) {
                    int filmId = results.getInt("film_id");
                    String title = results.getString("title");
                    String description = results.getString("description");
                    int releaseYear = results.getInt("release_year");
                    int length = results.getInt("length");

                    Film film = new Film(filmId, title, description, releaseYear, length);
                    films.add(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}


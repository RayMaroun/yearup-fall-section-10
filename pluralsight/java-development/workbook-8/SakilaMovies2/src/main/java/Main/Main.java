package Main;

import db.DataManager;
import models.Actor;
import models.Film;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get the username and password
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");

        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DataManager dataManager = new DataManager(dataSource);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the last name of the actor: ");
        String lastName = scanner.nextLine();

        List<Actor> actors = dataManager.searchActorsByName(lastName);

        if (!actors.isEmpty()) {
            System.out.println("Your matches are:\n");

            for (Actor actor : actors) {
                System.out.println("Actor ID: " + actor.getActorId());
                System.out.println("First Name: " + actor.getFirstName());
                System.out.println("Last Name: " + actor.getLastName());
                System.out.println();
            }
        } else {
            System.out.println("No matches!");
        }

        System.out.print("Enter the actor ID to see their films: ");
        int actorId = scanner.nextInt();

        List<Film> films = dataManager.getFilmsByActorId(actorId);

        if (!films.isEmpty()) {
            System.out.println("Films for actor ID " + actorId + ":\n");

            for (Film film : films) {
                System.out.println("Film ID: " + film.getFilmId());
                System.out.println("Title: " + film.getTitle());
                System.out.println("Description: " + film.getDescription());
                System.out.println("Release Year: " + film.getReleaseYear());
                System.out.println("Length: " + film.getLength());
                System.out.println();
            }
        } else {
            System.out.println("No films found for actor ID " + actorId);
        }
    }
}


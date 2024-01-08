package org.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class affichage extends Application {

    private static final double[] xCoordinates = {50, 150, 250, 100, 200};
    private static final double[] yCoordinates = {50, 100, 150, 200, 250};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Objets cliquables");

        Pane root = new Pane();

        // Créer des cercles et les positionner
        for (int i = 0; i < xCoordinates.length && i < yCoordinates.length; i++) {
            Circle circle = createCircle(xCoordinates[i], yCoordinates[i]);

            // Ajouter un gestionnaire d'événements au cercle
            circle.setOnMouseClicked(this::handleCircleClick);

            root.getChildren().add(circle); // Ajouter le cercle au panneau
        }

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Créer un cercle avec les paramètres donnés
    private Circle createCircle(double x, double y) {
        Circle circle = new Circle(20);
        circle.setFill(Color.BLUE);
        circle.setCenterX(x);
        circle.setCenterY(y);
        return circle;
    }

    // Gestionnaire d'événements pour le clic sur un cercle
    private void handleCircleClick(MouseEvent event) {
        Circle clickedCircle = (Circle) event.getSource();
        move(clickedCircle);
    }

    // Fonction de déplacement
    private void move(Circle circle) {
        // Implémentez votre logique de déplacement ici
        // Par exemple, vous pouvez changer les coordonnées du cercle
        double newX = circle.getCenterX() + 10;
        double newY = circle.getCenterY() + 10;
        circle.setCenterX(newX);
        circle.setCenterY(newY);
    }
}

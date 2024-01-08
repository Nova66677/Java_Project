package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class graphics extends Application {

    // Attributs de l'écran titre
    private Button playButton;
    private Button creditButton;
    private Button exitButton;
    private Label mainLabel;
    private Label subLabel;
    private Label creditLabel;
    private Stage primaryStage;

    // Attributs du jeu
    private static final double[] xCoordinates = {50, 150, 250, 100, 200};
    private static final double[] yCoordinates = {50, 100, 150, 200, 250};

    private Pond etang = new Pond();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Écran Titre");
        this.primaryStage.setMinWidth(1000); // Définir la largeur minimale de la fenêtre
        this.primaryStage.setMinHeight(667); // Définir la hauteur minimale de la fenêtre

        // Charger l'image d'arrière-plan
        Image backgroundImage = new Image(getClass().getResourceAsStream("/background.jpg"));

        // Créer une image de fond avec l'image chargée
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        // Appliquer l'image de fond au conteneur BorderPane
        BorderPane root = new BorderPane();
        root.setBackground(new Background(background));

        // Conteneur VBox pour les boutons au centre
        VBox centerBox = new VBox(20);
        centerBox.setAlignment(Pos.CENTER);

        // Conteneur VBox pour les titres
        VBox titleBox = new VBox(10);
        titleBox.setAlignment(Pos.CENTER);

        // Titre et sous-titre
        this.mainLabel = new Label("Projet java");
        this.mainLabel.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-font-family: 'Arial Rounded MT Bold'"); // Style CSS du titre
        this.mainLabel.setAlignment(Pos.TOP_CENTER);
        this.mainLabel.setMaxWidth(Double.MAX_VALUE);


        this.subLabel = new Label("Frog Duplication Program");
        this.subLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-font-family: 'Arial Rounded MT Bold'");

        // Affichage des crédits
        this.creditLabel = new Label("Développé par : \n\nEliott Chopin\nJoseph Deriu-Peraldi\nCyril Maïsani");
        this.creditLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white; -fx-font-family: 'Arial Rounded MT Bold'");
        this.creditLabel.setAlignment(Pos.TOP_CENTER);
        this.creditLabel.setVisible(false);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(javafx.scene.paint.Color.BLACK);
        dropShadow.setRadius(4.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        creditLabel.setEffect(dropShadow);

        titleBox.getChildren().addAll(mainLabel, subLabel, creditLabel);

        // Bouton "Jouer"
        this.playButton = new Button("Jouer");
        this.playButton.setOnAction(e -> handlePlayButton()); // Exécute handlePlayButton lorsqu'on appuie dessus
        this.playButton.setStyle("-fx-font-size: 16; -fx-min-width: 150; -fx-min-height: 50;");

        // Bouton "Crédit"
        this.creditButton = new Button("Crédit");
        this.creditButton.setOnAction(e -> handleCreditButton());
        this.creditButton.setStyle("-fx-font-size: 16; -fx-min-width: 150; -fx-min-height: 50;");

        // Bouton "Ecran Titre"

        this.exitButton = new Button("Ecran Titre");
        this.exitButton.setOnAction(e -> handleExitButton());
        this.exitButton.setStyle("-fx-font-size: 16; -fx-min-width: 150; -fx-min-height: 50;");
        this.exitButton.setManaged(false);
        this.exitButton.setVisible(false);


        // Ajouter les boutons et les label au layout

        // Ajouter les boutons au conteneur VBox
        centerBox.getChildren().addAll(playButton, creditButton, exitButton);

        // Positionner le titre en haut et les boutons au centre du BorderPane
        root.setTop(titleBox);
        root.setCenter(centerBox);

        // Scène
        Scene scene = new Scene(root, 1000, 667);

        // Afficher la scène
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    // Action lorsque le bouton "Jouer" est cliqué
    private void handlePlayButton() {
        this.playButton.setManaged(false);
        this.playButton.setVisible(false);
        this.creditButton.setManaged(false);
        this.creditButton.setVisible(false);
        this.mainLabel.setVisible(false);
        this.subLabel.setVisible(false);
        this.creditLabel.setVisible(false);
        this.exitButton.setManaged(false);
        this.exitButton.setVisible(false);
        run();
    }

    // Action lorsque le bouton "Crédit" est cliqué
    private void handleCreditButton() {
        // Masquer les boutons
        this.playButton.setManaged(false);
        this.playButton.setVisible(false);
        this.creditButton.setManaged(false);
        this.creditButton.setVisible(false);
        this.mainLabel.setVisible(false);
        this.subLabel.setVisible(false);
        this.creditLabel.setVisible(true);
        this.exitButton.setManaged(true);
        this.exitButton.setVisible(true);

    }

    private void handleExitButton() {
        this.playButton.setManaged(true);
        this.playButton.setVisible(true);
        this.creditButton.setManaged(true);
        this.creditButton.setVisible(true);
        this.mainLabel.setVisible(true);
        this.subLabel.setVisible(true);
        this.creditLabel.setVisible(false);
        this.exitButton.setManaged(false);
        this.exitButton.setVisible(false);
    }

    private void run(){
        Pane game = new Pane();

        // Créer des cercles et les positionner
        for (int i = 0; i < xCoordinates.length && i < yCoordinates.length; i++) {
            Circle circle = createCircle(xCoordinates[i], yCoordinates[i]);

            // Ajouter un gestionnaire d'événements au cercle
            circle.setOnMouseClicked(this::handleCircleClick);

            game.getChildren().add(circle); // Ajouter le cercle au panneau
        }

        Scene scene = new Scene(game, 1000, 667);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createCircle(double x, double y) {
        Circle circle = new Circle(20);
        circle.setFill(Color.BLUE);
        circle.setCenterX(x);
        circle.setCenterY(y);
        return circle;
    }

    private void handleCircleClick(MouseEvent event) {
        Circle clickedCircle = (Circle) event.getSource();
        move(clickedCircle);
    }

    private void move(Circle circle) {
        // Implémentez votre logique de déplacement ici
        // Par exemple, vous pouvez changer les coordonnées du cercle
        double newX = circle.getCenterX() + 10;
        double newY = circle.getCenterY() + 10;
        circle.setCenterX(newX);
        circle.setCenterY(newY);
    }
}

package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.animation.PauseTransition;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class graphics extends Application {

    // Attributs de l'écran titre
    private Button playButton;
    private Button creditButton;
    private Button exitButton;
    private Label mainLabel;
    private Label subLabel;
    private Label creditLabel;
    private Stage primaryStage;
    private VBox centerBox;
    private BorderPane game;

    // Attributs du jeu

    private ArrayList<Frog> Frog_array = new ArrayList<>();
    private ArrayList<Fly> Fly_array = new ArrayList<>();

    private Pond etang = new Pond();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Projet java");
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
        this.centerBox = new VBox(20);
        this.centerBox.setAlignment(Pos.CENTER);

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

    private void run() {
        // Charger l'image d'arrière-plan
        Image backgroundImage = new Image(getClass().getResourceAsStream("/gameBackground.jpg"));

        // Créer une image de fond avec l'image chargée
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        // Appliquer l'image de fond au conteneur BorderPane
        this.game = new BorderPane();
        this.game.setBackground(new Background(background));

        // Créer la langue

        Line line = new Line(0, 0, 0, 0);
        line.setStroke(Color.RED);
        //this.game.getChildren().add(line);
        //line.setVisible(false);


        // Créer les mouches et les grenouilles

        this.Fly_array = Pond.generateFly(15, 1000, 667);
        this.Frog_array = Pond.generateFrog(1, 1000, 667);

        // affichage et "clickabilité" des grenouilles
        for (Frog f : Frog_array) {
            ImageView frog = createFrog(f.getX(), f.getY());
            frog.setOnMouseClicked(this::handleFrogClick);
            game.getChildren().add(frog);
        }

        // affichage et "clickabilité" des grenouilles
        for (Fly f : Fly_array) {
            ImageView fly = createFly(f.getX(), f.getY());
            game.getChildren().add(fly);
        }
        //Pond.move_all(10000, Frog_array, Fly_array);
        Scene scene = new Scene(game, 1000, 667);

        Timeline moveTimeline = new Timeline(new KeyFrame(Duration.millis(500), e -> flyMove()));
        moveTimeline.setCycleCount(Timeline.INDEFINITE);
        moveTimeline.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView createFrog(double x, double y) {
        Image frog = new Image(getClass().getResourceAsStream("/frog.jpg"));
        ImageView imageView = new ImageView(frog);
        imageView.setX(x);
        imageView.setY(y);
        return imageView;
    }

    private ImageView createFly(double x, double y) {
        Image fly = new Image(getClass().getResourceAsStream("/fly.jpg"));
        ImageView imageView = new ImageView(fly);
        imageView.setX(x);
        imageView.setY(y);
        return imageView;
    }

    private void handleFrogClick(MouseEvent event) {
        ImageView clickedFrog = (ImageView) event.getSource();
        Frog frog = findFrog((int) clickedFrog.getX(), (int) clickedFrog.getY());
        action(frog);
    }

    private void action(Frog frog) {

        //frog.move(10, 10);

        for (int j = 0; j < Fly_array.size(); j++) {
            Fly fly = Fly_array.get(j);
            double d = Pond.distance(frog, fly);
            if (d < frog.getPortee()) {
                boolean res = frog.eat(fly);
                if (res) {
                    System.out.println("Une mouche a été mangée");
                    ImageView f = findFly(fly.getX(), fly.getY());
                    f.setVisible(false);


                    break;
                }
            }




        /*ArrayList<Frog> Dead_Frog_array = new ArrayList<>();
        ArrayList<Fly> Dead_Fly_array = new ArrayList<>();

        // Chaque grenouille doit déterminer les mouches à sa porter

        for (int i = 0; i < Frog_array.size(); i++) {
            Frog frog = Frog_array.get(i);
             for (int j = 0; j < Fly_array.size(); j++) {
                Fly fly = Fly_array.get(j);
                double d = Pond.distance(frog, fly);
                if (d < frog.getPortee()) {
                    boolean res = frog.eat(fly);
                    if (res) {
                        System.out.println("Une mouche a été mangée");
                        break;
                    }
                }
            }
        }


        // On vieillis nos Animaux avec leur méthode gettingOlder()
        for (int i = 0; i < Frog_array.size(); i++) {
            Frog frog = Frog_array.get(i);
            frog.gettingOlder();
            if (frog.isDead() && !Dead_Frog_array.contains(frog)) {
                Dead_Frog_array.add(frog);
                System.out.println("Moi, " + frog.getName() + ", je viens de m'éteindre.");
            }
        }
        for (int i = 0; i < Fly_array.size(); i++) {
            Fly fly = Fly_array.get(i);
            fly.gettingOlder();
            if (fly.isDead() && !Dead_Fly_array.contains(fly)) {
                Dead_Fly_array.add(fly);
                System.out.println("Moi, " + fly.getName() + ", je viens de m'éteindre.");
            }
        }*/
        }
    }

    private Frog findFrog(int x, int y) {
        int i = 0;
        Frog frog;
        do {
            frog = this.Frog_array.get(i);
            i++;
        } while (frog.getX() != x && frog.getY() != y);
        return frog;
    }

    private ImageView findFly(int x, int y) {
        int i = 0;
        ImageView fly;
        do {
            fly = (ImageView) this.game.getChildren().get(i);
            i++;
        } while (fly.getX() != x && fly.getY() != y);
        return fly;
    }

    private void flyMove() {
        System.out.println("Move");
        for (int k = 0; k < this.Fly_array.size(); k++) {
            Fly fly = this.Fly_array.get(k);
            double dx = ThreadLocalRandom.current().nextInt(-1, 2) * 10;
            double dy = ThreadLocalRandom.current().nextInt(-1, 2) * 10;
            int fly_x = fly.getX();
            int fly_y = fly.getY();
            double new_coordX = fly_x + dx;
            double new_coordY = fly_y + dy;
            ImageView iFly = findFly(fly_x, fly_y);
            if ((new_coordX >= 0 && new_coordX <= 1000) && (new_coordY >= 0 && new_coordY <= 667)) {
                fly.move((int) dx, (int) dy);
                iFly.setX(new_coordX);
                iFly.setY(new_coordY);
            }
        }
    }
}
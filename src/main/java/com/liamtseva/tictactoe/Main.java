package com.liamtseva.tictactoe;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {git checkout main

  @Override
  public void start(Stage stage) throws IOException {
    stage.getIcons().add(new Image("https://i.ibb.co/g7XfJTP/tic-tac-toe-icon-design-mini-game-vector-27783897.jpg"));
    FXMLLoader loader = new FXMLLoader(Main.class.getResource ("tic-tac-toe.fxml"));
    Scene scene = new Scene(loader.load(), 400, 500);
    stage.setTitle("Хрестики-нолики");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

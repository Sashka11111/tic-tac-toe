package com.liamtseva.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeController {

  private char nowSymbol = 'X';
  private char[][] field = new char[3][3];

  @FXML
  void btnClick(ActionEvent event) {
    Button btn = (Button) event.getSource();
    //перевірка щоб користувач не натискав на уже заповнену кнопку
    if (!btn.getText().isEmpty()) {
      return;
    }
    btn.setText(String.valueOf(nowSymbol));

    int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
    int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
    field[rowIndex][columnIndex] = nowSymbol;
    nowSymbol = (nowSymbol == 'X') ? 'O' : 'X';
    if ((field[0][0]==field[0][1] && field[0][0]==field[0][2]) && (field[0][0] == 'X' || field[0][0] == 'O')){
      showWinnerAlert(btn.getText(), event);
    } else if ((field[1][0]==field[1][1] && field[1][0]==field[1][2]) && (field[1][0] == 'X' || field[1][0] == 'O')){
      showWinnerAlert(btn.getText(), event);
    } else if ((field[2][0]==field[2][1] && field[2][0]==field[2][2])&& (field[2][0]== 'X' || field[2][0] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if ((field[0][0]==field[1][0] && field[0][0]==field[2][0])&& (field[0][0] == 'X' || field[0][0] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if ((field[0][1]==field[1][1] && field[0][1]==field[2][1])&& (field[0][1] == 'X' || field[0][1] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if ((field[0][2]==field[1][2] && field[0][2]==field[2][2])&& (field[0][2] == 'X' || field[0][2] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if ((field[0][0]==field[1][1] && field[0][0]==field[2][2])&& (field[0][0] == 'X' || field[0][0] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if ((field[0][2]==field[1][1] && field[0][2]==field[2][0])&& (field[0][2] == 'X' || field[0][2] == 'O')){
      showWinnerAlert(btn.getText(), event);
    }else if (checkDraw()) {
        Alert alert = new Alert(AlertType.INFORMATION, "Нічия", ButtonType.OK);
        alert.showAndWait().ifPresent(response -> {
          if (response == ButtonType.OK) {
            reloadScene(event);
          }
        });

    }
  }
  // метод для перевірки на нічию
  private boolean checkDraw() {
    // Перевірка, чи всі клітинки заповнені
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (field[i][j] == '\0') {
          return false; // Є ще пусті клітинки, гра не в нічию
        }
      }
    }
    return true; // Всі клітинки заповнені, гра в нічию
  }
  //Метод для відображення вікна привітання
  private void showWinnerAlert(String winnerText, ActionEvent event) {
    Alert alert = new Alert(AlertType.INFORMATION, "Вітаємо переможця. Це: " + winnerText, ButtonType.OK);
    alert.showAndWait().ifPresent(response -> {
      if (response == ButtonType.OK) {
        reloadScene(event);
      }
    });
  }
  //Після повідомлення про виграш відображається заново сцена
  private void reloadScene(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("tic-tac-toe.fxml"));
      Scene scene = new Scene(loader.load());
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

module com.liamtseva.tictactoe {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.liamtseva.tictactoe to javafx.fxml;
  exports com.liamtseva.tictactoe;
}
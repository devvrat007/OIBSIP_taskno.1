package com.example.numberguessing;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.lang.Math;

public class NumberGuessing extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Guessing Game");

        boolean play = true;
        while (play) {
            play = false;
            int randomNumber = 1 + (int) (Math.random() * 100);

            int maxAttempts;
            int guessed = 0;

            TextInputDialog difficultyDialog = new TextInputDialog();
            difficultyDialog.setTitle("Difficulty Level");
            difficultyDialog.setHeaderText("Guess the number between 1 to 100 \n Choose the difficulty level:");
            difficultyDialog.setContentText("Easy (7 tries) type 1\nMedium (5 tries) type 2\nHard (3 tries) type 3");

            int difficulty;
            try {
                String difficultyInput = difficultyDialog.showAndWait().get();
                difficulty = Integer.parseInt(difficultyInput);
            } catch (NumberFormatException e) {
                showErrorAlert("Invalid difficulty level. Please try again.");
                continue;
            }

            switch (difficulty) {
                case 1 -> maxAttempts = 7;
                case 2 -> maxAttempts = 5;
                case 3 -> maxAttempts = 3;
                default -> {
                    showErrorAlert("Invalid difficulty level. Please try again.");
                    continue;
                }
            }

            for (int i = 0; i < maxAttempts; i++) {
                TextInputDialog guessDialog = new TextInputDialog();
                guessDialog.setTitle("Guess the Number");
                guessDialog.setHeaderText("Attempt: " + (i + 1) + "/" + maxAttempts);
                guessDialog.setContentText("Enter your guess:");

                int GNumber;
                try {
                    String guessInput = guessDialog.showAndWait().get();
                    GNumber = Integer.parseInt(guessInput);
                } catch (NumberFormatException e) {
                    showErrorAlert("Invalid input. Please enter a number.");
                    continue;
                }

                if (GNumber == randomNumber) {
                    showInfoAlert("Congratulations!! You guessed it right :)");
                    guessed = 1;
                    break;
                } else if (GNumber < randomNumber) {
                    showInfoAlert("The number is greater than your guessed number");
                } else {
                    showInfoAlert("The number is lesser than your guessed number");
                }
            }

            if (guessed != 1) {
                showErrorAlert("Sorry, you did not guess the number.\nThe correct number was " + randomNumber);
            }

            Alert playAgainAlert = new Alert(AlertType.CONFIRMATION);
            playAgainAlert.setTitle("Play Again");
            playAgainAlert.setHeaderText("Do you want to play again?");

            if (playAgainAlert.showAndWait().orElse(null) == ButtonType.OK) {
                play = true;
            }
        }

        primaryStage.close();
    }

    private void showErrorAlert(String message) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    private void showInfoAlert(String message) {
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setTitle("Information");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

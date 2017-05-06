package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoController {

    @FXML
    public Button backButtonInfo;
    Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    public void backPressed(MouseEvent mouseEvent) throws IOException {
        Button button = (Button) mouseEvent.getSource();
        if ((button).getText().equals("BACK")) {
            Stage current = (Stage) button.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("menuSample.fxml"));
            current.setScene(new Scene(root, screenSize.getWidth(), screenSize.getHeight()));
            current.setMaximized(true);
            current.show();
        }
    }

    public void dragged(MouseEvent mouseEvent) {
        System.out.println("Drag!");
    }
}


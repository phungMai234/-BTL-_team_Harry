package JavaFx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class GiaoDienDictionary {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        try{
            Parent root = FXMLLoader.load(this.getClass().getResource("giaoDienDictionary.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        }
        catch(Exception err){
            System.out.println(err.getMessage());
        }
    }
}

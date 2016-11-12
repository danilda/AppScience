package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DisperseInclusion;
import model.Fibers;
import model.Matrix;

/**
 * Created by User on 07.09.2016.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));

        primaryStage.setTitle("Карбопластик");
        Scene scene = new Scene(root, 600, 610);
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(0, "sample/my.css");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(610);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

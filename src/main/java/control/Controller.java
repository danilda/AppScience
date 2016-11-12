package control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;


public class Controller {


    @FXML
    private void initialize() {
    }


    @FXML
    public void showDialog(ActionEvent actionEvent) throws Exception {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/edit.fxml"));
            stage.setTitle("Карбопластик");
            stage.setMinHeight(300);
            stage.setMinWidth(610);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception e){
            throw new Exception("Ошибка в showDialog");
        }

    }
    @FXML
    public void showDialog1(ActionEvent actionEvent) throws Exception {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/edit1.fxml"));
            stage.setTitle("Карбопластик");
            stage.setMinHeight(300);
            stage.setMinWidth(610);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception e){
            throw new Exception("Ошибка в showDialog");
        }

    }

}

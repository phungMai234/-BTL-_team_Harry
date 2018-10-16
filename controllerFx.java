package JavaFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static controller.controller.*;

public class controllerFx implements Initializable {


    @FXML private TextField textFieldInput;
    @FXML private Label labelOutput;
    @FXML private WebView webView;
    @FXML private WebEngine webEngine;
    @FXML private ListView<String> listView;

    public void handleButtonFind() throws SQLException {

        String wordInput = textFieldInput.getText();
        String wordExplain = findWord(wordInput);

        if(wordExplain.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Not found this word");
            alert.setTitle("Information");
            alert.setHeaderText("Notification");
            alert.show();
        }
        else
        {
            labelOutput.setText(wordInput);
            webEngine.loadContent(wordExplain);
        }

    }
    public void showList() throws SQLException {
        String input = textFieldInput.getText();
        String word[] = {""};
        word = suggestionWord(input);
        ObservableList<String> data = FXCollections.observableArrayList(word);
        listView.setItems(data);

    }

    public void KeyPress(KeyEvent e) throws SQLException {
        if(e.getCode() == KeyCode.ENTER)
        {
            handleButtonFind();
        }

    }

    @FXML
    public void displayMouse(MouseEvent mouseEvent) throws SQLException {
        String text;
        text = listView.getSelectionModel().getSelectedItem();
        textFieldInput.setText(text);

    }

    public void actionEvent(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //webView = new WebView(); k có dong nay
        webEngine = webView.getEngine();
    }


    @FXML
    public  void handleButtonActionAddNewWord(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("addNewWord.fxml")));
            Parent rootAdd = (Parent) fxmlLoader.load();
            Stage stageAdd = new Stage();
            stageAdd.initStyle(StageStyle.UTILITY);

            stageAdd.hide();
            stageAdd.setTitle("Add new Word");
            stageAdd.setScene(new Scene(rootAdd));
            stageAdd.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    @FXML
    public  void handleButtonActionEditWord(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("editWord.fxml")));
            Parent rootEdit = (Parent) fxmlLoader.load();
            Stage stageEdit = new Stage();
            stageEdit.initStyle(StageStyle.UTILITY);

            stageEdit.hide();
            stageEdit.setTitle("Edit Word");
            stageEdit.setScene(new Scene(rootEdit));
            stageEdit.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
    @FXML
    public  void handleButtonActionDelete(ActionEvent e)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("delete.fxml")));
            Parent rootDel = (Parent) fxmlLoader.load();
            Stage stageDel = new Stage();
            stageDel.initStyle(StageStyle.UTILITY);

            stageDel.hide();
            stageDel.setTitle("Delete Word");
            stageDel.setScene(new Scene(rootDel));
            stageDel.show();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }

}

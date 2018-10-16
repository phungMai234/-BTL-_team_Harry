package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.HTMLEditor;

import static controller.controller.addWordToDatabase;


public class addNewWordController {
    @FXML
    private TextField textFieldWordTarget = new TextField();
    @FXML
    private HTMLEditor htmlEditorWordExplain = new HTMLEditor();



    @FXML
    public void handleButtonActionOk(ActionEvent e)
    {
        String wordTarget = textFieldWordTarget.getText();
        String wordExplain = htmlEditorWordExplain.getHtmlText();

        // lam them mot ham so sanh tu nhap vao
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Adding this word is successful");
        alert.setTitle("Information");
        alert.setHeaderText("Done");
        alert.show();


        addWordToDatabase(wordTarget, wordExplain);
        textFieldWordTarget.setText("");
        htmlEditorWordExplain.setHtmlText("");
    }
}
/*
1. tu them moi trung voi tu trong tu dien
2. thong bao them tu thanh cong
 */
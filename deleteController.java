package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

import static controller.controller.deletaWordFromDatabase;

public class deleteController {
    @FXML
    private TextField textFieldXoa = new TextField();

    @FXML
    public void handleButtonAction1(ActionEvent e)
    {

//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation");
//        alert.setHeaderText("CONFIRMATION");
//        alert.setContentText("Do you want to delete it?");
//        alert.show();
//
//        Optional<ButtonType> result = alert.showAndWait();
//
//        if(result.get() == ButtonType.OK) {

        String text = textFieldXoa.getText();
        deletaWordFromDatabase(text);
        textFieldXoa.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Done");
        alert.setContentText("Delete successfully");
        alert.show();
        //}
    }
}
/*
các trường hơp :
1. k có tu trung khop de xoa
2. hoi có muốn xóa từ không
3. thông báo xóa từ thành công
 */
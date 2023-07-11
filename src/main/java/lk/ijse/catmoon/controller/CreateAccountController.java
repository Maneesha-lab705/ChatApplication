package lk.ijse.catmoon.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.catmoon.Bo.custom.UserBo;
import lk.ijse.catmoon.Bo.custom.impl.UserBoImpl;
import lk.ijse.catmoon.Dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class CreateAccountController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnSsaveOnAction(ActionEvent event) {
        String name =txtName.getText();
        String mail =txtEmail.getText();
        String passowrd =txtPassword.getText();

        UserBo userBo =new UserBoImpl();

        UserDto userDto =new UserDto(name,mail,passowrd);
        try {
            boolean isSave =userBo.save(userDto);
            if (isSave){
               new Alert(Alert.AlertType.CONFIRMATION,"your registration is done!!").show();
               clear();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }



    }

    void clear(){
        txtEmail.clear();
        txtEmail.clear();
        txtPassword.clear();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
//        stage.initStyle(StageStyle.TRANSPARENT);
//        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Login form");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void btnCloseOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login form");
        stage.centerOnScreen();
        stage.close();
    }
}

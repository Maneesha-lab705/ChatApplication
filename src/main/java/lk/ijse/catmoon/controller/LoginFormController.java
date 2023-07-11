package lk.ijse.catmoon.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.catmoon.Bo.custom.LoginBo;
import lk.ijse.catmoon.Bo.custom.impl.LoginBoImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private JFXButton btnclose;

    LoginBo loginBo =new LoginBoImpl();


    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException {

        String name =txtUserName.getText();
        String password = txtPassword.getText();

        boolean isconform = false;
        try {
            isconform = loginBo.serch(name,password);
            if (isconform) {
                ClientFormController.userName = txtUserName.getText();
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/client_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                anchorPane.setOnMousePressed(this::handleMousePressed);
                anchorPane.setOnMouseDragged(this::handleMouseDragged);
                stage.setTitle(txtUserName.getText());
                stage.show();


            }if (!isconform){
                new Alert(Alert.AlertType.ERROR,"plece create account").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleMouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
    }

    private void handleMousePressed(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }


    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    public void singinOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login form");
        stage.centerOnScreen();
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

    public void OnKeyTypeOnAction(KeyEvent keyEvent) {
        txtUserName.setBackground(Background.fill(Color.GOLD));
    }

    public void OnKeyTypeOnAction2(KeyEvent keyEvent) {
        txtPassword.setBackground(Background.fill(Color.GOLD));
    }

}

package by.bsu.kolodyuk.form;


import by.bsu.kolodyuk.ScreensConfig;
import by.bsu.kolodyuk.model.User;
import by.bsu.kolodyuk.model.UserType;
import by.bsu.kolodyuk.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.annotation.Resource;

public class RegisterForm extends NavigableForm {

    public RegisterForm(ScreensConfig screens) {
        super(screens);
    }

    @FXML
    private TextField loginField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private PasswordField passwordField;

    @Resource
    private UserService userService;


    @FXML
    public void onRegisterButtonPressed(ActionEvent event) {
        User user = new User();
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setLogin(loginField.getText());
        user.setPassword(passwordField.getText());
        user.setUserType(UserType.SIMPLE);
        userService.addUser(user);

        screens.toLoginPage();
    }

}

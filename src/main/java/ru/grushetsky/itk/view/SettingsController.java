package ru.grushetsky.itk.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.grushetsky.itk.MainApp;

public class SettingsController {

    private MainApp mainApp;

    @FXML
    private TextField Setting1Field;
    // TODO globalSettings
    private boolean okClicked = false;

    @FXML
    private void initialize() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}

package ru.grushetsky.itk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.grushetsky.itk.config.SessionManager;
import ru.grushetsky.itk.config.SessionConfig;
import ru.grushetsky.itk.config.Settings;
import ru.grushetsky.itk.main.Session;
import ru.grushetsky.itk.view.SessionController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Session currentSession;
    private Settings currentSettings;

    public MainApp() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITunesKiller");

        initRootLayout();

        currentSettings = Settings.getInstance();

        SessionManager sessionManager = SessionManager.getInstance();
        SessionConfig sessionConfig = sessionManager.getSessionConfig(currentSettings.getLastSessionId());
        currentSession = new Session(this, sessionConfig);

        showSessionPane();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSessionPane() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/SessionView.fxml"));
            AnchorPane sessionPane = loader.load();

            rootLayout.setCenter(sessionPane);

            SessionController controller = loader.getController();
            controller.setMainApp(this);
            controller.initTabs();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Settings getCurrentSettings() {
        return currentSettings;
    }
}

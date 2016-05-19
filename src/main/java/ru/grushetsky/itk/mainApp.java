package ru.grushetsky.itk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.grushetsky.itk.config.*;
import ru.grushetsky.itk.session.Session;
import ru.grushetsky.itk.session.SessionManager;
import ru.grushetsky.itk.view.SessionController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Session currentSession;
    private Settings settings;
    private SessionManager sessionManager = SessionManager.getInstance();

    public MainApp() {

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITunesKiller");

        initRootLayout();

        String testSettingsJson = "{\"sources\": [\"C:\\\\test\\\\audiobooks\\\\\", \"C:\\\\test\\\\music\\\\\", \"C:\\\\test\\\\podcasts\\\\\"], \"lastSessionId\": \"test\"}";
        loadSettings(new JsonSettingsReader(testSettingsJson));
//        loadSettings(new JsonSettingsReader(StringFileReader.readJsonByName("settings")));

        loadSession(settings.getLastSessionId());

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

    public Settings getSettings() {
        return settings;
    }

    public void loadSettings(ISettingsReader settingsReader) {
        this.settings = settingsReader.readSettings();
    }

    public void loadSession(String sessionId) {
        this.currentSession = sessionManager.getSession(sessionId);
    }
}

package ru.grushetsky.itk;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.grushetsky.itk.config.SessionManager;
import ru.grushetsky.itk.diskops.AudioDir;
import ru.grushetsky.itk.config.Session;
import ru.grushetsky.itk.config.Settings;
import ru.grushetsky.itk.view.SessionController;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<AudioDir> sources = FXCollections.observableArrayList();
    private ObservableList<AudioDir> destinations = FXCollections.observableArrayList();

    public MainApp() {

    }

    public ObservableList<AudioDir> getSources() {
        return this.sources;
    }

    public ObservableList<AudioDir> getDestinations() {
        return this.destinations;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ITunesKiller");

        initRootLayout();

        Settings currentSettings = Settings.getInstance();

        SessionManager sessionManager = SessionManager.getInstance();
        Session session = sessionManager.getSession(currentSettings.getLastSessionId());

        initSession(session);

        showSessionPane();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));

            // TODO Init global config

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initSession(Session session) {
        this.sources.setAll(session.getSources());

//        for (AudioDir source:this.session.getSources()){
//            source.print();
//
//            File[] dirs = source.getFs().listDir();
//            for (File dir:dirs) {
//                System.out.print(dir.toString() + "\n");
//            }
//
//        }

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

}

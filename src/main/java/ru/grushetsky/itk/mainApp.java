package ru.grushetsky.itk;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.grushetsky.itk.model.AudioDir;
import ru.grushetsky.itk.model.Session;
import ru.grushetsky.itk.view.AudioDirListController;

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
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        initSession();

        showAudioDirData();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initSession() {

        SessionManager sessionManager = new SessionManager("session.json");
        Session session = sessionManager.getSession();
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

    /**
     * Shows the person overview inside the root layout.
     */
    public void showAudioDirData() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/SessionView.fxml"));
            AnchorPane audioDirData = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(audioDirData);

            AudioDirListController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

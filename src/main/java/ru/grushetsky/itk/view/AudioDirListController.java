package ru.grushetsky.itk.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.grushetsky.itk.MainApp;
import ru.grushetsky.itk.diskops.AudioDir;

public class AudioDirListController {
//    @FXML
//    private TreeView<AudioDir> audioDirTreeView;
//
//    @FXML
//    private TreeItem<AudioDir> audioDirTreeItem;
//    @FXML
//    private TreeItem<String> rootItem = new TreeItem<String>("root node");
//
//    @FXML
//    private TableView<AudioDir> audioDirTable;
//
//    @FXML
//    private TableColumn<AudioDir, String> audioDirColumn;

    @FXML
    private Label sourceLabel;

    @FXML
    private Label testLabel;

    @FXML
    private TreeView<String> sourceTree;

    private MainApp mainApp;

    public AudioDirListController() {}

    @FXML
    private void initialize() {
//        rootItem.setExpanded(true);
//        String[] sources = {"a", "b"};
//        for (String source:sources) {
//            TreeItem<String> leaf = new TreeItem<String>(source);
//            rootItem.getChildren().add(leaf);
//        }


//        audioDirColumn.setCellValueFactory(cellData -> cellData.getValue().basedirProperty());
//
//        showDirDetails(null);
//
//        audioDirTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showDirDetails(newValue)
//        );
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

//        audioDirTable.setItems(this.mainApp.getSources());

//        rootItem.getChildren().setAll(mainApp.getSources())
    }

    private void showDirDetails(AudioDir audioDir) {
        if (audioDir != null) {
            sourceLabel.setText(audioDir.getBasedir().toString());
            testLabel.setText("Selected");
        } else {
            sourceLabel.setText("");
            testLabel.setText("");
        }
    }

    @FXML
    private void handleCopy() {
//        int selectedIndex = audioDirTable.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("Selection");
//            alert.setHeaderText("A dir selected");
//            alert.setContentText(String.format("Selected index: %d", selectedIndex));
//
//            alert.showAndWait();
//        } else {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No selection");
//            alert.setHeaderText("No dir selected");
//            alert.setContentText("Please select something!!!");
//
//            alert.showAndWait();
//        }

    }
}

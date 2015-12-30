package ru.grushetsky.itk.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.grushetsky.itk.MainApp;
import ru.grushetsky.itk.model.AudioDir;

public class AudioDirListController {
//    @FXML
//    private TreeView<AudioDir> audioDirTreeView;
//
//    @FXML
//    private TreeItem<AudioDir> audioDirTreeItem;
//    @FXML
//    private TreeItem<String> rootItem = new TreeItem<String>("root node");

    @FXML
    private TableView<AudioDir> audioDirTable;

    @FXML
    private TableColumn<AudioDir, String> audioDirColumn;

    @FXML
    private Label sourceLabel;

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
        audioDirColumn.setCellValueFactory(cellData -> cellData.getValue().basedirProperty());
    }

    public void setMainApp(MainApp MainApp) {
        this.mainApp = MainApp;

        audioDirTable.setItems(this.mainApp.getSources());

//        rootItem.getChildren().setAll(mainApp.getSources())
    }
}

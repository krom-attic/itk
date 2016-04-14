package ru.grushetsky.itk.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import ru.grushetsky.itk.MainApp;
import ru.grushetsky.itk.config.Settings;
import ru.grushetsky.itk.diskops.AudioDir;
import ru.grushetsky.itk.session.Session;
import ru.grushetsky.itk.scene.control.Directory;
import ru.grushetsky.itk.scene.control.TreeViewWithItems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SessionController {
    private MainApp mainApp;

    private ArrayList<TreeViewWithItems<Directory>> sourceTrees = new ArrayList<>();

    @FXML
    private TreeViewWithItems<Directory> sourceTree;

    @FXML
    private TabPane sourceTabPane;

    @FXML
    private AnchorPane sourcePane;

    @FXML
    private Label testLabel;

    public SessionController() {}

    private void buildTree(Directory baseDir) throws IOException {
        for (Path path : Files.newDirectoryStream(baseDir.getPath())) {
            if (Files.isDirectory(path)) {
                Directory dir = new Directory(path);
                baseDir.getChildren().add(dir);
                buildTree(dir);
            }
        }
    }

    @FXML
    private void initialize() {

    }

    public void initTabs() {
        // TODO Must be run only once
        Session session = mainApp.getCurrentSession();
        Settings settings = mainApp.getSettings();
        for (AudioDir source : settings.getSources()) {
            Tab newTab = new Tab(source.getShortName());
            TreeViewWithItems<Directory> newSourceTree = buildSourceTree(source);
            newSourceTree.setVisible(false);
            sourcePane.getChildren().add(newSourceTree);
            AnchorPane.setTopAnchor(newSourceTree, 35d);
            AnchorPane.setLeftAnchor(newSourceTree, 5d);
            AnchorPane.setBottomAnchor(newSourceTree, 5d);
            AnchorPane.setRightAnchor(newSourceTree, 5d);
            sourceTrees.add(newSourceTree);
            sourceTabPane.getTabs().add(newTab);
        }

        if (settings.getSources().size() > 0) {
            sourceTrees.get(0).setVisible(true);
        }

        sourceTabPane.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
            sourceTrees.get(oldValue.intValue()).setVisible(false);
            sourceTrees.get(newValue.intValue()).setVisible(true);
        });
    }

    private TreeViewWithItems<Directory> buildSourceTree(AudioDir source) {
        ObservableList<Directory> directories = FXCollections.observableArrayList();
        TreeViewWithItems<Directory> sourceTree = new TreeViewWithItems<>(new TreeItem<>(new Directory()));
        sourceTree.getRoot().setExpanded(true);
        sourceTree.setShowRoot(false);
        sourceTree.setCellFactory(tree -> {
            TreeCell<Directory> treeCell = new TreeCell<Directory>() {
                @Override
                public void updateItem(Directory item, boolean empty) {
                    super.updateItem(item, empty);
                    setTreeCellText(item, empty);
                }

                private void setTreeCellText(Directory item, boolean empty) {
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };
            treeCell.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.SECONDARY) {
                    testLabel.setText(treeCell.getTreeItem().getValue().getName());
                }
            });
            return treeCell;
        });
        Path rootPath = source.getBasedir();
        Directory rootDir = new Directory(rootPath);
        directories.add(rootDir);
        try {
            buildTree(rootDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sourceTree.setItems(directories);
        for (TreeItem<Directory> treeItem : sourceTree.getRoot().getChildren()) {
            treeItem.setExpanded(true);
        }

        return sourceTree;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}

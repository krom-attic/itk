package ru.grushetsky.itk.scene.control;

import javafx.scene.control.TreeCell;

public class ObjectTreeCell<Directory> extends TreeCell<Directory> {

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
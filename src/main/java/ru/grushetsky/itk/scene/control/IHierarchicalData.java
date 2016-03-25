package ru.grushetsky.itk.scene.control;

import javafx.collections.ObservableList;

/**
 * Used to mark an object as hierarchical data.
 * This object can then be used as data source for an hierarchical control, like the {@link javafx.scene.control.TreeView}.
 *
 * @author Christian Schudt
 */
public interface IHierarchicalData<T extends IHierarchicalData>  {
    /**
     * The children collection, which represents the recursive nature of the hierarchy.
     * Each child is again a {@link IHierarchicalData}.
     *
     * @return A list of children.
     */
    ObservableList<T> getChildren();
}
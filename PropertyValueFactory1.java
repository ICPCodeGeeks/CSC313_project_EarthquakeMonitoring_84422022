package earthquakemonitoring;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author Richard and Aileen
 * @param <T>
 * @param <T1>
 */
public class PropertyValueFactory1<T, T1> implements Callback<TableColumn.CellDataFeatures, ObservableValue> {

    /**
     *default constructor
     * @param oWord
     */
    public PropertyValueFactory1(T1 oWord) {
    }

    /**
     *
     * @param cellDataFeatures
     * @return
     */
    @Override
    public ObservableValue call(TableColumn.CellDataFeatures cellDataFeatures) {
        return null;
    }
}

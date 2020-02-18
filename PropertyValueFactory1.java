package earthquakemonitoring;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class PropertyValueFactory1<T, T1> implements Callback<TableColumn.CellDataFeatures, ObservableValue> {
    public PropertyValueFactory1(T1 oWord) {
    }

    @Override
    public ObservableValue call(TableColumn.CellDataFeatures cellDataFeatures) {
        return null;
    }
}

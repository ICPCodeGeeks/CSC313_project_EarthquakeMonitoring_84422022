package earthquakemonitoring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewGalam implements Initializable {

    @FXML
    private Button stats_id;
    private AnchorPane pane_id;
    @FXML
    private TableView<TableContent> table_id;
    @FXML
    private Button del_id;
    @FXML
    private TableColumn avg_id;
    @FXML
    private TableColumn n_id;
    @FXML
    private TableColumn i_id;
    @FXML
    private TableColumn v_id;
    @FXML
    private TableColumn c_id;
    @FXML
    private TableColumn l_id;
    private Button g_id;
    Galamseydb g_db= new Galamseydb();
    private final ObservableList<TableContent> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        i_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer>("id"));
        n_id.setCellValueFactory(new PropertyValueFactory<TableContent,String>("obs_name"));
        v_id.setCellValueFactory(new PropertyValueFactory<TableContent,String>("country_name"));
        c_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer>("years"));
        l_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer>("area_c"));
        avg_id.setCellValueFactory(new PropertyValueFactory<TableContent,Double>("avg"));
        table_id.setItems(getContent());

    }

    public ObservableList<TableContent> getContent(){
        ArrayList<String[]> list =g_db.getAllObservatory1();
        for(String[] p: list){
            System.out.println(p[0] +" :"+  p[1] +" :"+ p[2] +" :"+ p[3]+" :"+ p[4]+ ":"+ p[5] );
            data.add(new TableContent(Integer.parseInt(p[0]),p[1],p[2],
                    Integer.parseInt(p[3]),Double.parseDouble(p[4]),Double.parseDouble(p[5])));
        }
        return data;
    }



    public void buttonstats (ActionEvent event) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_galam.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }






    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }
    public void query(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("List_Event.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     * This method gets the average of an observatory selected
     * @throws SQLException
     */
    public void Avg() throws SQLException {
        ObservableList<TableContent> dat = table_id.getSelectionModel().getSelectedItems();
        int di= dat.get(0).getID();
        double avrg = g_db.getAvgObserv(di);
        g_db.updateObservatory(di,"avg",String.valueOf(avrg));
         table_id.getItems().clear();
         table_id.setItems(getContent());
    }
    /**
     * This deletes a record from thr table
     * @param actionEvent
     * @throws SQLException
     */
    public void delet(javafx.event.ActionEvent actionEvent) throws SQLException, IOException {
        ObservableList<TableContent> dat = table_id.getSelectionModel().getSelectedItems();
        int di= dat.get(0).getId();
        g_db.deleteGalam_Observ(di);
        g_db.deleteGalamsey(di);
        table_id.getItems().clear();
        table_id.setItems(getContent());
    }
}

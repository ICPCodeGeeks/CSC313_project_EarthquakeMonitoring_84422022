package earthquakemonitoring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewGala implements Initializable {
    @FXML
    private TableView<TableContent> tabe_id;
    @FXML
    private Button delete_id;
    @FXML
    private TableColumn p_id;
    @FXML
    private TableColumn m_id;
    @FXML
    private TableColumn k_id;
    @FXML
    private TableColumn n_id;
    @FXML
    private TableColumn j_id;
    @FXML
    private TableColumn u_id;
    Galamseydb g_db= new Galamseydb();
    private ObservableList<TableContent> data = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p_id.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("GID"));
        m_id.setCellValueFactory(new PropertyValueFactory<TableContent, String>("vegetation_color"));
        k_id.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("color_value"));
        n_id.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("latitude"));
        j_id.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("longitude"));
        u_id.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("year"));
        tabe_id.setItems(getContent());
    }


    private ObservableList<TableContent> getContent()  {
        ArrayList<String[]> list =  g_db.getAllGal1();
        for(String[] p: list ){
            System.out.println(p[0] +" :"+  p[1] +" :"+ p[2] +" :"+ p[3]+" :"+ p[4] +" :"+ p[5]);
            data.add(new TableContent(Integer.parseInt(p[0]) ,p[1],Integer.parseInt(p[2]),Double.parseDouble(p[3]),Double.parseDouble(p[4]),
                    Integer.parseInt(p[5])));
        }
        return data;

    }

    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_Gala.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    public void query(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Gala_List.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
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

    /**
     * This deletes a record from thr table
     * @param actionEvent
     * @throws SQLException
     */
    public void delete(javafx.event.ActionEvent actionEvent) throws SQLException, IOException {
        ObservableList<TableContent> dat = tabe_id.getSelectionModel().getSelectedItems();
        int di= dat.get(0).getID();
        g_db.deleteGalam_Observ(di);
        g_db.deleteGalamsey(di);
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_Gala.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }



}

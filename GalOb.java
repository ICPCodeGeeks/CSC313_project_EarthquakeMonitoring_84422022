package earthquakemonitoring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @Author Aileen Akpalu
 * @version 1.0.3
 */
public class GalOb implements Initializable {

    @FXML
    private TableView<TableContent> menu_id;
    @FXML
    private TableColumn o_id;
    @FXML
    private TableColumn nam_id;
    @FXML
    Label l;

    Galamseydb gd= new Galamseydb();

    private final ObservableList<TableContent> data = FXCollections.observableArrayList();


    /**
     * This method puts the data in the table when the screen loads
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        o_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer>("ID"));
        nam_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer>("name_o"));

        menu_id.setItems(getContent());

    }

    /**
     * This method gets the lsit of observatories
     * @return
     */
    public ObservableList<TableContent> getContent(){
        ArrayList<String[]> list =gd.getAllObservatory1();
        for(String[] p: list){
            System.out.println(p[0] +" :"+  p[1] );
            data.add(new TableContent(Integer.parseInt(p[0]),p[1]));
        }
        return data;
    }

    /**
     * This method changes the screen to GalamObser
     * @param actionEvent
     * @throws IOException
     */
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }


    /**
     * This method changes the screen to Add_New
     * @param actionEvent
     * @throws IOException
     */
    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();


    }

    /**
     * This method allows a user to select a record in a table
     * @param actionEvent
     * @throws SQLException
     * @throws IOException
     */
    public void Selection(ActionEvent actionEvent) throws SQLException, IOException {
          ObservableList<TableContent> dat = menu_id.getSelectionModel().getSelectedItems();
          int di= dat.get(0).getID();
        System.out.println(di);
          int ig=gd.getGalamseyyId();
        System.out.println(ig);
          gd.addGalam_Observ(di,ig);
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }


}

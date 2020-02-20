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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 *@version 1.0.3
 */
public class GalaList implements Initializable {
    @FXML
    private Button quer_id;
    @FXML
    private Button ques_id;
    Galamseydb g_db;
    @FXML
    private TextField ol_id;
    @FXML
    private TableView tabl_id;
    @FXML
    private TableColumn ia_id;
    @FXML
    private TableColumn ve_id;
    @FXML
    private TableColumn cv_id;
    @FXML
    private TableColumn la_id;
    @FXML
    private TableColumn lo_id;
    @FXML
    private TableColumn ye_id;
    @FXML
    Button back;
    Connection con;
    private final ObservableList<Object> data = FXCollections.observableArrayList();

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *This method changes the screen to "Galam_Info.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttonstats(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method changes the screen to "View_Galam.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_Galam.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method changes the screen to "Gala_List.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttons(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Gala_List.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     * This method prints out a list of galamsey events greater than the value inputted
     * @param event
     */
    public void que(javafx.event.ActionEvent event){
      data.add(g_db.greaterGalamsey(Integer.parseInt(ol_id.getText())));
    }
}

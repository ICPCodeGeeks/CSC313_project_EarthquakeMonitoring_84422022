package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 */
public class ViewGalam implements Initializable {
    private MenuButton back_b;
    private Button stats_id;
    private AnchorPane pane_id;
    private TableView table_id;
    private TableColumn i_id;
    private TableColumn v_id;
    private TableColumn c_id;
    private TableColumn l_id;
    private Button g_id;
    Galamseydb g_db;
    TableView[] table;

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       i_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer("id")>);
       v_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer("Year")>);
       c_id.setCellValueFactory(new PropertyValueFactory<TableContent,String("obs_name")>);
       l_id.setCellValueFactory(new PropertyValueFactory<TableContent,Integer("area_c")>);
       
    }
    
    public ObservableList<TableContent> getContent(){
        ArrayList<String[]> list =g_db.getAllObservatory1();
        for(String[] p: list){
        data.add(new TableContent(Integer.parseInt(p[0]),p[1],p[2],Double.parseDouble(p[3]),Double.parseDouble(p[4]),Integer.parseInt(5)))
        }
        return data;
    }

    /**
     *This method changes the screen to "View_galam.fxml"
     * @param event
     * @throws IOException
     */
    public void buttonstats (ActionEvent event) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_galam.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method the list of observatory names in list items
     * @throws IOException
     * @throws SQLException
     */
    public void Dropdown() throws IOException, SQLException {
        int coun= g_db.getNumberOfObservatory();
        table = new TableView[coun];
        for( int i=0; i < coun; i++){
            table[i] = new TableView();
            String text= g_db.getObservatory(i++);
            String[] oWords= text.split(":");
            i_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	String>(oWords[0]));
            v_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	String>(oWords[1]));
            c_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb, Integer>(Integer.parseInt(oWords[2])));
            l_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	Double>(Double.parseDouble(oWords[3])));

        }
    }

    /**
     *This method changes the screen to "Observatory_Data.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method changes the screen to "List_Event.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void query(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("List_Event.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }
}


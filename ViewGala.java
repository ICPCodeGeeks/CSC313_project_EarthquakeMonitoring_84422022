package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 */
public class ViewGala implements Initializable {
    Galamseydb g_db;
    private AnchorPane pane_id;
    private TableView table_id;
    private TableColumn i_id;
    private TableColumn v_id;
    private TableColumn c_id;
    private TableColumn l_id;
    private TableColumn o_id;
    private TableColumn y_id;

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      List<Object> list =new ArrayList<>();
       try{
           String query= "select * from observatory";


           Statement st = g_db.connect().createStatement();
           st.executeQuery(query);
           ResultSet rs = st.executeQuery(query);//executes the query
           // String observatoryData="";//assigns data fetched from database
           while(rs.next()){// shifts pointer to next row and returns true if there
               //is a next row
               list.add( rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                       Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                       Integer.parseInt(rs.getString("year_started"))+"\n");
               //  observatoryData+= rs.getInt(1)+ ":"+ rs.getString(2)+":"+ rs.getString(3)
               //  +":"+ rs.getInt(4)+":"+ rs.getDouble(5)+"\n";
           }
           st.close();
           g_db.connect().close();

           data.add(list);
           System.out.println(list);
       }

       catch(Exception e){
           System.out.println(e);
       }

       p_id.setCellValueFactory(new PropertyValueFactory1<>("GID"));
       m_id.setCellValueFactory(new PropertyValueFactory1<>("veg_col"));
       k_id.setCellValueFactory(new PropertyValueFactory1<>("col_val"));
       n_id.setCellValueFactory(new PropertyValueFactory1<>("latitude"));
       j_id.setCellValueFactory(new PropertyValueFactory1<>("longitude"));
       u_id.setCellValueFactory(new PropertyValueFactory1<>("year_started"));

       tabe_id.setItems(data);
    }

    /**
     *This method changes the screen to "Add_New_Data.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method changes the screen to "Monitoring_Stats.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Monitoring_Stats.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method changes the screen to "Galam_Info.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }



}

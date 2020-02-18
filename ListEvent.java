package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListEvent implements Initializable {
 private TextField nam_o;
 private TextField val_col;
 private Button query;
 private TableView table_id;
 private TableView[] table;
    Galamseydb g_db;
    private TableColumn i_id;
    private TableColumn v_id;
    private TableColumn c_id;
    private TableColumn l_id;
    private TableColumn o_id;
    private TableColumn y_id;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }
    public void que(javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        int cal=Integer.parseInt(val_col.getText());
        table = new TableView[g_db.getNumberofGalamsey()];
        if(cal==1){
            g_db.getGalam_Observ(1);
            Drop();
        }
        else if (cal==2){
            g_db.getGalam_Observ(2);
            Drop();
        }
        else
            g_db.getGalam_Observ(3);
        Drop();
    }


    public void Drop() throws SQLException {
        int coun= g_db.getNumberofGalamsey();
        table = new TableView[coun];
        for( int i=0; i < coun; i++){
            table[i] = new TableView();
            String text= g_db.getGalamsey(i++);
            String[] oWords= text.split(":");
            i_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	String>(oWords[0]));
            v_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	String>(oWords[1]));
            c_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb, Integer>(Integer.parseInt(oWords[2])));
            l_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	Double>(Double.parseDouble(oWords[3])));
            o_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb,	Double>(Double.parseDouble(oWords[4])));
            y_id.setCellValueFactory(	new	PropertyValueFactory1<Galamseydb, Integer>(Integer.parseInt(oWords[5])));
        }
    }

}



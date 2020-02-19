package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 */
public class GalaStat implements Initializable {
    private Label lab_id;
    Galamseydb g_db;

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method prints the largest color value ever recorded
     * @throws SQLException
     */
    public void Max_Col() throws SQLException {
        int col= g_db.maxGalamsey();
        if(col==1){
            lab_id.setText("GREEN");
        }
        else if(col==2) {
            lab_id.setText("YELLOW");
        }
        else
            lab_id.setText("BROWN");

    }

    /**
     *This method changes the screen to "Gala_Stat.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttonstats(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Gala_Stat.fxml"));
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

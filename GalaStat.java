package earthquakemonitoring;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @Author Aileen Akpalu
 * @version 1.0.2
 */
public class GalaStat implements Initializable {
    @FXML
    private Label lab_id;
    @FXML
    private Button b_id;
    Galamseydb g_db= new Galamseydb();

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method changes the screen to Gala_Stat.fxml
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
     * This method returns this current scene to Galam_Info.fxml
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

    /**
     * This method sets the label to the largest color value
     */
    public void Purr(){
        b_id.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
        Connection con= g_db.connect();
        try {
            String query1 = "select count(col_val) from galamsey where col_val=1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);// returns a int of the number of rows affected
            rs.next();
            int firstOne = rs.getInt(1);
            String query2 = "select count(col_val) from galamsey where col_val=2";
            st = con.createStatement();
            rs = st.executeQuery(query2);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            int secOne = rs.getInt(1);
            String query3 = "select count(col_val) from galamsey where col_val=3";
            st = con.createStatement();
            rs = st.executeQuery(query3);// returns a int of the number of rows affected
            //int count = 0;
            rs.next();
            int thirdOne = rs.getInt(1);
            int maxData = Math.max(Math.max(firstOne, secOne), thirdOne);
            System.out.println(maxData + "gbhjhjh");
            if (maxData == firstOne) {
                maxData = 1;
            } else if (maxData == secOne) {
                maxData = 2;
            } else {
                maxData = 3;
            }
            lab_id.setText(String.valueOf(maxData));


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
});
    }

}

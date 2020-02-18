package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MonitoringStats implements Initializable {

    private Label col_val;
    private Label avg_val;
    Galamseydb g_db;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PageLoad();
        try {
            Max_Col();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void buttonstats(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Monitoring_Stats.fxml"));
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

    public void PageLoad(){
            String max=g_db.maxAvgObserv();
            col_val.setText(max);
        System.out.println(col_val);

    }
    public void Max_Col() throws SQLException {
        int col= g_db.maxGalamsey();
        if(col==1){
            avg_val.setText("Green");
        }
        else if(col==2) {
            avg_val.setText("Yellow");
        }
        else
            avg_val.setText("Brown");

    }
}

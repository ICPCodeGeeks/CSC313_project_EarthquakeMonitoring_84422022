package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GalamInfo implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    //    public void buttonpush (ActionEvent event) throws IOException {
//        // Set the Scene to the Stage
//        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
//        Scene scene = new Scene(screen_two);
//        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
//        s_two.setScene(scene);
//        // Set the Title to the Stage
//        s_two.show();
//
//    }
//    public void button (ActionEvent event) throws IOException {
//        // Set the Scene to the Stage
//        Parent screen_two= FXMLLoader.load(getClass().getResource("View_galam.fxml"));
//        Scene scene = new Scene(screen_two);
//        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
//        s_two.setScene(scene);
//        // Set the Title to the Stage
//        // Display the Stage
//        s_two.show();
//
//    }
//    public void buttonstats (ActionEvent event) throws IOException {
//        // Set the Scene to the Stage
//        Parent screen_two= FXMLLoader.load(getClass().getResource("Monitoring_Stats.fxml"));
//        Scene scene = new Scene(screen_two);
//        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
//        s_two.setScene(scene);
//        // Set the Title to the Stage
//        s_two.show();
//
//    }
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Monitoring_Stats.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    public void buttonsave(javafx.event.ActionEvent actionEvent) throws IOException {  // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_Gala.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();

    }


}


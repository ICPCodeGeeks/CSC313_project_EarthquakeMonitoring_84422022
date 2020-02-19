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

/**
 *
 * @author Richard and Aileen
 */
public class ObservatoryData implements Initializable {

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *This method changes the screen to "GalamObser.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
    // Set the Scene to the Stage
    Parent screen_two= FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
    Scene scene = new Scene(screen_two);
    Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    s_two.setScene(scene);
    // Set the Title to the Stage
    s_two.show();
}

    /**
     *This method changes the screen to "Add_New_Data.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    /**
     *This method changes the screen to "Monitoring_Stats.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Monitoring_Stats.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    /**
     *This method changes the screen to "View_galam.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void buttonsave(javafx.event.ActionEvent actionEvent) throws IOException {  // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("View_galam.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();

    }

}

package earthquakemonitoring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author Aileen Akpalu
 *@version 1.0.2
 */
public class AddNew implements Initializable {
    public Button save_id;
    @FXML
    private TextField color_value;
    @FXML
    private TextField veg_color;
    @FXML
     private TextField pos_lat;
    @FXML
    private TextField pos_long;
    @FXML
    private TextField year;
    Galamsey galam= new Galamsey();
    Galamseydb gd= new Galamseydb();
   private MenuButton menu_id;
   private Label l;


    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    /**
     * This method changes the current screen to Add_nEw.fxml
     * @param actionEvent
     * @throws IOException
     */
    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }


    /**
     * This method returns to the previous screen Galam_Info.fxml
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
     * This method adds the new data to the database
     * @param actionEvent
     * @throws IOException
     */
     public void buttonsave(ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Gal_Ob.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
        galam.setVegetation_color(veg_color.getText());
        galam.setColor_value(Integer.parseInt(color_value.getText()));
        galam.setLatitude(Double.parseDouble(pos_lat.getText()));
        galam.setLongitude(Double.parseDouble(pos_long.getText()));
        galam.setYear(Integer.parseInt(year.getText()));
        gd.addGalamsey(galam);
    }

}

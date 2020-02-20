package earthquakemonitoring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 *@version 1.0.2
 */
public class AddNewData implements Initializable {

    /**
     *
     */
    @FXML
    public TextField vobs_id;

    /**
     *
     */
    @FXML
    public TextField country_id;

    /**
     *
     */
    @FXML
   public TextField area_id;

    /**
     *
     */
    @FXML
   public TextField year_id;

    /**
     *
     */
    @FXML
     public MenuButton back_b;

    /**
     *
     */
    @FXML
    public Button save_id;
    Galamseydb g_db= new Galamseydb();
    Observatory o_db;

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
     *This method sets the observatory name to the data inputted in the vobs_id
     */
    public void Vob() {
        o_db.setObsName(vobs_id.getText());
    }

    /**
     * This method sets the country name to the data inputted in the country_id
     */
    public void Country() {
        o_db.setCountryName(country_id.getText());
    }

    /**
     * This method sets the area covered to the data inputted in the area_id
     */
    public void Area() {
        o_db.setAreaCovered(Double.parseDouble(area_id.getText()));
    }

    /**
     * This method sets the year to the data inputted in the year_id
     */
    public void Yr() {
        o_db.setYear(Integer.parseInt(year_id.getText()));
    }

    /**
     *This method changes the screen to "Add_New_Data.fxml"
     * @param actionEvent
     * @throws IOException
     * @throws SQLException
     */
    public void buttonsave(ActionEvent actionEvent) throws IOException, SQLException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
        o_db.getObsName();
        o_db.getCountryName();
        o_db.getAreaCovered();
        o_db.getYear();
        g_db.addObservatory(o_db);


    }




}

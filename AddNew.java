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

public class AddNew implements Initializable {
    public Button save_id;
    @FXML
    private TextField veg_color;
    private TextField colour_value;
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






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }



    public void buttonsave(ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
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
        String query = "insert into galamsey(veg_col,col_val,latitude,longitude,year_started) values(?,?,?,?,?)";
        PreparedStatement pst;
        try{
            pst= gd.connect().prepareStatement(query);
            //  pst.setInt(1,gIDCount); //takes number of question mark and value
            // System.out.println(gIDCount);
            pst.setString(1, galam.getVegetation_color()); //takes number of question mark and value
            System.out.println(galam.getVegetation_color());
            pst.setInt(2, galam.getColor_value()); //takes number of question mark and value
            System.out.println(galam.getColor_value());
            pst.setDouble(3, galam.getLatitude()); //takes number of question mark and value
            System.out.println(galam.getLatitude());
            pst.setDouble(4, galam.getLongitude()); //takes number of question mark and value
            System.out.println(galam.getLongitude());
            pst.setInt(5, galam.getYear()); //takes number of question mark and value
            System.out.println(galam.getYear());
            int count=pst.executeUpdate();// returns a int of the number of rows affected
            //  gIDCount++;
            System.out.println(count+ " row/s affected");
        }catch(Exception e){
            System.out.println("Error: "+e);
        }

    }


    public Galamsey getGalam() {
        return galam;
    }
}

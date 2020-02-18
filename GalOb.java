package earthquakemonitoring;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GalOb implements Initializable {
    MenuButton menu_id;
    Label l;
    Galamsey galam= new Galamsey();
    Galamseydb gd= new Galamseydb();
    AddNew g= new AddNew();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }


    public void dropdown() throws SQLException {
        MenuItem[] menu=new MenuItem[gd.getNumberOfObservatory()];
        for (int i = 0; i <gd.getNumberOfObservatory() ; i++) {
            menu_id.getItems().add(i,menu[i]);
            menu[i]=new MenuItem();
            String text= gd.getObservatory(i++);
            String[] oWords= text.split(":");
            String g_name=oWords[1];
            menu[i].setText(g_name);
            menu[i].setStyle("bold");
            System.out.println(menu[i].getText());
            menu_id.getItems().add(menu[i]);
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    l.setText(((MenuItem)e.getSource()).getText() + " selected");

                }
            };
            menu[i].setOnAction(event1);
            int y=Integer.parseInt(oWords[3]);
            int di=gd.getGalamseyyId();
            int ig= gd.getObservatoryId(g_name,y);
            gd.addGalam_Observ(ig,di);


        }
    }

    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();

    }



}


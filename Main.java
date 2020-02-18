package earthquakemonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
        primaryStage.setTitle("OBSEY");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }

    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
        // Set the Scene to the Stage
        Parent screen_two= FXMLLoader.load(getClass().getResource("Galam_Info.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        // Set the Title to the Stage
        s_two.show();
    }


    public static void main(String[] args) {
        Galamseydb gdb = new Galamseydb();
        gdb.connect();
        System.out.println(gdb.maxAvgObserv());
        System.out.println(gdb.getAllObservatory());
        System.out.println(gdb.observatoryIdCount());
        launch(args);
    }
}

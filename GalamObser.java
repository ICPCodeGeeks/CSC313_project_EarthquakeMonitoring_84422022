//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class GalamObser extends Application
//{
//    public static void main(String[] args)
//    {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) throws IOException
//    {
//        try {
//            Parent screen_two = FXMLLoader.load(getClass().getResource("GalamObser.fxml"));
//            // Create the Scene
//            Scene scene = new Scene(screen_two);
//            // Set the Scene to the Stage
//            stage.setScene(scene);
//            // Set the Title to the Stage
//            stage.setTitle("Obsey");
//            // Display the Stage
//            stage.show();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("No file");
//        }
//
//
//    }
////    public void buttonpush (ActionEvent event) throws IOException {
////        // Set the Scene to the Stage
////        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
////        Scene scene = new Scene(screen_two);
////        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
////        s_two.setScene(scene);
////        // Set the Title to the Stage
////        s_two.show();
////
////    }
////    public void button (ActionEvent event) throws IOException {
////        // Set the Scene to the Stage
////        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
////        Scene scene = new Scene(screen_two);
////        Stage s_two=(Stage)((Node)event.getSource()).getScene().getWindow();
////        s_two.setScene(scene);
////        // Set the Title to the Stage
////        s_two.show();
////
////    }
//
//    public void buttonpush(javafx.event.ActionEvent actionEvent) throws IOException {
//        // Set the Scene to the Stage
//        Parent screen_two= FXMLLoader.load(getClass().getResource("galamseys/Observatory_Data.fxml"));
//        Scene scene = new Scene(screen_two);
//        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        s_two.setScene(scene);
//        // Set the Title to the Stage
//        s_two.show();
//    }
//
//    public void button(javafx.event.ActionEvent actionEvent) throws IOException {
//        // Set the Scene to the Stage
//        Parent screen_two= FXMLLoader.load(getClass().getResource("Add_New_Data.fxml"));
//        Scene scene = new Scene(screen_two);
//        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        s_two.setScene(scene);
//        // Set the Title to the Stage
//        s_two.show();
//    }
//}

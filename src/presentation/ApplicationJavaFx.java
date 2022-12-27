package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationJavaFx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
                BorderPane root= FXMLLoader.load(getClass().getResource("produitsLayout.fxml"));
                Scene scene=new Scene(root,600,400);
                primaryStage.setTitle("gestion de commandes");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }

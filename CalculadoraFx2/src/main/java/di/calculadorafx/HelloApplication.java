package di.calculadorafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
        private Stage primaryStage;
        private Scene sceneNormal;
        private Scene sceneScientific;

        @Override
        public void start (Stage stage) throws IOException {
            this.primaryStage = stage;

            FXMLLoader loaderNormal = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent rootNormal = loaderNormal.load();
            sceneNormal = new Scene(rootNormal, 600, 573);

            FXMLLoader loaderScientific = new FXMLLoader(getClass().getResource("hello-viewC.fxml"));
            Parent rootScientific = loaderScientific.load();
            sceneScientific = new Scene(rootScientific, 500, 550);

            HelloController controllerNormal = loaderNormal.getController();
            controllerNormal.setPrimaryStage(stage);

            HelloControllerC controllerScientific = loaderScientific.getController();
            controllerScientific.setPrimaryStage(stage);

            sceneNormal.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());

            stage.setScene(sceneNormal);
            stage.setTitle("Calculadora");
            stage.show();


        }

        public static void main (String[]args){
            launch(args);
        }
    }
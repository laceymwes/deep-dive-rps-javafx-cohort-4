package edu.cnm.deepdive.rps;

import edu.cnm.deepdive.rps.controller.Controller;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

  private Controller controller;

  private static final String RESOURCES_UI_STRINGS = "resources/ui-strings";
  private static final String RESOURCES_MAIN_FXML = "resources/main.fxml";
  private static final String WINDOW_TITLE = "window_title";
  public static final String BACTERIA_IMG = "resources/bacteria.png";

  @Override
  public void start(Stage stage) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES_UI_STRINGS);
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource(RESOURCES_MAIN_FXML), bundle);
    controller = fxmlLoader.getController();
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    stage.setTitle(bundle.getString(WINDOW_TITLE));
    stage.getIcons().add(new Image(classLoader.getResourceAsStream(BACTERIA_IMG)));
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void stop() throws Exception {
    controller.stop(null);
    super.stop();
  }
}

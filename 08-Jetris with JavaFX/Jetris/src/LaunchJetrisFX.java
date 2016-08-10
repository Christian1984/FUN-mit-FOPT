import controller.JetrisFxController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.gameLogic.JetrisGame;
import view.guifx.JetrisFxStatsView;
import view.guifx.JetrisFxView;

/**
 * Created by chris on 08.08.16.
 */
public class LaunchJetrisFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/guifx/JetrisFxWindow.fxml"));
        Parent root = loader.load();

        //set title
        primaryStage.setTitle("JetrisFX");

        //set scene and window size
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.setResizable(false);

        //init game and pass reference to controller
        //TODO

        //init views
        //TODO

        //shutdown when window is closed
        //TODO

        //show window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

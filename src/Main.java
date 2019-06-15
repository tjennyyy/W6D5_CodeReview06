import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    private Database database;
    private ListView<Teacher> LVteacher;
    private ListView<Classes> LVclasses;
    private ObservableList<Teacher> OLteacher;
    private ObservableList<Classes> OLclasses;
    private TextField TFteacherID;
    private TextField TFteacherName;
    private TextField TFteacherSurname;
    private TextField TFteacherEMail;

    @Override
    public void init() {
        try {
            database = new Database();
        } catch (Exception e) {
            displayExeption(e);
        }
    }

    @Override
    public void stop() {
        try {
            database.closeDb();
        } catch (Exception e) {
            displayExeption(e);
        }
    }

    private void displayExeption(Exception e) {
        System.out.println("###### Exception ######");
        e.printStackTrace();
        System.exit(0);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("School Statics of Teachers (1)");

        // 





    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}





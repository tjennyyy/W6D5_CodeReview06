import javafx.application.Application;
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

import javax.swing.*;


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
    public void init(){
        try {
            database = new Database();
        }
        catch (Exception e){
            displayExeption(e);
        }
    }

    @Override
    public void stop(){
        try {
            database.closeDb();
        }
        catch (Exception e){
            displayExeption(e);
        }
    }

    private void displayExeption(Exception e) {
        System.out.println("###### Exception ######");
        e.printStackTrace();
        System.exit(0);
    }


    @Override
    public void start(Stage primaryStage) throws  Exception{

        primaryStage.setTitle("School Statics of Teachers (1)");

        // HBox
        HBox root = new HBox();
        root.setPadding(new Insets(30));
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        // VBox
        VBox ListTeaccher = new VBox();
        VBox ListThisTeaccher = new VBox();
        VBox ListTeaccherClasses = new VBox();


        // layout for ListTeacher
        Label teachers = new Label("Teachers");
        LVteacher = new ListView<>();
        LVteacher.setMaxSize(300,600);
        LVteacher.getSelectionModel().selectedIndexProperty().addListener(new ListChangeListener<>().Change<>());
        database = getDatabase ();
        LVteacher.setItems(database);


    }





}

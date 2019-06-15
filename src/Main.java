import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("School Statics of Teachers");

        // layout
        HBox root = new HBox();
        root.setPadding(new Insets(80));
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        // VBox
        VBox teacherList = new VBox();
        VBox teacherthis = new VBox();
        VBox teachClasses = new VBox();


        //layout: List of teacher
        Label teachers = new Label("Teachers");

        LVteacher = new ListView<>();
        LVteacher.setMaxSize(300, 600);
        LVteacher.getSelectionModel().selectedIndexProperty().addListener(new ListSelectChangeListener());
        OLteacher = getTeachers();
        LVteacher.setItems(OLteacher);

        teacherList.setSpacing(20);

        teacherList.getChildren().addAll(teachers, LVteacher);


        //layout: thisteacher
        Label thisTeacher = new Label("this teacher");
        // Text left
        Text teacherID = new Text("ID");
        Text teacherName = new Text("Name");
        Text teacherSurname = new Text("Surname");
        Text teacherEmail = new Text("E-Mail");
        // TextField: right show
        TFteacherID = new TextField();
        TFteacherName = new TextField();
        TFteacherSurname = new TextField();
        TFteacherEMail = new TextField();

        GridPane middle = new GridPane();
        middle.setAlignment(Pos.CENTER);
        middle.setVgap(15);
        middle.setHgap(35);

        middle.add(teacherID, 1, 1);
        middle.add(teacherName, 1, 2);
        middle.add(teacherSurname, 1, 3);
        middle.add(teacherEmail, 1, 4);

        middle.add(TFteacherID, 2, 1);
        middle.add(TFteacherName, 2, 2);
        middle.add(TFteacherSurname, 2, 3);
        middle.add(TFteacherEMail, 2, 4);

        teacherthis.setSpacing(20);

        teacherthis.getChildren().addAll(thisTeacher, middle);


        //layout for teacherClasses
        Label classes = new Label("teaches this classes");

        LVclasses = new ListView<>();
        LVclasses.setMaxSize(300, 600);
/*
        LVclasses.setMouseTransparent(true);
        LVclasses.setFocusTraversable(false);
*/
        teachClasses.setSpacing(15);

        teachClasses.getChildren().addAll(classes, LVclasses);

        //add all to root layout
        root.getChildren().addAll(teacherList, middle, teachClasses);

        // scene
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // initial selection in LVteacher
        LVteacher.getSelectionModel().selectFirst();

    }

    // ListSelectChangeListener for teacher
    private class ListSelectChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            if ((new_val.intValue() < 0) || (new_val.intValue() >= OLteacher.size())) {

                return; // invalid data
            }
            Teacher teacher = OLteacher.get(new_val.intValue());

            TFteacherID.setText(Integer.toString(teacher.getTeacherID()));
            TFteacherName.setText(teacher.getTeacherName());
            TFteacherSurname.setText(teacher.getTeacherSurname());
            TFteacherEMail.setText(teacher.getTeacherEMail());

            //OLclasses = getClasses(Integer.valueOf(TFteacherID.getText()));
            LVclasses.setItems(OLclasses);

        }
    }

    // show teacher database
    private ObservableList<Teacher> getTeachers() {

        List<Teacher> teacherList = null;

        try {
            teacherList = database.ListTeacher();
        }
        catch (Exception e) {

            displayExeption(e);
        }

        ObservableList<Teacher> databaseData = FXCollections.observableList(teacherList);
        return databaseData;
    }
/*
    // ListSelectChangeListener for teachClasses
    private  ObservableList<Classes> getClasses(int teacherID){

        List<Classes> classesList = null;

        try{
            classesList = database.ListClasses();
            System.out.println(classesList);
        }
        catch (Exception e) {

            displayExeption(e);

        }

        ObservableList<Classes> databaseData = FXCollections.observableList(classesList);
        return databaseData;
    }

 */

    private void displayExeption(Exception e) {
        System.out.println("###### Exception ######");
        e.printStackTrace();
        System.exit(0);
    }

}





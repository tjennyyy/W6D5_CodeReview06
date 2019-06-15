
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection conn;
    private static final String teacherTable = "teacher";
    private static final String classesTable = "classes";

    public Database()
            throws SQLException, ClassNotFoundException {

        // database
        Class.forName("com.mysql.cj.jdbc.Driver");
        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cr6" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "");

        conn.setAutoCommit(true);
        conn.setReadOnly(false);
    }

    public void closeDb() throws SQLException {
        conn.close();
    }

    // ListView: teacher
    public List<Teacher> ListTeacher() throws SQLException {

        String sql = "SELECT * FROM " + teacherTable + " ORDER BY teacherName";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Teacher> list = new ArrayList<>();

        while (rs.next()) {
            int teacherID = rs.getInt("teacherID");
            String teacherName = rs.getString("teacherName");
            String teacherSurname = rs.getString("teacherSurname");
            String teacherEMail = rs.getString("teacherEMail");
            list.add(new Teacher(teacherID, teacherName, teacherSurname, teacherEMail));
        }

        pstmnt.close();
        return list;
    }



    // ListView: classes
    public List<Classes> ListClasses() throws SQLException {

        String sql = "SELECT classes.teacherID, classes.classroom FROM" + classesTable + "ORDER BY classes.teacherID";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Classes> listClass = new ArrayList<>();

        while (rs.next()) {
            String classroom = rs.getString("classroom");
            int teacherID = rs.getInt("teacherID");
            listClass.add(new Classes(classroom, teacherID));
        }

        pstmnt.close();
        return listClass;
    }


}
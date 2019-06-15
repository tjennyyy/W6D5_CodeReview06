/*
(20) JavaFX: Display the list of the teachers in a ListView,
showing the teacher’s data as Surname, Name in the ListView .
Once a teacher’s name is selected, you need to populate teacher’s data in the field to the left (see the mockup below)
 */



public class Teacher {

    private int teacherID;
    private String teacherName;
    private String teacherSurname;
    private String teacherEMail;

    public Teacher(int teacherID, String teacherName, String teacherSurname, String teacherEMail) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherEMail = teacherEMail;
    }

    @Override
    public String toString(){
        return  teacherName + ", " + teacherSurname;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherEMail() {
        return teacherEMail;
    }

    public void setTeacherEMail(String teacherEMail) {
        this.teacherEMail = teacherEMail;
    }
}

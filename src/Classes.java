public class Classes {

    private String classroom;
    private int teacherID;


    public Classes(String classroom, int teacherID) {
        this.classroom = classroom;
        this.teacherID = teacherID;
    }

    @Override
    public String toString(){
        return classroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}

package Application;

public class TeacherTeachStudent {
    private String studentID;
    private String teacherID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public void insertSql() {
        String s = "insert into worker values("
                + '"' + studentID + '"' + ','
                + '"' + teacherID + '"' + ')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("worker");
    }
}


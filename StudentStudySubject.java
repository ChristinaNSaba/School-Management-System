package Application;

public class StudentStudySubject {

    private String studentId;
    private String subjectId;

    public StudentStudySubject() {
        super();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }


    @Override
    public String toString() {
        return "StudentStudySubject [studentId=" + studentId + ", subjectId=" + subjectId + "]";
    }
    public void insertSql() {
        String s = "insert into subject values("
                + '"' + studentId + '"' + ','
                +'"' + subjectId + ')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("Class");
    }

}
package Application;

public class Subject {
    private String id;
    private int creditHours;
    private int passGrade;
    private String subjectName;

    public Subject() {

    }

    public Subject(String subjectId, int creditHours, int passGrade, String subjectName) {
        super();
        this.id = subjectId;
        this.creditHours = creditHours;
        this.passGrade = passGrade;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return id;
    }

    public void setSubjectId(String subjectId) {
        this.id = subjectId;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getPassGrade() {
        return passGrade;
    }

    public void setPassGrade(int passGrade) {
        this.passGrade = passGrade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void insertSql() {
        String s = "insert into subject values("
                + '"' + id + '"' + ','
                +'"' + creditHours +'"' + ','
                + '"' + passGrade + '"' + ','
                + '"' + subjectName + '"' + ')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("Class");
    }

    @Override
    public String toString() {
        return "Subject [subjectId=" + id + ", creditHours=" + creditHours + ", passGrade=" + passGrade
                + ", subjectName=" + subjectName + "]";
    }



}

package Application;
public class Teacher extends Employee{
    private String specilaezSubject;
    private String id;

    // Getters and setters


    public String getSpecilaezSubject() {
        return specilaezSubject;
    }

    public void setSpecilaezSubject(String specilaezSubject) {
        this.specilaezSubject = specilaezSubject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void insertSql() {
        String s = "insert into teacher values("
                + '"' + id + '"' + ','
                +'"' + specilaezSubject +')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("teacher");
    }
}


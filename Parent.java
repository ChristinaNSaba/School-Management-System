package Application;

public class Parent {
    private String id;
    private String name;
    private String workplace;
    public String email;
    public String telephone;
    private String academic;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentID() {
        return id;
    }

    public void setParentID(String parentID) {
        id = parentID;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        telephone = telephone;
    }

    public String getAcademicQualification() {
        return academic;
    }

    public void setAcademicQualification(String academicQualification) {
        academic = academicQualification;
    }
    public void insertSql() {
        String s = "insert into parent values("
                + '"' + id + '"' + ','
                +'"' + email +'"' + ','
                + '"' + telephone + '"' + ','
                + '"' + workplace + '"' + ','
                + '"' + name + '"' +','
                + '"' + academic + '"' +
                ')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("Parent");
    }


}
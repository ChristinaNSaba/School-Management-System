package Application;

public class Worker extends Employee{
private String major;
private String id;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public void insertSql() {
        String s = "insert into worker values("
                + '"' + id + '"' + ','
                +'"' + major +'"' + ')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("worker");
    }
}


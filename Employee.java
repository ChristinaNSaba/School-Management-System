package Application;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String telePhone;
    private String address;
    private String gender;
    private Date DateOfBirth;
    private String email;
    private double salary;
    private boolean insurence;
    private String department;

    public Employee() {

    }

    // Getters and setters



    public String getTelephone() {
        return telePhone;
    }

    public int getEmployeeID() {
        return id;
    }

    public void setEmployeeID(int employeeID) {
        id = employeeID;
    }

    public String getDepartmentID() {
        return department;
    }

    public void setDepartmentID(String departmentID) {
        departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setTelephone(String telephone) {
        telePhone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public boolean isInsurance() {
        return insurence;
    }

    public void setInsurance(boolean insurance) {
        insurance = insurance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void insertSql() {
        String s = "insert into employee values("
                + '"' + id + '"' + ','
                +'"' + name +'"' + ','
                + '"' +  telePhone+ '"' + ','
                + '"' + address + '"' + ','
                + '"' + gender + '"' +   ','
                + '"' + DateOfBirth + '"' +   ','
                + '"' + email + '"' +  ','
                + '"' + salary + '"' +  ','
                + '"' + insurence + '"' +   ','
                + '"' + department + '"' +')';
        boolean v = Sql.excute(s);
        if (v)
            Null.showConformation("employee");
    }

}
package Application;
public class SchoolClass {


        String subjects;
        String id;
        String numberOfSubjects;
        String section;
        String location;

        public String getSubjects() {
            return subjects;
        }

        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }

        public String getClassId() {
            return id;
        }

        public void setClassId(String classId) {
            this.id = classId;
        }

        public String getNumberOfSubjects() {
            return numberOfSubjects;
        }

        public void setNumberOfSubjects(String numberOfSubjects) {
            this.numberOfSubjects = numberOfSubjects;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void insertSql() {
            String s = "insert into schoolclass values("
                    + '"' + id + '"' + ','
                    +'"' + subjects +'"' + ','
                    + '"' + numberOfSubjects + '"' + ','
                    + '"' + section + '"' + ','
                    + '"' + location + '"' + ')';
            boolean v = Sql.excute(s);
            if (v)
                Null.showConformation("Class");
        }
    }






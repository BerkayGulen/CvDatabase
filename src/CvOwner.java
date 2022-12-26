public class CvOwner {
    private int id;
    private String name;
    private String surname;
    private String department;
    private String cvFilePath;

    public CvOwner(String name, String surname, String department, String cvFilePath) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.cvFilePath = cvFilePath;
    }
    public CvOwner(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCvFilePath() {
        return cvFilePath;
    }

    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }
}

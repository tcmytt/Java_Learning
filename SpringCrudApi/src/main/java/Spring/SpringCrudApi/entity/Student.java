package Spring.SpringCrudApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="last_name",length=45)
    private String lastName;

    @Column(name="first_name",length=45)
    private String firstName;

    @Column(name="email",length=45)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Student(String lastName, String email, String firstName) {
        this.lastName = lastName;
        this.email = email;
        this.firstName = firstName;
    }

    public Student() {
    }


}

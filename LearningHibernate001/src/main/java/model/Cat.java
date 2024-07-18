package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Cat {
    private Integer id;
    private String name;
    private Integer age;
    private Date DateOfBirth;
    private Boolean sex;

    // Bat buoc 1 constructor rong
    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", DateOfBirth=" + DateOfBirth +
                ", sex=" + sex +
                '}';
    }

    public Cat(Integer id, String name, Integer age, Date dateOfBirth, Boolean sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        DateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}

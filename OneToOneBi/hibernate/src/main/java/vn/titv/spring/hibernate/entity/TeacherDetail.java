package vn.titv.spring.hibernate.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="identification_number")
    private String identificationNumber;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="gender")
    private boolean gender;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    @Column(name="salary")
    private double salary;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="facebook")
    private String facebook;

    @Column(name="hobby")
    private String hobby;

    @Lob
    @Column(name="avatar")
    private Blob avatar;

    @OneToOne(mappedBy = "teacherDetail", cascade = CascadeType.ALL)
    private Teacher teacher;

    public TeacherDetail() {
    }

    public TeacherDetail(String identificationNumber, Date dateOfBirth, boolean gender, String phoneNumber, String address, double salary, String youtubeChannel, String facebook, String hobby, Blob avatar) {
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.youtubeChannel = youtubeChannel;
        this.facebook = facebook;
        this.hobby = hobby;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", facebook='" + facebook + '\'' +
                ", hobby='" + hobby + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}

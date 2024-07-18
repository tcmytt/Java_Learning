package vn.titv.spring.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.titv.spring.hibernate.entity.Course;

import java.util.List;

public interface CourseDAO {
    public void save(Course course);

    public List<Course> findCourseByTeacherId(int id);

    public Course findCourseById(int id);

    public Course findCourseAndStudentByCourseId(int id);

}

package Spring.SpringCrudApi.dao;

import Spring.SpringCrudApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path="students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Them phuong thuc khac o day roi vao StudentRepositoryImpl imlement lai, chua impl dc do no bat impl het lai hoac khong
    // Truy vấn bằng firstName
    public List<Student> findByFirstName(String firstName);

    // Truy vấn bằng firstName và lastName
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Truy vấn các students có firstName khác với giá trị tìm kiếm
    //public List<Student> findByFirstNameNot(String firstName);

    // Truy vấn các students có firstName khác với giá trị tìm kiếm
    @Query("SELECT s FROM Student s WHERE s.firstName<>?1")
    public List<Student> findByFirstNameNot(String firstName);

    // Truy vấn các students có firstName không chứa giá trị tìm kiếm // LIKE
}

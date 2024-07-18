package Spring.SpringCrudApi.dao;

import Spring.SpringCrudApi.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String jdql= "FROM Student";
        return entityManager.createQuery(jdql).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public Student save(Student Student) {
         entityManager.persist(Student);
         return Student;
    }

    @Override
    public Student saveAndFlush(Student Student) {
        Student =  entityManager.merge(Student);
        entityManager.flush();
        return Student;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Student.class,id));
    }
}

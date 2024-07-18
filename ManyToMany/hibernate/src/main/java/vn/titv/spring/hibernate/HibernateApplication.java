package vn.titv.spring.hibernate;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.titv.spring.hibernate.dao.CourseDAO;
import vn.titv.spring.hibernate.dao.StudentDAO;
import vn.titv.spring.hibernate.dao.TeacherDAO;
import vn.titv.spring.hibernate.dao.TeacherDetailDAO;
import vn.titv.spring.hibernate.entity.Course;
import vn.titv.spring.hibernate.entity.Student;
import vn.titv.spring.hibernate.entity.Teacher;
import vn.titv.spring.hibernate.entity.TeacherDetail;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO,
											   TeacherDetailDAO teacherDetailDAO,
											   CourseDAO courseDAO,
											   StudentDAO studentDAO){
		return runner -> {
			// createTeacher(teacherDAO);

			// findTeacherById(teacherDAO, 1);

			// findTeacherDetailById(teacherDetailDAO, 1);

			// createCourses(teacherDAO, courseDAO);

			//findTeacherWithCourses(teacherDAO, 1);
			//findTeacherWithCourses(teacherDAO, 3);

			//findTeacherWithCourses_Lazy(teacherDAO, courseDAO, 1);
			//findTeacherWithCourses_Lazy(teacherDAO, courseDAO, 3);

			//findTeacherWithCourses_Lazy_JoinFetch(teacherDAO, 1);
			//findTeacherWithCourses_Lazy_JoinFetch(teacherDAO,3);

			//createCourseAndStudent(courseDAO, studentDAO);

			findCouseAndStudent(courseDAO, 14);
		};
	}

	private void findCouseAndStudent(CourseDAO courseDAO, int id) {
		//Course course = courseDAO.findCourseById(id);
		Course course = courseDAO.findCourseAndStudentByCourseId(id);
		System.out.println(course);

		// print students
		System.out.println(course.getStudents());

	}

	private void createCourseAndStudent(CourseDAO courseDAO, StudentDAO studentDAO) {
		// create course
		Course course=new Course();
		course.setTitle("Lập trình mạng");

		// create student
		Student st1 = new Student();
		st1.setFirstName("Tung");
		st1.setLastName("Le");

		Student st2= new Student();
		st2.setFirstName("Kiet");
		st2.setLastName("Anh");

		// add student into course
		course.addStudent(st1);
		course.addStudent(st2);

		courseDAO.save(course);
	}


	private void findTeacherWithCourses_Lazy_JoinFetch(TeacherDAO teacherDAO, int id) {
		Teacher teacher1 = teacherDAO.findTeacherByIdJoinFetch(id);
		System.out.println("Teacher's information: ");
		System.out.println(teacher1);

		// select course => REMOVE (KHONG CAN THIET)
		// List<Course> courses = courseDAO.findCourseByTeacherId(id);
		// teacher1.setCourses(courses);

		// print list courses
		System.out.println("List of courses: ");
		System.out.println(teacher1.getCourses());
	}
	private void findTeacherWithCourses_Lazy(TeacherDAO teacherDAO,CourseDAO courseDAO, int id) {
		Teacher teacher1 = teacherDAO.findTeacherById(id);
		System.out.println("Teacher's information: ");
		System.out.println(teacher1);

		// select course
		List<Course> courses = courseDAO.findCourseByTeacherId(id);
		teacher1.setCourses(courses);

		// print list courses
		System.out.println("List of courses: ");
		System.out.println(teacher1.getCourses());
	}

	private void findTeacherWithCourses(TeacherDAO teacherDAO, int id) {
		Teacher teacher1 = teacherDAO.findTeacherById(id);
		System.out.println("Teacher's information: ");
		System.out.println(teacher1);
		System.out.println("List of courses: ");
		System.out.println(teacher1.getCourses());
	}

	@Transactional
	private void createCourses(TeacherDAO teacherDAO, CourseDAO courseDAO) {
		// find a teacher
		Teacher teacher = new Teacher();
		teacher.setFirstName("Viễn Đông");
		teacher.setLastName("Phạm");
		teacher.setEmail("phamviendong@gmail.com");


		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setGender(true);
		teacherDetail.setAddress("Đồng Nai - Việt Nam");
		teacherDetail.setYoutubeChannel("@viendong");
		teacher.setTeacherDetail(teacherDetail);

		// create courses
		Course c1 = new Course("Spring Hibernate", "Description", null, null);
		Course c2 = new Course("Fullstack React and Spring Boot", "Description", null, null);

		// add courses
		teacher.addCourse(c1);
		teacher.addCourse(c2);

		System.out.println("Updating teacher ... ");
		teacherDAO.update(teacher);
		System.out.println("Done!");

	}

	private void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int id) {
		TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(id);
		System.out.println("TeacherDetail: " + teacherDetail);
		System.out.println("Teacher: " + teacherDetail.getTeacher());
	}

	private void findTeacherById(TeacherDAO teacherDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherById(id);
		System.out.println("Teacher: " + teacher);
		System.out.println("TeacherDetail: " + teacher.getTeacherDetail());
	}


	private void createTeacher(TeacherDAO teacherDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Nhat Tung");
		teacher.setLastName("Le");
		teacher.setEmail("lenhattung@gmail.com");


		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setGender(true);
		teacherDetail.setAddress("Warsaw - Poland");
		teacherDetail.setYoutubeChannel("@TITVvn");

		// associate the object
		teacher.setTeacherDetail(teacherDetail);


		// save
		System.out.println("Saving teacher .... " + teacher);
		teacherDAO.save(teacher);
		System.out.println("Done!");
	}


}

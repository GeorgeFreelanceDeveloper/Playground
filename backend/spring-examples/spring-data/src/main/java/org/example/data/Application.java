package org.example.data;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.example.data.model.*;
import org.example.data.repository.CourseRepository;
import org.example.data.repository.EnrolmentRepository;
import org.example.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    private EnrolmentRepository enrolmentRepository;

    @Autowired
    public Application(StudentRepository studentRepository, CourseRepository courseRepository, EnrolmentRepository enrolmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrolmentRepository = enrolmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        createStudents();
        createCourses();
        enrollmentStudentsToCourses();
        loadStudentsFromDatabase();
    }

    private void createStudents() {
        Faker faker = new Faker();
        final int countStudents = 10;

        System.out.printf("Creating %d fake students in the database%n", countStudents);
        List<Student> students = Stream.generate(() -> new Student(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.number().numberBetween(20, 30)))
                .limit(countStudents)
                .collect(Collectors.toList());

        students.forEach(student -> {
            StudentIdCard studentIdCard = new StudentIdCard();
            studentIdCard.setCardNumber(UUID.randomUUID().toString());
            student.setStudentIdCard(studentIdCard);
            studentIdCard.setStudent(student);

            int numBooks = faker.number().numberBetween(1, 10);

            for (int i = 0; i < numBooks; i++) {
                Book book = new Book();
                book.setBookName(faker.book().title());
                book.setCreatedAt(LocalDateTime.now());
                book.setStudent(student);
                student.getBooks().add(book);
            }
        });
        studentRepository.saveAll(students);
    }

    public void loadStudentsFromDatabase() {
        List<Student> students = studentRepository.findAll();

        for (Student student : students) {
            System.out.println("Student:");
            System.out.println(student);
            System.out.println("Student books:");
            System.out.println(student.getBooks());
            System.out.println("Enrolment courses:");
            List<Enrolment> enrolments = enrolmentRepository.findByStudentId(student.getId());
            System.out.println(enrolments.stream().map(e -> e.getCourse()).collect(Collectors.toList()));
        }
    }

    private void createCourses() {
        courseRepository.save(new Course("Java course", "IT"));
        courseRepository.save(new Course("SQL course", "IT"));
    }

    public void enrollmentStudentsToCourses() {
        Student student = studentRepository.findById(1L).get();
        Course course = courseRepository.findById(1L).get();
        Enrolment enrolment = new Enrolment(
                new EnrolmentId(student.getId(),course.getId()),
                student,
                course,
                LocalDateTime.now()
        );
        enrolmentRepository.save(enrolment);
    }
}

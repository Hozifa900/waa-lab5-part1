package Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StudentRepository studentsRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create students
		Student student = new Student(1, "John doe", "email@email.com",
				"0622341678", new Address("street", "city", "country"));
		studentsRepository.save(student);
		student = new Student(2, "John Jones", "email2@gmail.com",
				"0622341673", new Address("street", "city", "country"));
		studentsRepository.save(student);
		student = new Student(3, "James Johnson", "email3@gmail.com",
				"0622341671", new Address("street", "city", "country"));
		studentsRepository.save(student);

		// get all students
		System.out.println("-----------All students ----------------");
		System.out.println(studentsRepository.findAll());

		// get all students by name
		System.out.println("-----------All students by name ----------------");
		System.out.println(studentsRepository.findByName("John doe"));

		// get a student by phone
		System.out.println("-----------A student by phone ----------------");
		System.out.println(studentsRepository.findByPhone("0622341678"));

		// get all student by city
		System.out.println("-----------All students by city ----------------");
		System.out.println(studentsRepository.findByAddressCity("city"));

	}

}

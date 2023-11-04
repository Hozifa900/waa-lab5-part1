package Student;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findByPhone(String phone);

    public List<Student> findByName(String name);

    public List<Student> findByAddressCity(String city);
}

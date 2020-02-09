package springboot.spring_boot_example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.spring_boot_example.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}

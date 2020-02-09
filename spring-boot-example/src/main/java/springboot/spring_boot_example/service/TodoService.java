package springboot.spring_boot_example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.spring_boot_example.dao.TodoRepository;
import springboot.spring_boot_example.exception.RecordNotFoundException;
import springboot.spring_boot_example.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	
	@Autowired
	TodoRepository repository;
	
	public void deleteTodo(int id) {
		Iterator<Todo> iter =  todos.iterator();
		while(iter.hasNext()) {
			Todo currentTodo = iter.next();
			if(currentTodo.getId() == id) {
				iter.remove();
			}
		}
	}
	
	public List<Todo> getAllTodos(){
		List<Todo> allTodoList = repository.findAll();
		
		if(allTodoList.size()> 0) {
			return allTodoList;
		}
		return new ArrayList<Todo>();
	}
	
	public Todo createOrUpdateTodo(Todo todo) {
		repository.save(todo);
		return todo;
	}
	
	public void deleteTodoById(Long id) throws RecordNotFoundException {
		Optional<Todo> deletedTodo = repository.findById(id);
		
		if(deletedTodo.isPresent()) {
			repository.deleteById(id);
		}
		throw new RecordNotFoundException("No todo found with given id");
	}
}

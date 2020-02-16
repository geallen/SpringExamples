package springboot.spring_boot_example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public void deleteTodoById(int id) {
		
		repository.deleteById(id);
		
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
	
	public Todo updateTodo(int id, Todo todo) throws RecordNotFoundException {
	    Todo updatedTodo = repository.findById(id).orElseThrow(() -> new RecordNotFoundException("No record found with id: "+ id));
		
	    updatedTodo.setDesc(todo.getDesc());
	    updatedTodo.setUser(todo.getUser());
	    repository.save(updatedTodo);
		return updatedTodo;		
	}
	
	public Todo editTodo(int id)  {
	    Todo updatedTodo =repository.getOne(id);
		return convertTodo(updatedTodo);
		
	}
	
	private Todo convertTodo(Todo todo) {
		Todo newTodo = new Todo();
		newTodo.setId(todo.getId());
		newTodo.setDesc(todo.getDesc());
		newTodo.setDone(todo.isDone());
		newTodo.setTargetDate(todo.getTargetDate());
		newTodo.setUser(todo.getUser());
		return newTodo;
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
}

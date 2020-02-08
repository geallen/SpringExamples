package springboot.spring_boot_example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.spring_boot_example.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount =3;
	
	static {
		 todos.add(new Todo(1, "gamze", "Learn Spring MVC", new Date(),
	                false));
	        todos.add(new Todo(2, "jon", "Learn Struts", new Date(), false));
	        todos.add(new Todo(3, "monica", "Learn Hibernate", new Date(),
	                false));
	}
	
	public List<Todo> retriveTodos(String user){
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for(Todo todo : todos) {
			if(todo.getUser().equalsIgnoreCase(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
}

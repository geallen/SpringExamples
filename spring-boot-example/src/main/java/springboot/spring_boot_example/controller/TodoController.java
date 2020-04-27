package springboot.spring_boot_example.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import springboot.spring_boot_example.aspect.TrackTime;
import springboot.spring_boot_example.exception.RecordNotFoundException;
import springboot.spring_boot_example.model.Todo;
import springboot.spring_boot_example.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		List<Todo> todoList =  todoService.getAllTodos();
		model.put("todos", todoList);
		return "list-todos";
	}
	
	@RequestMapping(value = "/showTodo", method = RequestMethod.GET)
	public String showTodoPage() {
		return "todo";
	}
	
	@TrackTime
	@PostMapping(path = "/add-todo")
	public String addTodo(ModelMap model, @ModelAttribute("todo") Todo todo) {
		todo.setTargetDate(new Date());
		todoService.createOrUpdateTodo(todo);
		model.clear();
		return "redirect:/list-todos";
	}

	@RequestMapping(value= "/editTodo", method = RequestMethod.GET)
	public String editTodo(ModelMap model, @RequestParam(value="id") String id, Map<String, Object> mo) throws NumberFormatException, RecordNotFoundException {
		Todo updatedTodo = todoService.editTodo(Integer.parseInt(id));
		mo.put("todo", updatedTodo);
		return "editTodo";
	}
	
	@RequestMapping(value="/update-todo", method= RequestMethod.POST)
	public String updateTodo(String id, @ModelAttribute("todo") Todo todo) throws RecordNotFoundException {
		todoService.updateTodo(Integer.parseInt(id),todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/deleteTodoById", method= RequestMethod.GET)
	public String deleteTodoById(String id) {
		todoService.deleteTodoById(Integer.parseInt(id));
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/deleteAll", method = RequestMethod.GET)
	public String deleteAll() {
		todoService.deleteAll();
		return "redirect:/list-todos";
	}
}

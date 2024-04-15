package com.example.todo;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;

	public TodoApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

//		// Entry 1
//		Todo todo1 = new Todo("Junior Executive", "Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.\n\nSed ante. Vivamus tortor. Duis mattis egestas metus.\n\nAenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.", LocalDate.parse("4/7/2024", formatter), true, 1, LocalDate.parse("6/23/2023", formatter), "Job");
//		todoRepository.save(todo1);
//
//		// Entry 2
//		Todo todo2 = new Todo("Developer III", "Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.", LocalDate.parse("4/8/2024", formatter), true, 2, LocalDate.parse("7/24/2023", formatter), "Main");
//		todoRepository.save(todo2);
//
//		// Entry 3
//		Todo todo3 = new Todo("Associate Professor", "Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.", LocalDate.parse("4/4/2024", formatter), false, 2, LocalDate.parse("8/24/2023", formatter), "Main");
//		todoRepository.save(todo3);
//
//		// Entry 4
//		Todo todo4 = new Todo("Senior Cost Accountant", "Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.\n\nDuis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.", LocalDate.parse("4/3/2024", formatter), true, 2, LocalDate.parse("8/28/2023", formatter), "Job");
//		todoRepository.save(todo4);
//
//		// Entry 5
//		Todo todo5 = new Todo("Editor", "Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.", LocalDate.parse("3/26/2024", formatter), false, 3, LocalDate.parse("5/14/2023", formatter), "Main");
//		todoRepository.save(todo5);
//
//		// Entry 6
//		Todo todo6 = new Todo("Biostatistician I", "Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.\n\nProin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.\n\nDuis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.", LocalDate.parse("3/17/2024", formatter), false, 1, LocalDate.parse("6/10/2023", formatter), "Job");
//		todoRepository.save(todo6);
//
//		// Entry 7
//		Todo todo7 = new Todo("Actuary", "Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.", LocalDate.parse("4/8/2024", formatter), false, 3, LocalDate.parse("3/8/2024", formatter), "Main");
//		todoRepository.save(todo7);
//
//		// Entry 8
//		Todo todo8 = new Todo("Operator", "Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.\n\nNullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.", LocalDate.parse("3/31/2024", formatter), true, 2, LocalDate.parse("10/8/2023", formatter), "Main");
//		todoRepository.save(todo8);
//
//		// Entry 9
//		Todo todo9 = new Todo("Analyst Programmer", "Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.\n\nDonec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.", LocalDate.parse("4/3/2024", formatter), false, 2, LocalDate.parse("7/18/2023", formatter), "Job");
//		todoRepository.save(todo9);
//
//		// Entry 10
//		Todo todo10 = new Todo("Recruiter", "Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.\n\nInteger ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.", LocalDate.parse("3/21/2024", formatter), false, 2, LocalDate.parse("2/25/2024", formatter), "Job");
//		todoRepository.save(todo10);
//
//		// Entry 11
//		Todo todo11 = new Todo("Automation Specialist IV", "In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.\n\nAliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.", LocalDate.parse("3/27/2024", formatter), false, 3, LocalDate.parse("4/27/2023", formatter), "Main");
//		todoRepository.save(todo11);
//
//		// Entry 12
//		Todo todo12 = new Todo("Recruiting Manager", "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.", LocalDate.parse("4/1/2024", formatter), true, 3, LocalDate.parse("8/24/2023", formatter), "Job");
//		todoRepository.save(todo12);
//
//		// Entry 13
//		Todo todo13 = new Todo("Food Chemist", "Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.", LocalDate.parse("3/16/2024", formatter), false, 3, LocalDate.parse("4/21/2023", formatter), "Job");
//		todoRepository.save(todo13);
//
//		// Entry 14
//		Todo todo14 = new Todo("Cost Accountant", "In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\n\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.", LocalDate.parse("3/29/2024", formatter), false, 1, LocalDate.parse("3/15/2024", formatter), "Study");
//		todoRepository.save(todo14);
//
//		// Entry 15
//		Todo todo15 = new Todo("Registered Nurse", "Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.", LocalDate.parse("3/26/2024", formatter), false, 1, LocalDate.parse("2/20/2024", formatter), "Main");
//		todoRepository.save(todo15);
//
//		// Entry 16
//		Todo todo16 = new Todo("Structural Analysis Engineer", "In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.\n\nNulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.", LocalDate.parse("3/24/2024", formatter), false, 3, LocalDate.parse("12/8/2023", formatter), "Study");
//		todoRepository.save(todo16);
//
//		// Entry 17
//		Todo todo17 = new Todo("Financial Advisor", "In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.\n\nSuspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.\n\nMaecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.", LocalDate.parse("3/19/2024", formatter), true, 2, LocalDate.parse("6/16/2023", formatter), "Main");
//		todoRepository.save(todo17);
//
//		// Entry 18
//		Todo todo18 = new Todo("Programmer Analyst IV", "In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.\n\nMaecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.\n\nMaecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.", LocalDate.parse("3/25/2024", formatter), true, 3, LocalDate.parse("3/23/2023", formatter), "Study");
//		todoRepository.save(todo18);
//
//		// Entry 19
//		Todo todo19 = new Todo("Senior Editor", "Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.", LocalDate.parse("3/17/2024", formatter), true, 2, LocalDate.parse("3/10/2024", formatter), "Main");
//		todoRepository.save(todo19);
//
//		// Entry 20
//		Todo todo20 = new Todo("Research Associate", "Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.", LocalDate.parse("3/28/2024", formatter), false, 1, LocalDate.parse("7/31/2023", formatter), "Study");
//		todoRepository.save(todo20);
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}

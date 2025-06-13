package com.vitorbnr.todolist;

import com.vitorbnr.todolist.entity.Todo;
import com.vitorbnr.todolist.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private TodoRepository todoRepository;

	private List<Todo> todos;

	@BeforeEach
	public void setup() {
		todoRepository.deleteAll();

		var todoList = List.of(
				new Todo("Todo 1", "Desc 1", false, 3),
				new Todo("Todo 2", "Desc 2", true, 1),
				new Todo("Todo 3", "Desc 3", false, 2),
				new Todo("Todo 4", "Desc 4", true, 3),
				new Todo("Todo 5", "Desc 5", false, 1)
		);
		this.todos = todoRepository.saveAll(todoList);
	}

	@Test
	void testCreateTodoSuccess() {
		var newTodo = new Todo("Novo Todo", "Desc Nova", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(newTodo)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(6);
	}

	@Test
	public void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Todo("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	public void testUpdateTodoSuccess() {
		Todo todoToUpdate = todos.get(0);

		var updatedTodo = new Todo(
				todoToUpdate.getId(),
				"Nome Atualizado",
				"Desc Atualizada",
				!todoToUpdate.isRealizado(),
				todoToUpdate.getPrioridade() + 1
		);

		webTestClient
				.put()
				.uri("/todos/" + todoToUpdate.getId())
				.bodyValue(updatedTodo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$[0].nome").isEqualTo("Nome Atualizado");
	}

	@Test
	public void testUpdateTodoFailure() {
		long nonExistentId = 999L;
		webTestClient
				.put()
				.uri("/todos/" + nonExistentId)
				.bodyValue(new Todo(nonExistentId, "a", "b", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	public void testDeleteTodoSuccess() {
		Long idToDelete = todos.get(0).getId();

		webTestClient
				.delete()
				.uri("/todos/" + idToDelete)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(4);
	}

	@Test
	public void testDeleteTodoFailure() {
		long nonExistentId = 999L;
		webTestClient
				.delete()
				.uri("/todos/" + nonExistentId)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	public void testListTodos() {
		webTestClient
				.get()
				.uri("/todos")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(5);
	}
}

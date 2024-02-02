package com.example.testCRUD;

import com.example.testCRUD.controllers.StudentController;
import com.example.testCRUD.entities.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")

class TestCrudApplicationTests {

	@Autowired
	private StudentController studentController;

	@Autowired
	private MockMvc mockMvc;    // iniezione di MockMvc che viene usato per la simulazione di chiamate Https

	@Autowired
	private ObjectMapper objectMapper;
	private MvcResult createStudent  () throws Exception {
		//creo uno student e imposto i settaggi
		Student student = new Student();

		student.setWorking(true);
		student.setName("Andrea");
		student.setSurname("Rossi");
		return createStudent(student);
	}

	private MvcResult createStudent  (Student student) throws Exception {
		if (student == null)  {
			return null;
		}
		// creo un formato JSON di student per la POST request
		String studentJSON = objectMapper.writeValueAsString(student);

		return this.mockMvc.perform(post("/v1/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	private Student madeAStudent () throws Exception {
		Student student = new Student();

		student.setWorking(true);
		student.setName("Andrea");
		student.setSurname("Rossi");
		return madeAStudent(student);
	}

	private Student madeAStudent (Student student) throws Exception {
		MvcResult result = createStudent();

		Student studentFromReponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		return studentFromReponse;
	}

	private Student getStudentById(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/v1/" + id))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println(result.toString());
		String content = result.getResponse().getContentAsString();
		if (content.isEmpty()) {
			return null;
		}

		return objectMapper.readValue(content, Student.class);
	}


	@Test
	void contextLoads() {
		assertThat(studentController).isNotNull();
	}


	@Test
	void testCreateStudent() throws Exception {

		Student studentFromReponse = madeAStudent();
		assertThat(studentFromReponse.getId()).isNotNull();
	}

	@Test
	void readAllStudent() throws Exception {
		createStudent();

		MvcResult result = (MvcResult) this.mockMvc.perform(get("/v1/allStud"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<Student> studentFromReponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("Students in database are: " + studentFromReponse.size());
		assertThat(studentFromReponse.size()).isNotZero();
	}

	@Test
	void readingSingleStudent () throws Exception {
		Student student = madeAStudent();
		Student student1 = madeAStudent();
		Student student2 = madeAStudent();
		assertThat(student.getId()).isNotNull();

		Student studentFromReponse = getStudentById(student.getId());
		assertThat(studentFromReponse.getId()).isEqualTo(student.getId());

	}

	@Test
	void updateSingleStudent () throws Exception {
		Student student = madeAStudent();
		student.setName("Kelly");
		student.setSurname("Singer");
		student.setWorking(true);
		assertThat(student.getId()).isNotNull();

		String studentJSON = objectMapper.writeValueAsString(student);

		MvcResult result = this.mockMvc.perform(put("/v1/"+student.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromResponse.getName()).isEqualTo("Kelly");

		Student studentFromReponseGet = getStudentById(student.getId());
		assertThat(studentFromReponseGet.getId()).isEqualTo(student.getId());


	}

	@Test
	void deleteStudent () throws Exception {
		Student student = madeAStudent();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/v1/"+student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromReponseGet = getStudentById(student.getId());
		assertThat(studentFromReponseGet).isNull();

	}

	@Test
	void activateStudent () throws Exception{
		Student student = madeAStudent();
		assertThat(student.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(put("/v1/"+student.getId()+ "/working?working=true"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromReponse = getStudentById(student.getId());
		assertThat(studentFromReponse.getId()).isEqualTo(student.getId());
		assertThat(studentFromReponse.isWorking()).isEqualTo(true);

		Student studentFromReponseGet = getStudentById(student.getId());
		assertThat(studentFromReponseGet.getId()).isEqualTo(student.getId());
		assertThat(studentFromReponseGet.isWorking()).isEqualTo(true);

	}
}

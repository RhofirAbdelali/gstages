package miage.abdelali.ari.Controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
	private String ctrlUrl = "/students";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetStudentById() throws Exception {
		long studentId = 2L;
		mockMvc.perform(get(ctrlUrl + "/id/" + studentId)).andExpect(status().isOk()).andExpect(result -> {
			String actualResult = result.getResponse().getContentAsString();
			assertThat(actualResult).contains("karim");
		});

	}

}

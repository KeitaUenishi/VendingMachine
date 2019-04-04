package product.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class PurchaseControllerTest {

	private MockMvc sut;

	@Autowired
	private PurchaseController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void 自動販売機トップページのリクエスト結果が正常となりViewとしてsimulationが返る事() throws Exception {
		sut.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	@Test
	public void 自動販売機トップページで金額入力欄をNULLにして購入ボタンを押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/"))
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(view().name("index"));
	}

	@Test
	public void 自動販売機トップページで金額入力欄をを空にして購入ボタンを押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("amount", ""))
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(view().name("index"));
	}

	@Test
	public void 自動販売機トップページで金額入力欄をを空白を入れて購入ボタンを押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("amount", " "))
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(view().name("index"));
	}

	@Test
	public void 自動販売機トップページで金額入力欄に不正な値を入れて購入ボタンを押すと例外情報が入った状態で画面が返る事() throws Exception {
		sut.perform(post("/").param("amount", "不正な金額"))
			.andExpect(status().isOk())
			.andExpect(model().hasErrors())
			.andExpect(view().name("index"));
	}

}

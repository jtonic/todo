package ro.jtonic.apps.todo.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import ro.jtonic.apps.todo.ComponentTag;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ComponentTag
class TodoApplication2Test {

	private final ApplicationContext ctx;

	public TodoApplication2Test(ApplicationContext ctx) {
		this.ctx = ctx;
		System.out.println("ctx.hashCode() 2 = " + ctx.hashCode());
	}

	@DisplayName("simple spring boot test")
	@Test
	void testComponent() {
		Assertions.assertNotNull(this.ctx);
	}
}

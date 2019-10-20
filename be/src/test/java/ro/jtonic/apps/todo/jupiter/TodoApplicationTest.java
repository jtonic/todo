package ro.jtonic.apps.todo.jupiter;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import ro.jtonic.apps.todo.ComponentTag;

@SpringBootTest(properties = {"logging.level.ro.jtonic.apps.todo=ERROR"}, webEnvironment = WebEnvironment.RANDOM_PORT)
@ComponentTag
class TodoApplicationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TodoApplicationTest.class);
	private final ApplicationContext ctx;

	public TodoApplicationTest(ApplicationContext ctx) {
		this.ctx = ctx;
		System.out.println("ctx.hashCode() 1 = " + ctx.hashCode());
	}

	@BeforeEach
	void setUp() {
		assertNotNull(ctx);
	}


	private static String[][] personInfoProvider() {
		return new String[][]{
				{"1", "jtonic"},
				{"2", "rubita"},
				{"3", "tutye"},
		};
	}

	@DisplayName("should print all names")
	@ParameterizedTest(name = "{index} ==> uuid=''{0}'', name=''{1}''")
	@MethodSource("personInfoProvider")
	void contextLoads(String uuid, String name) {
		LOGGER.debug(String.format("Person info:\n\tuuid=%s\tName: %s", uuid, name));
		Assertions.assertTrue(true);
	}

	@Test
	void testComponent() {
		LOGGER.debug("[DEBUG]Component test");
		LOGGER.info("[INFO]Component test");
		LOGGER.warn("[WARN]Component test");
		LOGGER.error("[ERROR]Component test");
		Assertions.assertTrue(true);
	}
}

package ro.jtonic.apps.todo;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.EnableJUnit4MigrationSupport;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableJUnit4MigrationSupport
class TodoApplicationVintageTest {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}
	
	@Ignore
	@Test
	void test2() {
		Assertions.assertTrue(true);
	}
}

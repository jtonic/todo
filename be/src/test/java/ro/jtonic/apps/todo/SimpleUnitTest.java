package ro.jtonic.apps.todo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by Antonel Ernest Pazargic on 06/10/2019.
 *
 * @author Antonel Ernest Pazargic
 */
public class SimpleUnitTest {
  
  public static final Logger LOGGER = LoggerFactory.getLogger(SimpleUnitTest.class);
  
  @Test
  public void testLogging() {
     LOGGER.debug("This is debug");
  }
}

package ro.jtonic.apps.todo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;

/**
 * Created by Antonel Ernest Pazargic on 06/10/2019.
 *
 * @author Antonel Ernest Pazargic
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Tag("component")
@interface ComponentTag {
  
}

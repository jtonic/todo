package ro.jtonic.apps.todo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("ro.jtonic.apps.todo")
@IncludeTags("component")
public class ComponentTestSuite {
}

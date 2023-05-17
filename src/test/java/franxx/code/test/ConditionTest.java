package franxx.code.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {
    @Test
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableOnWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    public void testEnableOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    public void testDisabledOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_20)
    public void testEnabledOnJava17to20() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_20)
    public void testDisabledOnJava17to20() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "os.arch", matches = "amd64"),
            @EnabledIfSystemProperty(named = "os.name", matches = "Linux")
    })
    public void testEnableLinuxAmd64() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "os.arch", matches = "amd64"),
            @DisabledIfSystemProperty(named = "os.name", matches = "Linux")
    })
    public void testDisableLinuxAmd64() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev() {

    }
}

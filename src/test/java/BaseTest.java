import com.codeborne.selenide.Configuration;
import io.qameta.allure.Param;
import org.junit.Before;

public class BaseTest {

    final String baseUrl = "http://192.168.169.222:8097/";
    final String loginBalanceHolder = "5614019926";
    final String passwordBalanceHolder = "wyqn3YkV";

    @Before
    public void browserConfiguration() {
        Configuration.browser = "chrome";
    }
}

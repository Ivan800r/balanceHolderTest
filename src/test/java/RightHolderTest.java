import io.qameta.allure.Description;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class RightHolderTest extends BaseTest{
    String randomString = RandomStringUtils.randomAlphabetic(10);

    @Test
    @Description("Тест получает адрес балансодержателя")
    public void successAuthWithExistLoginAndPassword() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(loginBalanceHolder,passwordBalanceHolder);
        RightHolderPage rightHolderPage = page(RightHolderPage.class);
        assertEquals("Прореряем видимость текста в адресе", "БАРС-БАЛАНСОДЕРЖАТЕЛЬ", rightHolderPage.getTextAttr());
    }
}

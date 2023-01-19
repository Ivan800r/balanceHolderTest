import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang.RandomStringUtils;

@Epic("Авторизация")
public class LoginPageTest extends BaseTest{
    String randomString = RandomStringUtils.randomAlphabetic(10);

    @Test
    @Description("Тест проверяет, что авторизация прошла успешно, и открылась вкладка Правообладатель")
    public void successAuthWithExistLoginAndPassword() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(loginBalanceHolder,passwordBalanceHolder);
        HeaderBalanceHolderPage rightHolderPage = page(HeaderBalanceHolderPage.class);
        assertEquals("Прореряем видимость текста 'БАРС-БАЛАНСОДЕРЖАТЕЛЬ'", "БАРС-БАЛАНСОДЕРЖАТЕЛЬ", rightHolderPage.getTextHeadingRightHolder());
    }

    @Test
    @Description("Тест проверяет, что авторизация прошла успешно, открылась вкладка Правообладатель и пользователь нажал на кнопку Выход")
    public void successAuthAndExit() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(loginBalanceHolder,passwordBalanceHolder);
        RightHolderPage rightHolderPage = page(RightHolderPage.class);
        rightHolderPage.clickLogOutButton();
        login =  page(LoginPage.class);
        assertEquals("Прореряем видимость текста 'Введите свой логин и пароль'", "Введите свой логин и пароль", login.getTextEnterLoginAndPassword());
    }

    @Test
    @Description("Тест проверяет, что авторизация не прошла для существующего логина, и НЕ существующего пароля")
    public void badAuthWithExistLoginAndNotExistPassword() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(loginBalanceHolder, randomString);
        assertEquals("Прореряем видимость текста 'Неверный логин или пароль'", "Неверный логин или пароль", login.getTextErrorAuth());
    }

    @Test
    @Description("Тест проверяет, что авторизация не прошла для НЕ существующего логина, и существующего пароля")
    public void badAuthWithNotExistLoginAndExistPassword() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(randomString, passwordBalanceHolder);
        assertEquals("Прореряем видимость текста 'Неверный логин или пароль'", "Неверный логин или пароль", login.getTextErrorAuth());
    }

    @Test
    @Description("Тест проверяет, что авторизация не прошла для НЕ существующего логина и пароля")
    public void badAuthWithNotExistLoginAndPassword() {
        LoginPage login= open(baseUrl,
                LoginPage.class);
        login.login(randomString, randomString);
        assertEquals("Прореряем видимость текста 'Неверный логин или пароль'", "Неверный логин или пароль", login.getTextErrorAuth());
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

}

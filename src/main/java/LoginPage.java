
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
    //локатор для ввода логина
    @FindBy(how = How.ID,using = "userName_I")
    private SelenideElement loginUserField;

    //локатор для ввода пароля
    @FindBy(how = How.ID,using = "password_I")
    private SelenideElement passwordUserField;

    //локатор кнопки входа в приложение
    @FindBy(how = How.ID,using = "btnLogin")
    public SelenideElement signInButton;

    //локатор для надписи Неверный логин или пароль
    @FindBy(how = How.ID,using = "lblError")
    private SelenideElement errorAuthtext;

    //локатор для надписи Введите свой логин и пароль
    @FindBy(how = How.ID,using = "ASPxLabel1")
    private SelenideElement enterLoginAndPasswordText;

    public String getTextErrorAuth() {
        return this.errorAuthtext.getText();
    }

    public String getTextEnterLoginAndPassword() {
        return this.enterLoginAndPasswordText.getText();
    }

    public void setLoginUser(String loginUserField) {
        this.loginUserField.setValue(loginUserField);
    }

    public void setPasswordUser(String passwordUserField) {
        this.passwordUserField.setValue(passwordUserField);
    }

    //метод клика по кнопке авторизации
    public void clickSignInButton() {
        signInButton.click();
    }

    //метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String username, String password){
        setLoginUser(username);
        setPasswordUser(password);
        clickSignInButton();
    }

}

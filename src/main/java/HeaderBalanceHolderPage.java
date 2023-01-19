import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderBalanceHolderPage {
    //локатор для надписи БАРС-БАЛАНСОДЕРЖАТЕЛЬ
    @FindBy(how = How.ID,using = "cationDiv")
    private SelenideElement headingRightHolderText;

    //локатор для кнопки Выход
    @FindBy(how = How.ID,using = "LogOutButton")
    private SelenideElement logOutBalanceHolderButton;

    public String getTextHeadingRightHolder() {
        return this.headingRightHolderText.getText();
    }

    public void clickLogOutButton() {
        logOutBalanceHolderButton.click();
    }
}

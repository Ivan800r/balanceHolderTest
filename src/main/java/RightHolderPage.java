import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class RightHolderPage extends HeaderBalanceHolderPage{
    //локатор для таблицы с текстовыми атрибутами
    @FindBy(how = How.XPATH,using = ".//table[contains(@class,'TextAttr')]/tbody/tr/td/input")
    private SelenideElement attrTextTable;

    public String getTextAttr() {
        return attrTextTable.getValue();
    }

}

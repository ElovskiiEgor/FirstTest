// 10 october 2026
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MyTest {

    @BeforeAll
    static void SetUpBrowser() {
// Настройка браузера
        Configuration.browser = "chrome";
        Configuration.browserSize = "1900x1200";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void Test() {
        open("/text-box");
        $("h1").shouldHave(text("Text Box"));
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@mail.ru");
        $("#currentAddress").setValue("Moscow sity");
        $("#permanentAddress").setValue("Lenina 244 /45");
        $("#submit").shouldHave(text("Submit")).hover().click();
        $("#name").shouldHave(text("Egor")).shouldBe(visible);
    }
}
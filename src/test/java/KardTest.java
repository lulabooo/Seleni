package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class KardTest {
    SelenideElement form = $(".form");
    @Test
    public void setup() {
        open("http://localhost:7777/");
    }
    public void shouldTest1() {
        form.$("[data-test-id=name] input").setValue("Логинова Мария");
        form.$("[data-test-id=phone] input").setValue("+79219864218");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import org.junit.*;
import static org.junit.Assert.*;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("");
    }

  @Test
    public void checkHomePage() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Enter an amount");
    }

  @Test
    public void enterCoinAmount() {
      goTo("http://localhost:4567/");
      fill("#coinage").with("90");
      submit(".btn-info");
      assertThat(pageSource()).contains("Here's what'cha got: 3 quarters, 1 dime, 1 nickel, and no pennies.");
    }

  @Test
    public void enterLimitedCoin() {
      goTo("http://localhost:4567/");
      fill("#limitCoinInput").with("125");
      submit(".btn-warning");
      assertThat(pageSource()).contains("So, here's what you get: 4 quarters, 2 dimes, 1 nickel, and no pennies.");
    }
}

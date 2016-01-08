import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void coinCombo_shouldGiveCoinCombo75Cents_3Quarters() {
    App app = new App();
    String coinResult = "Here's what'cha got: 3 quarters, no dimes, no nickels, and no pennies.";
    assertEquals(coinResult, app.coinCombo(75));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombo85Cents_3Quarters1Dime() {
    App app = new App();
    String coinResult = "Here's what'cha got: 3 quarters, 1 dime, no nickels, and no pennies.";
    assertEquals(coinResult, app.coinCombo(85));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombos90Cents_3Quarters1Dime1Nickel() {
    App app = new App();
    String coinResult = "Here's what'cha got: 3 quarters, 1 dime, 1 nickel, and no pennies.";
    assertEquals(coinResult, app.coinCombo(90));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombos90Cents_3Quarters1Dime1Nickel3Pennies() {
    App app = new App();
    String coinResult = "Here's what'cha got: 3 quarters, 1 dime, 1 nickel, and 3 pennies.";
    assertEquals(coinResult, app.coinCombo(93));
  }
  @Test
  public void limitedCoins_shouldGiveCoinCombos125Cents_4Quarters2Dime1Nickel() {
    App app = new App();
    String coinResult = "So, here's what you get: 4 quarters, 2 dimes, 1 nickel, and no pennies.";
    assertEquals(coinResult, app.limitedCoins(125));
  }
}

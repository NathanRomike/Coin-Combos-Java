import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void coinCombo_shouldGiveCoinCombo75Cents_3Quarters() {
    App app = new App();
    String coinResult = "Your change is 3 quarters, 0 dimes, 0 nickels, and 0 pennies";
    assertEquals(coinResult, app.coinCombo("75"));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombo85Cents_3Quarters1Dime() {
    App app = new App();
    String coinResult = "Your change is 3 quarters, 1 dimes, 0 nickels, and 0 pennies";
    assertEquals(coinResult, app.coinCombo("85"));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombos90Cents_3Quarters1Dime1Nickel() {
    App app = new App();
    String coinResult = "Your change is 3 quarters, 1 dimes, 1 nickels, and 0 pennies";
    assertEquals(coinResult, app.coinCombo("90"));
  }

  @Test
  public void coinCombo_shouldGiveCoinCombos90Cents_3Quarters1Dime1Nickel3Pennies() {
    App app = new App();
    String coinResult = "Your change is 3 quarters, 1 dimes, 1 nickels, and 3 pennies";
    assertEquals(coinResult, app.coinCombo("93"));
  }
}

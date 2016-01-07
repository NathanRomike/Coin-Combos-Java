import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static String coinCombo(String userInput) {
    Integer userCoins = Integer.parseInt(userInput);

    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    Integer pennies = 0;

    while ( userCoins >= 25 ) {
      userCoins -= 25;
      quarters++;
    }

    while ( userCoins >= 10) {
      userCoins -= 10;
      dimes++;
    }

    while ( userCoins >= 5) {
      userCoins -= 5;
      nickels++;
    }

    while ( userCoins > 0) {
      userCoins -= 1;
      pennies++;
    }

    return String.format("Your change is %d quarters, %d dimes, %d nickels, and %d pennies", quarters, dimes, nickels, pennies);
  }
}

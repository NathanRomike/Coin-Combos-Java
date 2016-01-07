import java.util.Map;
import java.util.HashMap;
import javax.swing.JOptionPane;

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

    get("/results", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/results.vtl" );

      String userCoinString = request.queryParams("coinage");
      model.put("userCoinString", userCoinString);

      Integer looseChange = Integer.parseInt(userCoinString);

      System.out.println(looseChange);

      // if (looseChange == null) {
      //   JOptionPane.showMessageDialog (null, "Don't be a jerk. Put in an actual number, please.");
      // }

      String finalResult = coinCombo(looseChange);
      model.put("finalResult", finalResult);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String coinCombo(Integer userCoins) {

    String output = "Here's what'cha got: ";

    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    Integer pennies = 0;

    while ( userCoins >= 25 ) {
      userCoins -= 25;
      quarters++;
    }

    if (quarters == 1) {
      output += (quarters + " quarter, ");
    } else if (quarters > 1) {
      output += (quarters + " quarters, ");
    } else {
      output += "No quarters, ";
    }


    while ( userCoins >= 10) {
      userCoins -= 10;
      dimes++;
    }

    if (dimes == 1) {
      output += (dimes + " dime, ");
    } else if (dimes > 1) {
      output += (dimes + " dimes, ");
    } else {
      output += "no dimes, ";
    }

    while ( userCoins >= 5) {
      userCoins -= 5;
      nickels++;
    }

    if (nickels == 1) {
      output += (nickels + " nickel, ");
    } else if (nickels > 1) {
      output += (nickels + " nickels, ");
    } else {
      output += "no nickels, ";
    }

    while ( userCoins > 0) {
      userCoins -= 1;
      pennies++;
    }

    if (pennies == 1) {
      output += ("and " + pennies + " penny.");
    } else if (pennies > 1) {
      output += ("and " + pennies + " pennies.");
    } else {
      output += "and no pennies.";
    }

    return output;
  }
}

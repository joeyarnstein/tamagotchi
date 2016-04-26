//import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("pets", request.session().attribute("pets"));
      model.put("template", "templates/index.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/pet", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<Tamagotchi> pets = request.session().attribute("pets");

      if (pets == null){
        pets = new ArrayList<Tamagotchi>();
        request.session().attribute("pets", pets);
      }

      String name = request.queryParams("tama");
      String age = request.queryParams("age");
      String image = request.queryParams("image");
      Tamagotchi newTama = new Tamagotchi(name, age, image);
      pets.add(newTama);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}

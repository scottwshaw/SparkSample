package app;
import spark.ModelAndView;
import views.EnliveTemplatingEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
/**
 * Created by sshaw on 9/10/2015.
 */
public class SparkSample     {
    public static void main(String[] args) {
        Map model = new HashMap();
        get("/app/:name", (req, res) -> {
            model.put("name", req.params(":name"));
            return new ModelAndView(model, "app");
        }, new EnliveTemplatingEngine());
        get("/hellofrom/:to/:from", (req, res) -> {
            model.put("to", req.params(":to"));
            model.put("from", req.params(":from"));
            return new ModelAndView(model,"hellofrom");
        }, new EnliveTemplatingEngine());
        get("/goodbye", (req, res) -> "Bye bye");
    }
}
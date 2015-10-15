package hello;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
/**
 * Created by sshaw on 9/10/2015.
 */
public class Hello {
    public static void main(String[] args) {
        Map model = new HashMap();
        get("/hello/:name", (req, res) -> {
            model.put("name", req.params(":name"));
            return new ModelAndView(model,"hello");
        }, new EnliveTemplatingEngine());
        get("/hellofrom/:to/:from", (req, res) -> {
            model.put("to", req.params(":to"));
            model.put("from", req.params(":from"));
            return new ModelAndView(model,"hellofrom");
        }, new EnliveTemplatingEngine());
        get("/goodbye", (req, res) -> "Bye bye");
    }
}
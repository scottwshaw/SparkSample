package hello;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark_sample.views.*;

/**
 * Created by sshaw on 12/10/2015.
 */
public class EnliveTemplatingEngine extends TemplateEngine {
    @Override
    public String render(ModelAndView modelAndView) {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("spark_sample.views.core"));
        IFn view = Clojure.var("spark_sample.views.core", modelAndView.getViewName());
        IFn renderView = Clojure.var("spark_sample.views.core", "render-view");
        return renderView.invoke(view, modelAndView.getModel()).toString();
    }
}

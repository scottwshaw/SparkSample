(ns spark_sample.views.core
    (:require [net.cgrand.enlive-html :as html])
  (:import [java.util HashMap]))

(defn render-view [view ctxt]
  (let [keys (HashMap/.keySet ctxt)
        vals (HashMap/.values ctxt)
        ctxt_map (zipmap (map keyword keys) vals)]
    (apply str (view ctxt_map))))

(html/deftemplate hello "hello.html" [ctxt]
                  ;;
                  [:span#name] (html/content (:name ctxt)))

(html/deftemplate hellofrom "hellofrom.html" [ctxt]
                  ;;
                  [:span#to] (html/content (:to ctxt))
                  [:span#from] (html/content (:from ctxt)))




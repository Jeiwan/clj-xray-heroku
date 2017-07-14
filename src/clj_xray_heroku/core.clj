(ns clj-xray-heroku.core
  (:require [clj-xray-heroku.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.aws.xray :refer [wrap-xray-segment]]))

(defn -main [& args]
  (let [port (System/getenv "PORT")]
    (if port
      (do
        (println "Starting server...")
        (run-jetty (-> app (wrap-xray-segment {:segment "dummy"})) {:port (Integer. port)}))
      (println "Uh-oh! Port is not set!"))))

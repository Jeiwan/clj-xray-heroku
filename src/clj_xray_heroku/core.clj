(ns clj-xray-heroku.core
  (:require [clj-xray-heroku.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn -main [& args]
  (let [port (System/getenv "PORT")]
    (if port
      (do
        (println "Starting server...")
        (run-jetty app {:port (Integer. port)}))
      (println "Uh-oh! Port is not set!"))))

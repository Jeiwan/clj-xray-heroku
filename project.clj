(defproject clj-xray-heroku "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :main clj-xray-heroku.core
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.6.0"]
                 [ring/ring-defaults "0.3.0"]
                 [ring "1.6.1"]
                 [org.clojars.jaakkos/clj-aws-xray "0.0.4"]
                 [hiccup "1.0.5"]]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})

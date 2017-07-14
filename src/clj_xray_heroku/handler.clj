(ns clj-xray-heroku.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :refer [html5]]
            [hiccup.form :refer [form-to text-area submit-button]]))

(def main-page
  (html5
   [:head
    [:title "Woot"]]
   [:body
     [:h1 "Hello, world!"]
     (form-to [:post "/post"]
              (text-area "text")
              (submit-button "Send"))]))

(def post-page
  (html5
   [:head
    [:title "Post"]]
   [:body
    [:h1 "Posted!"]]))

(defroutes app-routes
  (GET "/" [] main-page)
  (POST "/post" [] post-page)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))

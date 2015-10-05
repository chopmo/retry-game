(ns retry.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/robots.txt" [] "User-agent: *")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

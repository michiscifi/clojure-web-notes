(ns notebook.route
  (:require [compojure.core :refer [defroutes GET POST ANY]]
            [notebook.handler.note :as note]
            [notebook.handler.home :as home]))

(defroutes
  app-routes
  (GET "/" request (home/index request))
  (GET "/note" request (note/index request))
  (GET "/note/search" request (note/search request))
  (GET "/note/create-form" request (note/create-form request))
  (POST "/note/create" request (note/create request))
  (GET "/note/read/:uuid" [uuid] (note/read uuid))
  (GET "/note/update-form/:uuid" request (note/update-form request))
  (POST "/note/update" request (note/update request))
  (GET "/note/delete/:uuid" [uuid] (note/delete uuid))
  (ANY "/set-session" request (home/set-session request))
  (GET "/read-session" request (home/read-session request))
  (GET "/error" request (home/error request)))

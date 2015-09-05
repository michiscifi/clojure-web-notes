(ns notebook.core
  [:require
    ;[notebook.app :refer [app]]
    [ring.adapter.jetty :refer [run-jetty]]]
  (:gen-class))

(use 'notebook.app)

(defn -main
  "starts a jetty container"
  [& args]
  (run-jetty app {:port 3000}))

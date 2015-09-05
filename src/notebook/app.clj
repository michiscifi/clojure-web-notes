(ns notebook.app
  (:require [ring.middleware.defaults :refer :all]
            [ring.logger :as logger]
            [notebook.route :refer [app-routes]]))

; ;;;;;;;
; below the better version of this:
;
;(def app
;  (logger/wrap-with-logger
;    (wrap-defaults app-routes site-defaults)))
;
(defonce app
  (-> #'app-routes
      (wrap-defaults site-defaults)
      (logger/wrap-with-logger)))
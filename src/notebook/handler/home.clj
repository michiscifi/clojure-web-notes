(ns notebook.handler.home
  (:require [selmer.parser :refer [render-file]]))

(use 'ring.util.response)

(selmer.parser/cache-off!)

(defn index [request]
  (render-file "templates/home/index.html" {}))

(defn error [request]
  (render-file "templates/home/error.html" {}))


(defn set-session [{session        :session
                    request-method :request-method
                    params         :params}]
  (def body (render-file "templates/home/set-session.html" {:farbe (:farbe session)}))
  (def resp {:body body :session session})
  (println session)
  (if (= request-method :post)
    (assoc resp :session (assoc session :farbe (:farbe params)))
    resp))


(defn read-session [{session :session}]
  (let [data {:session session}]
    (render-file "templates/home/read-session.html" data)))




;(defn set-session [request]
;  (let [session (:session request)
;        session-augmented (assoc session :farbe "rot")]
;    (-> (response (str "hallo"))
;        (assoc :session session-augmented))))
;
;(defn read-session [request]
;  (def session (:session request))
;  (def resp (response (str "fluppi")))
;  resp
;  )
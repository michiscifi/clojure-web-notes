(ns notebook.handler.note
  (:refer-clojure
    :exclude [read update])
  (:require [ring.util.response :refer [redirect]]
            [selmer.parser :refer [render-file]]
            [notebook.tool :as tool]
            [notebook.data.provider.note :as note-provider]))
(use 'ring.util.anti-forgery)
(selmer.parser/cache-off!)

(defn index [request]
  (render-file "templates/note/index.html" {}))


(defn create-form [request]
  (render-file
    "templates/note/create-form.html" {:tokenfield (anti-forgery-field)}))
;"templates/note/create-form.html" {:tokenfield (tool/make-anti-forgery-field)}))

(defn create [request]
  (let [uuid (tool/make-uuid)
        content ((request :params) :content)]
    (if (note-provider/create uuid content)
      (redirect (str "/note/read/" uuid))
      (redirect "/error"))))

(defn read [uuid]
  (def note (note-provider/read uuid))
  (render-file "templates/note/read.html" {:note note}))

(defn update-form [request]
  (let [uuid ((request :params) :uuid)
        note (note-provider/read uuid)]
    (render-file "templates/note/update-form.html" {:note note :tokenfield (anti-forgery-field)})))

(defn update [request]
  (let [uuid ((request :params) :uuid)
        content ((request :params) :content)]
    (if (note-provider/update uuid content)
      (redirect (str "/note/read/" uuid))
      (redirect "/error"))))


(defn delete [uuid]
  (if (note-provider/delete uuid)
    (redirect (str "/note/search"))
    (redirect "/error")))


(defn search [request]
  (let [_notes (note-provider/search (str "%" (:term (:params request)) "%"))
        notes (map (fn [e]
                     {:uuid    (:uuid e)
                      :content (:content e)
                      :title   (clojure.string/join " "
                                                    (take 7
                                                          (seq (clojure.string/split (:content e) #"\s"))))})
                   _notes)]
    (render-file "templates/note/list.html" {:notes notes})))



;(defn create [request]
;  (let [method (:request-method request)]
;    (cond
;      (= method :get)
;      (do
;        (render-file "templates/note/create-form.html" {}))
;      (= method :post)
;      (do
;        (let [uuid (tool/make-uuid)
;              content ((request :params) :content)]
;          (if (note-provider/create uuid content)
;            (redirect (str "/note/read/" uuid))
;            (redirect "/error")))))))

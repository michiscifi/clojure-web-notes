(ns notebook.data.provider.note
  (:refer-clojure
    :exclude [read update]))

; todo: use config for this
(def datasource '[notebook.data.source.note.mysql :as datasource])

(require datasource)

(defn search [term]
  (datasource/search term))

(defn create [uuid content]
  (datasource/create uuid content))

(defn read [uuid]
  (datasource/read uuid))

(defn update [uuid content]
  (datasource/update uuid content))


(defn delete [uuid]
  (datasource/delete uuid))
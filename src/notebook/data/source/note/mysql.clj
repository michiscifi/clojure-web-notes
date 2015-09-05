(ns notebook.data.source.note.mysql
  (:refer-clojure
    :exclude [read update])
  (:require [yesql.core :refer [defquery]]
            [environ.core :refer [env]]))

(def db-spec {:classname   (env :database-classname)
              :subprotocol (env :database-subprotocol)
              :subname     (env :database-subname)
              :user        (env :database-user)
              :password    (env :database-password)})

(defquery search-query "query/note/search.sql")
(defquery create-query! "query/note/create.sql")
(defquery read-query "query/note/read.sql")
(defquery update-query! "query/note/update.sql")
(defquery delete-query! "query/note/delete.sql")

(defn search [term]
  (search-query db-spec term))

(defn create [uuid content]
  (create-query! db-spec uuid content))

(defn read [uuid]
  (first (read-query db-spec uuid)))

(defn update [uuid content]
  (update-query! db-spec content uuid))

(defn delete [uuid]
  (delete-query! db-spec uuid))
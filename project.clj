(defproject notebook "0.1.0-SNAPSHOT"
  :description "Investigation of clojure web application programming"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [environ "1.0.0"]
                 [ring "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-logger "0.7.0"]
                 [compojure "1.4.0"]
                 [selmer "0.8.6"]
                 [yesql "0.4.2"]
                 [org.clojure/java.jdbc "0.3.7"]
                 ;[org.xerial/sqlite-jdbc "3.8.11.1"]
                 [mysql/mysql-connector-java "5.1.6"]]
  :main ^:skip-aot notebook.core
  :target-path "target/%s"
  :plugins [[lein-environ "1.0.0"]
            [lein-ring "0.9.6"]]
  :ring {:handler notebook.app/app
         :nrepl   {:start? true
                   :port   9998}}
  :profiles {:uberjar {:aot :all}}
  :profiles/dev {}
  :profiles/test {})

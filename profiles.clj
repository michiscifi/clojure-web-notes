{:dev  {
        :env {
              :umgebung             "development"
              :database-url         "jdbc:postgres://localhost/dev"
              :database-classname   "com.mysql.jdbc.Driver"
              :database-subprotocol "mysql"
              :database-subname     "//localhost:3306/notebook_development"
              :database-user        "root"
              :database-password    ""
              }}
 :test {
        :env {
              :umgebung             "test"
              :database-url         "jdbc:postgres://localhost/test"
              :database-classname   "com.mysql.jdbc.Driver"
              :database-subprotocol "mysql"
              :database-subname     "//localhost:3306/notebook_development"
              :database-user        "root"
              :database-password    ""
              }}
 }
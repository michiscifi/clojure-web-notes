#!/usr/bin/env bash
java  \
    -Ddatabase-classname=com.mysql.jdbc.Driver  \
    -Ddatabase-subprotocol=mysql \
    -Ddatabase-subname=//localhost:3306/notebook_development \
    -Ddatabase-user=root \
    -Ddatabase-password= \
    -jar  target/uberjar/notes-0.1.0-SNAPSHOT-standalone.jar
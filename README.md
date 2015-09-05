# notebook

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar notebook-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Development process

```
lein ring server

lein ring server-headless

# for remote debugging

JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005" lein ring server-headless


```

## Build for production

```
lein uberjar
```

### run for production

Create this shell script ``` run_app.sh ```

```
#!/bin/sh
java  \
    -Ddatabase-classname=com.mysql.jdbc.Driver  \
    -Ddatabase-subprotocol=mysql \
    -Ddatabase-subname=//localhost:3306/notebook_prodution \
    -Ddatabase-user=the-user \
    -Ddatabase-password=the-password \
    -jar  target/uberjar/notebook-0.1.0-SNAPSHOT-standalone.jar
```


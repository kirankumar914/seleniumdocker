FROM openjdk:8u92-jre-alpine

RUN apk --no-cache add curl jq

# Creating workspace 
WORKDIR /usr/share/udemy

# adding selenium jar files to image.
ADD target/selenium-docker.jar          selenium-docker.jar

# adding selenium test jar files to image.
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar 

# adding supported jars
ADD target/libs                         libs

# add any other dependices like CSV,JSON anything
# adding test suite files to image
ADD search-Module.xml                   search-Module.xml
ADD book-flight-module.xml              seleniumdocker.xml

# add healtch check file into this
ADD healthcheck.sh                      healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE

ENTRYPOINT sh healthcheck.sh
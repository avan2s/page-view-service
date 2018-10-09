FROM openjdk

EXPOSE 8081

VOLUME /tmp
ADD maven/${dockerFileName} ${dockerFileName}
RUN sh -c 'touch /${dockerFileName}'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/${dockerFileName}"]
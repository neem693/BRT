FROM tomcat:8.5
EXPOSE 8080
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
copy setenv.sh /usr/local/tomcat/bin/setenv.sh
RUN rm -Rf /usr/local/tomcat/webapps/ROOT
copy the-comment.war /usr/local/tomcat/webapps/ROOT.war
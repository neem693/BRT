FROM httpd:2.4
RUN ln -sf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
COPY httpd.conf /usr/local/apache2/conf/httpd.conf
COPY htdocs /usr/local/apache2/htdocs
COPY .htaccess /usr/local/apache2/htdocs/.htaccess
<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1573689650585" ID="ID_1368327091" MODIFIED="1573689812084" TEXT="APACHE">
<node CREATED="1573689801864" ID="ID_160058529" MODIFIED="1573689806305" POSITION="right" TEXT="apache ssl">
<node CREATED="1573689806744" ID="ID_443614598" LINK="https://www.digicert.com/csr-ssl-installation/apache-openssl.htm" MODIFIED="1573689806744" TEXT="https://www.digicert.com/csr-ssl-installation/apache-openssl.htm"/>
</node>
<node CREATED="1573700104207" ID="ID_727107818" MODIFIED="1573700107543" POSITION="right" TEXT="openssl &#xb9cc;&#xb4e4;&#xae30;">
<node CREATED="1573700107872" ID="ID_911287260" MODIFIED="1573700107872" TEXT="openssl req -new -newkey rsa:2048 -nodes -out D:\key\oratree.csr -keyout D:\key\oratree.key -subj &quot;/C=KR/ST=mapo/L=seoul/O=BM_Cunsulting/OU=developer/CN=www.example.com&quot;"/>
<node CREATED="1573700107874" MODIFIED="1573700107874" TEXT="openssl x509 -req -in D:\key\oratree.csr -signkey D:\key\oratree.key -out D:\key\oratree.crt"/>
</node>
<node CREATED="1573700118701" ID="ID_1802056153" MODIFIED="1573700122259" POSITION="right" TEXT="conf &#xc124;&#xc815;">
<node CREATED="1573700122527" MODIFIED="1573700122527" TEXT="Listen 80"/>
<node CREATED="1573700122527" MODIFIED="1573700122527" TEXT="Listen 443"/>
<node CREATED="1573700122528" MODIFIED="1573700122528" TEXT="&lt;VirtualHost 127.0.0.1:443&gt;">
<node CREATED="1573700122528" MODIFIED="1573700122528" TEXT="DocumentRoot &quot;D:/tuto/workspace&quot;"/>
<node CREATED="1573700122529" MODIFIED="1573700122529" TEXT="ServerName www.example.com"/>
<node CREATED="1573700122529" MODIFIED="1573700122529" TEXT="SSLEngine on"/>
<node CREATED="1573700122530" MODIFIED="1573700122530" TEXT="SSLCertificateFile &quot;D:/key/oratree.crt&quot;"/>
<node CREATED="1573700122530" MODIFIED="1573700122530" TEXT="SSLCertificateKeyFile &quot;D:/key/oratree.key&quot;"/>
</node>
<node CREATED="1573700122530" MODIFIED="1573700122530" TEXT="#        SSLCertificateChainFile &quot;D:/key/oratree.crt&quot;"/>
<node CREATED="1573700122531" MODIFIED="1573700122531" TEXT="&lt;/VirtualHost&gt;"/>
</node>
</node>
</map>

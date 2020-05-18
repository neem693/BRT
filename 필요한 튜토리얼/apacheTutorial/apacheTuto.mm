<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1573689650585" ID="ID_1368327091" MODIFIED="1573689812084" TEXT="APACHE">
<node CREATED="1573689801864" ID="ID_160058529" MODIFIED="1573689806305" POSITION="right" TEXT="apache ssl">
<node CREATED="1573689806744" ID="ID_443614598" LINK="https://www.digicert.com/csr-ssl-installation/apache-openssl.htm" MODIFIED="1573689806744" TEXT="https://www.digicert.com/csr-ssl-installation/apache-openssl.htm"/>
<node CREATED="1586920041676" ID="ID_908173942" MODIFIED="1586920046884" TEXT="&#xc18d;&#xc131;&#xc774;&#xb984;">
<node CREATED="1586923990979" ID="ID_1424204733" MODIFIED="1586923990979" TEXT="Country Name : &#xc774;&#xac83;&#xc740; &#xb450; &#xc790;&#xb85c; &#xb41c; ISO &#xd615;&#xc2dd;&#xc758; &#xad6d;&#xac00; &#xcf54;&#xb4dc;&#xc785;&#xb2c8;&#xb2e4;."/>
<node CREATED="1586923990979" ID="ID_1088782345" MODIFIED="1586923990979" TEXT="State or Province Name : &#xc2dc; &#xc774;&#xb984;&#xc744; &#xc785;&#xb825;&#xd574;&#xc57c; &#xd558;&#xba70; &#xc57d;&#xc5b4;&#xb97c; &#xc0ac;&#xc6a9;&#xd560; &#xc218; &#xc5c6;&#xc2b5;&#xb2c8;&#xb2e4;."/>
<node CREATED="1586923990979" ID="ID_218160617" MODIFIED="1586923990979" TEXT="Locality Name : &#xc774; &#xd544;&#xb4dc;&#xb294; &#xb300;&#xbd80;&#xbd84;&#xc758; &#xacbd;&#xc6b0; &#xc0dd;&#xb7b5;&#xc774; &#xac00;&#xb2a5;&#xd558;&#xba70; &#xc5c5;&#xccb4;&#xac00; &#xc704;&#xce58;&#xd55c; &#xacf3;&#xb97c; &#xb098;&#xd0c0;&#xb0c5;&#xb2c8;&#xb2e4;."/>
<node CREATED="1586923990979" ID="ID_567285092" MODIFIED="1586923990979" TEXT="Organization : &#xc0ac;&#xc5c5;&#xc790; &#xb4f1;&#xb85d;&#xc99d;&#xc5d0; &#xc788;&#xb294; &#xd68c;&#xc0ac;&#xba85;&#xacfc; &#xc77c;&#xce58;&#xb418;&#xb294; &#xc601;&#xbb38;&#xd68c;&#xc0ac;&#xba85;&#xc744; &#xc785;&#xb825;&#xd558;&#xc2dc;&#xba74; &#xb429;&#xb2c8;&#xb2e4;."/>
<node CREATED="1586923990979" ID="ID_192310126" MODIFIED="1586923990979" TEXT="Organization Unit : &quot;&#xb9ac;&#xb205;&#xc2a4; &#xad00;&#xb9ac;&#xd300;&quot;, &quot;&#xc708;&#xb3c4;&#xc6b0; &#xad00;&#xb9ac;&#xd300;&quot; &#xb4f1;&#xacfc; &#xac19;&#xc774; &#xc5c5;&#xccb4;&#xc758; &#xbd80;&#xc11c;&#xb97c; &#xc785;&#xb825;&#xd560; &#xc218; &#xc788;&#xc2b5;&#xb2c8;&#xb2e4;."/>
<node CREATED="1586923990979" ID="ID_311790403" MODIFIED="1586923990979" TEXT="Common Name : &#xc778;&#xc99d;&#xbc1b;&#xc744; &#xb3c4;&#xba54;&#xc778;&#xc8fc;&#xc18c;&#xb97c; &#xc785;&#xb825;&#xd558;&#xc2dc;&#xba74; &#xb429;&#xb2c8;&#xb2e4;."/>
</node>
<node CREATED="1586926304211" ID="ID_894088365" MODIFIED="1586926766295" TEXT="&#xc708;&#xb3c4;&#xc6b0; ssl &#xb2e4;&#xc6b4;&#xb85c;&#xb4dc;">
<node CREATED="1586926761837" ID="ID_367105079" LINK="https://slproweb.com/products/Win32OpenSSL.html" MODIFIED="1586926761837" TEXT="https://slproweb.com/products/Win32OpenSSL.html"/>
</node>
<node CREATED="1586926201387" ID="ID_1244582567" MODIFIED="1586926770553" TEXT="&#xc0ac;&#xc6a9;&#xbc95;">
<node CREATED="1586926206099" ID="ID_1939430547" LINK="https://blog.didierstevens.com/2015/03/30/howto-make-your-own-cert-with-openssl-on-windows/" MODIFIED="1586926206099" TEXT="https://blog.didierstevens.com/2015/03/30/howto-make-your-own-cert-with-openssl-on-windows/"/>
</node>
</node>
<node CREATED="1573700104207" ID="ID_727107818" MODIFIED="1573700107543" POSITION="right" TEXT="openssl &#xb9cc;&#xb4e4;&#xae30;">
<node CREATED="1573700107872" ID="ID_911287260" MODIFIED="1573700107872" TEXT="openssl req -new -newkey rsa:2048 -nodes -out D:\key\oratree.csr -keyout D:\key\oratree.key -subj &quot;/C=KR/ST=mapo/L=seoul/O=BM_Cunsulting/OU=developer/CN=www.example.com&quot;"/>
<node CREATED="1573700107874" ID="ID_1510040510" MODIFIED="1573700107874" TEXT="openssl x509 -req -in D:\key\oratree.csr -signkey D:\key\oratree.key -out D:\key\oratree.crt"/>
</node>
<node CREATED="1573700118701" ID="ID_1802056153" MODIFIED="1573700122259" POSITION="right" TEXT="conf &#xc124;&#xc815;">
<node CREATED="1573700122527" ID="ID_1599890253" MODIFIED="1573700122527" TEXT="Listen 80"/>
<node CREATED="1573700122527" ID="ID_465854624" MODIFIED="1573700122527" TEXT="Listen 443"/>
<node CREATED="1573700122528" ID="ID_1447262079" MODIFIED="1573700122528" TEXT="&lt;VirtualHost 127.0.0.1:443&gt;">
<node CREATED="1573700122528" MODIFIED="1573700122528" TEXT="DocumentRoot &quot;D:/tuto/workspace&quot;"/>
<node CREATED="1573700122529" ID="ID_185169375" MODIFIED="1573700122529" TEXT="ServerName www.example.com"/>
<node CREATED="1573700122529" MODIFIED="1573700122529" TEXT="SSLEngine on"/>
<node CREATED="1573700122530" MODIFIED="1573700122530" TEXT="SSLCertificateFile &quot;D:/key/oratree.crt&quot;"/>
<node CREATED="1573700122530" MODIFIED="1573700122530" TEXT="SSLCertificateKeyFile &quot;D:/key/oratree.key&quot;"/>
</node>
<node CREATED="1573700122530" ID="ID_234365876" MODIFIED="1573700122530" TEXT="#        SSLCertificateChainFile &quot;D:/key/oratree.crt&quot;"/>
<node CREATED="1573700122531" ID="ID_123806031" MODIFIED="1573700122531" TEXT="&lt;/VirtualHost&gt;"/>
</node>
<node CREATED="1582781585350" ID="ID_1218941641" MODIFIED="1582781588146" POSITION="right" TEXT="rewrite">
<node CREATED="1582781588630" ID="ID_964033550" MODIFIED="1582782956563" TEXT=" &#xc815;&#xaddc;&#xd45c;&#xd604;&#xc2dd; is not function">
<node CREATED="1582781600069" ID="ID_1159894405" LINK="https://www.regextester.com/15" MODIFIED="1582781600069" TEXT="https://www.regextester.com/15"/>
</node>
</node>
</node>
</map>

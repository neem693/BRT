<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1573689650585" ID="ID_1368327091" MODIFIED="1573689812084" TEXT="APACHE">
<node CREATED="1573689801864" FOLDED="true" ID="ID_160058529" MODIFIED="1604811053401" POSITION="right" TEXT="apache ssl">
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
<node CREATED="1573700104207" FOLDED="true" ID="ID_727107818" MODIFIED="1604811055113" POSITION="right" TEXT="openssl &#xb9cc;&#xb4e4;&#xae30;">
<node CREATED="1573700107872" ID="ID_911287260" MODIFIED="1573700107872" TEXT="openssl req -new -newkey rsa:2048 -nodes -out D:\key\oratree.csr -keyout D:\key\oratree.key -subj &quot;/C=KR/ST=mapo/L=seoul/O=BM_Cunsulting/OU=developer/CN=www.example.com&quot;"/>
<node CREATED="1573700107874" ID="ID_1510040510" MODIFIED="1573700107874" TEXT="openssl x509 -req -in D:\key\oratree.csr -signkey D:\key\oratree.key -out D:\key\oratree.crt"/>
</node>
<node CREATED="1573700118701" FOLDED="true" ID="ID_1802056153" MODIFIED="1604811050306" POSITION="right" TEXT="conf &#xc124;&#xc815;">
<node CREATED="1573700122527" ID="ID_1599890253" MODIFIED="1573700122527" TEXT="Listen 80"/>
<node CREATED="1573700122527" ID="ID_465854624" MODIFIED="1573700122527" TEXT="Listen 443"/>
<node CREATED="1604558986774" ID="ID_1384704392" MODIFIED="1604559010559" TEXT="LoadModule ssl_module modules/mod_ssl.so">
<node CREATED="1604559012559" ID="ID_546332548" MODIFIED="1604559020992" TEXT="&#xc774;&#xac70; &#xc55e; # &#xc788;&#xc73c;&#xba74; &#xd574;&#xc81c;&#xd558;&#xae30;"/>
</node>
<node CREATED="1573700122528" ID="ID_1447262079" MODIFIED="1573700122528" TEXT="&lt;VirtualHost 127.0.0.1:443&gt;">
<node CREATED="1573700122528" ID="ID_1589010257" MODIFIED="1573700122528" TEXT="DocumentRoot &quot;D:/tuto/workspace&quot;"/>
<node CREATED="1573700122529" ID="ID_185169375" MODIFIED="1573700122529" TEXT="ServerName www.example.com"/>
<node CREATED="1573700122529" ID="ID_1551357171" MODIFIED="1573700122529" TEXT="SSLEngine on"/>
<node CREATED="1573700122530" ID="ID_125963362" MODIFIED="1573700122530" TEXT="SSLCertificateFile &quot;D:/key/oratree.crt&quot;"/>
<node CREATED="1573700122530" ID="ID_624747993" MODIFIED="1573700122530" TEXT="SSLCertificateKeyFile &quot;D:/key/oratree.key&quot;"/>
</node>
<node CREATED="1573700122530" ID="ID_234365876" MODIFIED="1604561661850" TEXT="update"/>
<node CREATED="1573700122531" ID="ID_123806031" MODIFIED="1573700122531" TEXT="&lt;/VirtualHost&gt;"/>
<node COLOR="#3333ff" CREATED="1604560465924" ID="ID_955843670" MODIFIED="1604560478165" STYLE="bubble" TEXT="&#xd504;&#xb85d;&#xc2dc;&#xb97c; &#xc0ac;&#xc6a9;&#xd560; &#xacbd;&#xc6b0; SSLProxyEngine&#xc744; &#xcf1c;&#xc57c; &#xd55c;&#xb2e4;.">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1604559637813" ID="ID_1132566" MODIFIED="1604559640294" TEXT="&#xc608;)">
<node CREATED="1604559672166" ID="ID_1791688997" MODIFIED="1604559673290" TEXT="&#xc774;&#xbbf8;&#xc9c0;">
<node CREATED="1604559673814" ID="ID_95728531" MODIFIED="1604559673814">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="apacheTuto_5735461485881403793.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
</node>
</node>
<node CREATED="1582781585350" FOLDED="true" ID="ID_1218941641" MODIFIED="1604811050306" POSITION="right" TEXT="rewrite">
<node CREATED="1582781588630" ID="ID_964033550" MODIFIED="1582782956563" TEXT=" &#xc815;&#xaddc;&#xd45c;&#xd604;&#xc2dd; is not function">
<node CREATED="1582781600069" ID="ID_1159894405" LINK="https://www.regextester.com/15" MODIFIED="1582781600069" TEXT="https://www.regextester.com/15"/>
</node>
</node>
<node CREATED="1580375808773" FOLDED="true" ID="ID_1191707198" MODIFIED="1604811050307" POSITION="right" TEXT="&#xd504;&#xb85d;&#xc2dc;">
<node CREATED="1580327978932" ID="ID_1317658100" MODIFIED="1604559594942" TEXT="rewrite">
<node CREATED="1580327981984" ID="ID_1450635901" MODIFIED="1580327984475" TEXT="p &#xd50c;&#xb798;&#xadf8;">
<node CREATED="1580327988200" ID="ID_283345267" MODIFIED="1580327990693" TEXT="&#xd504;&#xb85d;&#xc2dc;&#xb97c; &#xc758;&#xbbf8;&#xd55c;&#xb2e4;."/>
</node>
</node>
<node CREATED="1580376412189" ID="ID_586530580" MODIFIED="1580376414430" TEXT="&#xd3ec;&#xc6cc;&#xb4dc; &#xd504;&#xb85d;&#xc2dc;">
<node CREATED="1580377475495" ID="ID_1840490077" MODIFIED="1580377477852" TEXT="&#xc0ac;&#xc6a9;&#xd574;&#xbcf4;&#xc9c0; &#xc54a;&#xc558;&#xb2e4;."/>
</node>
<node CREATED="1580376414646" ID="ID_684551375" MODIFIED="1580377439446" TEXT="&#xb9ac;&#xbc84;&#xc2a4; &#xd504;&#xb85d;&#xc2dc;">
<node CREATED="1580377439438" ID="ID_1882481367" MODIFIED="1580377442575" TEXT="&#xc900;&#xbe44;">
<node COLOR="#3333ff" CREATED="1580377413402" ID="ID_496141612" MODIFIED="1580377423785" STYLE="bubble" TEXT="&#xc0ac;&#xc6a9;&#xd558;&#xb824;&#xba74; &#xb2e4;&#xc74c;&#xc758; &#xbaa8;&#xb4c8;&#xc744; &#xc784;&#xd3ec;&#xd2b8; &#xd574;&#xc57c; &#xd55c;&#xb2e4;.">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1580377424526" ID="ID_183113715" MODIFIED="1580377424526" TEXT="LoadModule proxy_module modules/mod_proxy.so"/>
<node CREATED="1580377424527" MODIFIED="1580377424527" TEXT="LoadModule proxy_http_module modules/mod_proxy_http.so"/>
</node>
</node>
<node CREATED="1580377444083" ID="ID_769758992" MODIFIED="1580377446925" TEXT="&#xc124;&#xba85;">
<node CREATED="1580376421020" ID="ID_711957308" MODIFIED="1580376431361" TEXT="&#xbcf4;&#xd1b5; &#xc6f9;&#xc11c;&#xbc84;&#xc5d0;&#xc11c; &#xbc31;&#xc5d4;&#xb4dc;&#xb85c; &#xb370;&#xc774;&#xd130; &#xbc1b;&#xc544;&#xc62c; &#xb584; &#xc4f0;&#xb294; &#xd504;&#xb85d;&#xc2dc;&#xb85c;"/>
<node CREATED="1580376431545" ID="ID_1116511539" MODIFIED="1580376437418" TEXT="angualr&#xc5d0;&#xc11c; &#xc0ac;&#xc6a9;&#xd558;&#xb294; &#xd504;&#xb85d;&#xc2dc;&#xc640; &#xac19;&#xc74c;"/>
<node CREATED="1580377130513" ID="ID_412779176" MODIFIED="1580377462796" TEXT="&#xc774;&#xc5d0; &#xb300;&#xd55c; &#xae30;&#xbcf8;&#xc801;&#xc778; &#xbb38;&#xc11c;&#xb294; &#xb2e4;&#xc74c;&#xc744; &#xcc38;&#xace0;">
<node CREATED="1580377138229" LINK="http://httpd.apache.org/docs/2.2/mod/mod_proxy.html#proxypass" MODIFIED="1580377138229" TEXT="httpd.apache.org &gt; Docs &gt; 2.2 &gt; Mod &gt; Mod proxy"/>
</node>
</node>
<node CREATED="1580376438478" ID="ID_1159274875" LINK="https://stackoverflow.com/questions/12808506/can-proxypass-and-proxypassreverse-work-in-htaccess" MODIFIED="1580376438478" TEXT="https://stackoverflow.com/questions/12808506/can-proxypass-and-proxypassreverse-work-in-htaccess"/>
<node CREATED="1580376441283" ID="ID_1064975216" MODIFIED="1580376447249" TEXT="rewrite&#xb85c; &#xc9c0;&#xc815;&#xc744; &#xd574;&#xc900; &#xd6c4;"/>
<node CREATED="1580376450387" ID="ID_505108014" MODIFIED="1580376907573" TEXT="&#xb9ac;&#xbc84;&#xc2a4; &#xd504;&#xb85d;&#xc2dc;&#xb97c; &#xc9c0;&#xc815;&#xd574;&#xc8fc;&#xba74; &#xb41c;&#xb2e4;."/>
<node CREATED="1580376922129" ID="ID_463180750" MODIFIED="1580377097069">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <pre><code>&lt;VirtualHost *:80&gt;
RewriteEngine On
RewriteRule ^/?img/(.*)$ http://internal.example.com/img/$1 [L,P]
RewriteRule ^/?app/(.*)$ http://internal.example.com/app/$1 [L,P]

ProxyPassReverse / http://internal.example.com/</code></pre>
    <p>
      &lt;/VirtualHost&gt;
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1580376933506" ID="ID_1809053218" MODIFIED="1580376968740" TEXT="&#xb2e8;, .htaccess&#xc5d0;&#xc11c; &#xc0ac;&#xc6a9;&#xd558;&#xba74; &#xc548;&#xb418;&#xace0;, virtualhost &#xc548;&#xc5d0; &#xb123;&#xb294;&#xb2e4;."/>
</node>
</node>
</node>
</map>

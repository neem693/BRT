<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1580281037925" ID="ID_1679178764" MODIFIED="1580281116107" TEXT="apache">
<node CREATED="1580281118394" ID="ID_566475951" MODIFIED="1580281121496" POSITION="right" TEXT="&#xc7ac;&#xc2dc;&#xc791;"/>
<node CREATED="1580327978932" ID="ID_1317658100" MODIFIED="1580327981118" POSITION="right" TEXT="rewrite">
<node CREATED="1580327981984" ID="ID_1450635901" MODIFIED="1580327984475" TEXT="p &#xd50c;&#xb798;&#xadf8;">
<node CREATED="1580327988200" ID="ID_283345267" MODIFIED="1580327990693" TEXT="&#xd504;&#xb85d;&#xc2dc;&#xb97c; &#xc758;&#xbbf8;&#xd55c;&#xb2e4;."/>
</node>
</node>
<node CREATED="1580375808773" ID="ID_1191707198" MODIFIED="1580375810579" POSITION="right" TEXT="&#xd504;&#xb85d;&#xc2dc;">
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
</html>
</richcontent>
</node>
<node CREATED="1580376933506" ID="ID_1809053218" MODIFIED="1580376968740" TEXT="&#xb2e8;, .htaccess&#xc5d0;&#xc11c; &#xc0ac;&#xc6a9;&#xd558;&#xba74; &#xc548;&#xb418;&#xace0;, virtualhost &#xc548;&#xc5d0; &#xb123;&#xb294;&#xb2e4;."/>
</node>
</node>
</node>
</map>

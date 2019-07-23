<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1563506704097" ID="ID_1368787532" MODIFIED="1563506746549" TEXT="webpack">
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1563506921971" FOLDED="true" ID="ID_243728185" MODIFIED="1563508610806" POSITION="right" STYLE="bubble" TEXT="&#xd574;&#xb2f9; &#xd29c;&#xd1a0;&#xb9ac;&#xc5bc;&#xc740; &#xc5ec;&#xae30;&#xc5d0; &#xc788;&#xc73c;&#xba70; &#xc9c4;&#xd589;&#xd558;&#xba74;&#xb41c;&#xb2e4;.">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node CREATED="1563506926113" ID="ID_1097539556" LINK="https://webpack.js.org/guides/getting-started/" MODIFIED="1563508109429" TEXT="https://webpack.js.org/guides/getting-started/"/>
<node CREATED="1563506775475" ID="ID_1439468985" MODIFIED="1563508606747" TEXT="webpack-demo &#xd3f4;&#xb354;&#xb97c; &#xb9cc;&#xb4e4;&#xace0; npm&#xc73c;&#xb85c; webpck&#xacfc; &#xad00;&#xb828;&#xb41c; &#xb450;&#xac1c; &#xc124;&#xce58;">
<node CREATED="1563506840873" MODIFIED="1563506840873" TEXT="mkdir webpack-demo"/>
<node CREATED="1563506840876" MODIFIED="1563506840876" TEXT="cd webpack-demo"/>
<node CREATED="1563506840877" ID="ID_376455504" MODIFIED="1563506840877" TEXT="npm init -y"/>
<node COLOR="#3333ff" CREATED="1563506840880" ID="ID_251016012" MODIFIED="1563506842183" STYLE="bubble" TEXT="npm install webpack --save-dev">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563506840882" ID="ID_1736000834" MODIFIED="1563506842324" STYLE="bubble" TEXT="npm install webpack-cli --save-dev">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563506947355" ID="ID_1056330650" MODIFIED="1563506997639" TEXT="&#xc6f9;&#xd399;&#xc740; &#xae30;&#xbcf8;&#xc801;&#xc73c;&#xb85c; &#xacbd;&#xb85c; &#xad00;&#xb9ac;&#xb77c;&#xace0; &#xbcf4;&#xba74; &#xb420;&#xb4ef; &#xd558;&#xb2e4;. &#xacbd;&#xb85c;&#xc5d0; &#xd574;&#xb2f9;&#xd558;&#xb294; &#xb77c;&#xc774;&#xbe0c;&#xb7ec;&#xb9ac;&#xac00; &#xc5c6;&#xc744; &#xb54c; &#xadf8;&#xac83;&#xc744; &#xc790;&#xb3d9;&#xc73c;&#xb85c; &#xad00;&#xb9ac;&#xd574;&#xc8fc;&#xb294; &#xac83;&#xc774;&#xb2e4;."/>
<node COLOR="#3333ff" CREATED="1563507008114" ID="ID_1213677783" MODIFIED="1563507020498" STYLE="bubble" TEXT="npm&#xc5d0; &#xae30;&#xbcf8;&#xc801;&#xc73c;&#xb85c; &#xc0ac;&#xc6a9;&#xd558;&#xb294; npx&#xb77c;&#xace0; &#xd574;&#xc11c; &#xd328;&#xd0a4;&#xc9c0;&#xb97c; &#xc2e4;&#xd589;&#xd558;&#xb294;&#xac8c; &#xc788;&#xb2e4;.">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563507036866" ID="ID_178193150" MODIFIED="1563507045291" STYLE="bubble" TEXT="&#xb530;&#xb77c;&#xc11c; &#xc774;&#xb7f0;&#xc2dd;&#xc73c;&#xb85c; webpack&#xc744; &#xc2e4;&#xd589;&#xd55c;&#xb2e4;.">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563507044519" ID="ID_293322250" MODIFIED="1563507045285" STYLE="bubble" TEXT="npx webpack">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563507281513" ID="ID_1892402990" MODIFIED="1563507299715" STYLE="bubble" TEXT="&#xd558;&#xc9c0;&#xb9cc; &#xc774;&#xb807;&#xac8c; &#xc8fc;&#xba39;&#xad6c;&#xad6c;&#xc2dd;&#xc73c;&#xb85c; &#xd558;&#xc9c0;&#xb294; &#xc54a;&#xace0;, &#xbcf4;&#xd1b5; webpack.config.js&#xb97c; &#xc815;&#xc758;&#xd574;&#xc8fc;&#xb294; &#xd3b8;&#xc774;&#xb2e4;.">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1563507308192" MODIFIED="1563507308192" TEXT="const path = require(&apos;path&apos;);"/>
<node CREATED="1563507308194" MODIFIED="1563507308194" TEXT="module.exports = {">
<node CREATED="1563507308195" MODIFIED="1563507308195" TEXT="entry: &apos;./src/index.js&apos;,"/>
<node CREATED="1563507308196" MODIFIED="1563507308196" TEXT="output:{">
<node CREATED="1563507308196" MODIFIED="1563507308196" TEXT="filename: &apos;main.js&apos;,"/>
<node CREATED="1563507308197" MODIFIED="1563507308197" TEXT="path: path.resolve(__dirname,&apos;dist&apos;)"/>
</node>
<node CREATED="1563507308198" MODIFIED="1563507308198" TEXT="}"/>
</node>
<node CREATED="1563507308199" MODIFIED="1563507308199" TEXT="};"/>
</node>
<node CREATED="1563507350753" ID="ID_282533702" MODIFIED="1563507355822" TEXT="&#xadf8;&#xb7ec;&#xba74; &#xc774;&#xb807;&#xac8c; &#xc2e4;&#xd589; &#xac00;&#xb2a5;&#xd558;&#xb2e4;.">
<node COLOR="#3333ff" CREATED="1563507356610" ID="ID_1318946402" MODIFIED="1563507357929" STYLE="bubble" TEXT="npx webpack --config webpack.config.js">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563507081154" ID="ID_1997767194" MODIFIED="1563507092847" TEXT="&#xd558;&#xc9c0;&#xb9cc; packge json&#xc5d0; build&#xc5d0; webpack&#xc744; &#xcd94;&#xac00;&#xd574;&#xc8fc;&#xba74;">
<node CREATED="1563507100905" ID="ID_880760374" MODIFIED="1563507100905" TEXT="{">
<node CREATED="1563507100907" MODIFIED="1563507100907" TEXT="&quot;name&quot;: &quot;webpack-demo&quot;,"/>
<node CREATED="1563507100910" MODIFIED="1563507100910" TEXT="&quot;version&quot;: &quot;1.0.0&quot;,"/>
<node CREATED="1563507100912" MODIFIED="1563507100912" TEXT="&quot;description&quot;: &quot;how to use webpack&quot;,"/>
<node CREATED="1563507100914" MODIFIED="1563507100914" TEXT="&quot;private&quot;: true,"/>
<node CREATED="1563507100915" MODIFIED="1563507100915" TEXT="&quot;main&quot;: &quot;&quot;,"/>
<node CREATED="1563507100917" ID="ID_1363867786" MODIFIED="1563507100917" TEXT="&quot;scripts&quot;: {">
<node CREATED="1563507100919" MODIFIED="1563507100919" TEXT="&quot;test&quot;: &quot;echo \&quot;Error: no test specified\&quot; &amp;&amp; exit 1&quot;,"/>
<node COLOR="#3333ff" CREATED="1563507100921" ID="ID_529297677" MODIFIED="1563507102706" STYLE="bubble" TEXT="&quot;build&quot;:&quot;webpack&quot;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563507100922" ID="ID_958972094" MODIFIED="1563507100922" TEXT="},"/>
<node CREATED="1563507100924" MODIFIED="1563507100924" TEXT="&quot;author&quot;: &quot;oratree2&quot;,"/>
<node CREATED="1563507100926" MODIFIED="1563507100926" TEXT="&quot;license&quot;: &quot;MIT&quot;,"/>
<node CREATED="1563507100928" MODIFIED="1563507100928" TEXT="&quot;keywords&quot;: [],"/>
<node CREATED="1563507100930" MODIFIED="1563507100930" TEXT="&quot;devDependencies&quot;: {">
<node CREATED="1563507100932" MODIFIED="1563507100932" TEXT="&quot;webpack&quot;: &quot;^4.36.1&quot;,"/>
<node CREATED="1563507100936" MODIFIED="1563507100936" TEXT="&quot;webpack-cli&quot;: &quot;^3.3.6&quot;"/>
</node>
<node CREATED="1563507100937" MODIFIED="1563507100937" TEXT="},"/>
<node CREATED="1563507100938" MODIFIED="1563507100938" TEXT="&quot;dependencies&quot;: {">
<node CREATED="1563507100938" MODIFIED="1563507100938" TEXT="&quot;lodash&quot;: &quot;^4.17.14&quot;"/>
</node>
<node CREATED="1563507100939" MODIFIED="1563507100939" TEXT="}"/>
</node>
<node CREATED="1563507100940" MODIFIED="1563507100940" TEXT="}"/>
</node>
<node CREATED="1563507106291" FOLDED="true" ID="ID_1923468062" MODIFIED="1563507127990" TEXT="&#xb2e4;&#xc74c;&#xacfc; &#xac19;&#xc774; &#xc2e4;&#xd589;&#xac00;&#xb2a5;&#xd558;&#xb2e4;.">
<node COLOR="#3333ff" CREATED="1563507122345" ID="ID_382718651" MODIFIED="1563507127618" STYLE="bubble" TEXT="npm run build">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1563507059786" ID="ID_1967967712" MODIFIED="1563508624858" POSITION="right" STYLE="bubble" TEXT="&#xb450;&#xbc88;&#xc9f8; &#xd29c;&#xd1a0;&#xb9ac;&#xc5bc;&#xc740; asset &#xad00;&#xb9ac;&#xc774;&#xb2e4;.">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node CREATED="1563507073827" LINK="https://webpack.js.org/guides/asset-management/" MODIFIED="1563508110726" TEXT="https://webpack.js.org/guides/asset-management/"/>
<node CREATED="1563508624834" ID="ID_110331369" MODIFIED="1563512314142" TEXT="css loading">
<node COLOR="#3333ff" CREATED="1563508577282" FOLDED="true" ID="ID_1795280051" MODIFIED="1563512320509" STYLE="bubble" TEXT="&#xc124;&#xce58;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1563508579330" ID="ID_701436809" MODIFIED="1563508580740" TEXT="npm install --save-dev style-loader css-loader"/>
</node>
<node CREATED="1563508399138" FOLDED="true" ID="ID_1307509044" MODIFIED="1563512320510" TEXT="index.js">
<node COLOR="#3333ff" CREATED="1563508403248" ID="ID_494665487" MODIFIED="1563508477612" STYLE="bubble" TEXT="import _ from &apos;lodash&apos;;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563508403257" ID="ID_1451170494" MODIFIED="1563508473457" STYLE="bubble" TEXT="import &apos;./style.css&apos;;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563508403259" ID="ID_1160990082" MODIFIED="1563508403259" TEXT="function component() {">
<node CREATED="1563508403261" MODIFIED="1563508403261" TEXT="const element = document.createElement(&apos;div&apos;);"/>
<node CREATED="1563508403263" ID="ID_1299639303" MODIFIED="1563508403263" TEXT="// Lodash, currently included via a script, is required for this line to work"/>
<node COLOR="#3333ff" CREATED="1563508403265" ID="ID_939444009" MODIFIED="1563508479185" STYLE="bubble" TEXT="element.innerHTML = _.join([&apos;Hello&apos;, &apos;webpack&apos;], &apos; &apos;);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563508403267" ID="ID_888936572" MODIFIED="1563508475448" STYLE="bubble" TEXT="element.classList.add(&apos;hello&apos;);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563508403268" MODIFIED="1563508403268" TEXT="return element;"/>
<node CREATED="1563508403269" MODIFIED="1563508403269" TEXT="}"/>
<node CREATED="1563508403269" MODIFIED="1563508403269" TEXT="document.body.appendChild(component());"/>
</node>
</node>
<node CREATED="1563508412347" FOLDED="true" ID="ID_1875108273" MODIFIED="1563512320510" TEXT="webpack.config.js">
<node CREATED="1563508421622" MODIFIED="1563508421622" TEXT="const path = require(&apos;path&apos;);"/>
<node CREATED="1563508421625" ID="ID_1646463607" MODIFIED="1563508421625" TEXT="module.exports = {">
<node CREATED="1563508421626" ID="ID_141219805" MODIFIED="1563508421626" TEXT="entry: &apos;./src/index.js&apos;,"/>
<node CREATED="1563508421628" ID="ID_919809153" MODIFIED="1563508421628" TEXT="output:{">
<node CREATED="1563508421630" MODIFIED="1563508421630" TEXT="filename: &apos;bundle.js&apos;,"/>
<node CREATED="1563508421632" ID="ID_1277529093" MODIFIED="1563508498588" TEXT="path: path.resolve(__dirname,&apos;dist&apos;)">
<font NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node CREATED="1563508421634" ID="ID_1508194312" MODIFIED="1563508421634" TEXT="},"/>
<node COLOR="#3333ff" CREATED="1563508421636" ID="ID_480078184" MODIFIED="1563508501177" STYLE="bubble" TEXT="module:{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563508421637" ID="ID_766660203" MODIFIED="1563508436102" STYLE="bubble" TEXT="rules:[">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563508421639" ID="ID_793120420" MODIFIED="1563508436704" STYLE="bubble" TEXT="{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563508421642" ID="ID_1986697087" MODIFIED="1563508438232" STYLE="bubble" TEXT="test: /\.css$/,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563508421648" ID="ID_387224441" MODIFIED="1563508438472" STYLE="bubble" TEXT="use:[">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563508421649" ID="ID_1704306442" MODIFIED="1563508438857" STYLE="bubble" TEXT="&apos;style-loader&apos;,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563508421652" ID="ID_199306306" MODIFIED="1563508439112" STYLE="bubble" TEXT="&apos;css-loader&apos;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563508421654" MODIFIED="1563508436700" TEXT="]"/>
</node>
<node CREATED="1563508421654" MODIFIED="1563508436099" TEXT="}"/>
</node>
<node CREATED="1563508421655" MODIFIED="1563508435195" TEXT="]"/>
</node>
<node CREATED="1563508421656" MODIFIED="1563508421656" TEXT="}"/>
</node>
<node CREATED="1563508421656" MODIFIED="1563508421656" TEXT="};"/>
</node>
<node CREATED="1563508596514" FOLDED="true" ID="ID_839861273" MODIFIED="1563512320510" TEXT="&#xc2e4;&#xd589;">
<node CREATED="1563508599610" ID="ID_966218949" MODIFIED="1563508599610" TEXT="npm run build"/>
</node>
</node>
<node CREATED="1563511876506" ID="ID_535793158" MODIFIED="1563511881070" TEXT="Image loading">
<node CREATED="1563514186931" ID="ID_1387061385" MODIFIED="1563514188870" TEXT="&#xc124;&#xce58;">
<node CREATED="1563514195876" MODIFIED="1563514195876" TEXT="npm install --save-dev file-loader"/>
</node>
<node CREATED="1563512124420" FOLDED="true" ID="ID_769925218" MODIFIED="1563512180192" TEXT="webpack.config.js &#xcd94;&#xac00;">
<node CREATED="1563512129710" MODIFIED="1563512129710" TEXT="const path = require(&apos;path&apos;);"/>
<node CREATED="1563512129712" ID="ID_1233253571" MODIFIED="1563512129712" TEXT="module.exports = {">
<node CREATED="1563512129714" MODIFIED="1563512129714" TEXT="entry: &apos;./src/index.js&apos;,"/>
<node CREATED="1563512129715" MODIFIED="1563512129715" TEXT="output: {">
<node CREATED="1563512129716" MODIFIED="1563512129716" TEXT="filename: &apos;bundle.js&apos;,"/>
<node CREATED="1563512129717" MODIFIED="1563512129717" TEXT="path: path.resolve(__dirname, &apos;dist&apos;)"/>
</node>
<node CREATED="1563512129717" MODIFIED="1563512129717" TEXT="},"/>
<node CREATED="1563512129718" ID="ID_684918288" MODIFIED="1563512129718" TEXT="module: {">
<node CREATED="1563512129719" ID="ID_453510916" MODIFIED="1563512129719" TEXT="rules: [">
<node CREATED="1563512129720" MODIFIED="1563512129720" TEXT="{">
<node CREATED="1563512129721" MODIFIED="1563512129721" TEXT="test: /\.css$/,"/>
<node CREATED="1563512129722" MODIFIED="1563512129722" TEXT="use: [">
<node CREATED="1563512129722" MODIFIED="1563512129722" TEXT="&apos;style-loader&apos;,"/>
<node CREATED="1563512129723" MODIFIED="1563512129723" TEXT="&apos;css-loader&apos;"/>
</node>
<node CREATED="1563512129724" MODIFIED="1563512129724" TEXT="]"/>
</node>
<node CREATED="1563512129724" ID="ID_71762469" MODIFIED="1563512129724" TEXT="}"/>
<node COLOR="#3333ff" CREATED="1563512129725" ID="ID_457465998" MODIFIED="1563512140144" STYLE="bubble" TEXT=", {">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563512129726" ID="ID_404661484" MODIFIED="1563512140727" STYLE="bubble" TEXT="test: /\.(png|svg|jpg|gif)$/,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563512129731" ID="ID_79073303" MODIFIED="1563512140983" STYLE="bubble" TEXT="use: [">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563512129732" ID="ID_1425771432" MODIFIED="1563512141383" STYLE="bubble" TEXT="&apos;file-loader&apos;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563512129733" ID="ID_651018406" MODIFIED="1563512142056" STYLE="bubble" TEXT="]">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563512129734" ID="ID_373684903" MODIFIED="1563512129734" TEXT="}"/>
</node>
<node CREATED="1563512129735" ID="ID_1911120121" MODIFIED="1563512129735" TEXT="]"/>
</node>
<node CREATED="1563512129735" MODIFIED="1563512129735" TEXT="}"/>
</node>
<node CREATED="1563512129736" MODIFIED="1563512129736" TEXT="};"/>
</node>
<node CREATED="1563512255931" FOLDED="true" ID="ID_50651990" MODIFIED="1563512279621" TEXT="index js &#xcd94;&#xac00;">
<node CREATED="1563512260042" MODIFIED="1563512260042" TEXT="import _ from &apos;lodash&apos;;"/>
<node CREATED="1563512260045" MODIFIED="1563512260045" TEXT="import &apos;./style.css&apos;;"/>
<node COLOR="#3333ff" CREATED="1563512260047" ID="ID_1675386605" MODIFIED="1563512262487" STYLE="bubble" TEXT="import Icon from &apos;./recycle.png&apos;;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563512260048" FOLDED="true" ID="ID_1520449047" MODIFIED="1563512269069" TEXT="function component() {">
<node CREATED="1563512260050" MODIFIED="1563512260050" TEXT="const element = document.createElement(&apos;div&apos;);"/>
<node CREATED="1563512260052" MODIFIED="1563512260052" TEXT="// Lodash, currently included via a script, is required for this line to work"/>
<node CREATED="1563512260054" MODIFIED="1563512260054" TEXT="element.innerHTML = _.join([&apos;Hello&apos;, &apos;webpack&apos;], &apos; &apos;);"/>
<node CREATED="1563512260056" MODIFIED="1563512260056" TEXT="element.classList.add(&apos;hello&apos;);"/>
<node CREATED="1563512260057" ID="ID_1153279933" MODIFIED="1563512260057" TEXT="//add the image to our exisitng div."/>
<node CREATED="1563512260059" ID="ID_867252335" MODIFIED="1563512260059" TEXT="const myIcon = new Image();"/>
<node COLOR="#3333ff" CREATED="1563512260060" ID="ID_945542386" MODIFIED="1563512266887" STYLE="bubble" TEXT="myIcon.src = Icon;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563512260062" ID="ID_1423082910" MODIFIED="1563512267411" STYLE="bubble" TEXT="element.appendChild(myIcon);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563512260064" ID="ID_1415191254" MODIFIED="1563512267652" STYLE="bubble" TEXT="return element;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563512260065" MODIFIED="1563512260065" TEXT="}"/>
<node CREATED="1563512260066" MODIFIED="1563512260066" TEXT="document.body.appendChild(component());"/>
</node>
</node>
<node CREATED="1563512296866" ID="ID_702410782" MODIFIED="1563512309079" TEXT="&#xc774;&#xbbf8;&#xc9c0;&#xac00; &#xd574;&#xb2f9; &#xacbd;&#xb85c;&#xc5d0; &#xc788;&#xc5b4;&#xc57c;&#xd568; &#xadf8;&#xb807;&#xc9c0; &#xc54a;&#xc73c;&#xba74; &#xd2b8;&#xb79c;&#xc2a4;&#xd30c;&#xc77c;&#xb7ec; &#xc5d0;&#xb7ec; &#xb738;"/>
<node CREATED="1563508596514" FOLDED="true" ID="ID_1084957730" MODIFIED="1563512322061" TEXT="&#xc2e4;&#xd589;">
<node CREATED="1563508599610" ID="ID_854635013" MODIFIED="1563508599610" TEXT="npm run build"/>
</node>
</node>
<node CREATED="1563514178949" ID="ID_359651435" MODIFIED="1563514181767" TEXT="font Loading">
<node CREATED="1563512124420" FOLDED="true" ID="ID_523508865" MODIFIED="1563514260243" TEXT="webpack.config.js &#xcd94;&#xac00;">
<node CREATED="1563514210404" ID="ID_1289903294" MODIFIED="1563514215185" TEXT="const path = require(&apos;path&apos;);"/>
<node CREATED="1563514210406" FOLDED="true" ID="ID_1470054524" MODIFIED="1563514259675" TEXT="module.exports = {">
<node CREATED="1563514210408" ID="ID_1945131650" MODIFIED="1563514210408" TEXT="entry: &apos;./src/index.js&apos;,"/>
<node CREATED="1563514210410" MODIFIED="1563514210410" TEXT="output: {">
<node CREATED="1563514210411" MODIFIED="1563514210411" TEXT="filename: &apos;bundle.js&apos;,"/>
<node CREATED="1563514210414" MODIFIED="1563514210414" TEXT="path: path.resolve(__dirname, &apos;dist&apos;)"/>
</node>
<node CREATED="1563514210416" ID="ID_1876357498" MODIFIED="1563514210416" TEXT="},"/>
<node CREATED="1563514210418" FOLDED="true" ID="ID_1150797660" MODIFIED="1563514259411" TEXT="module: {">
<node CREATED="1563514210419" FOLDED="true" ID="ID_1901048191" MODIFIED="1563514259100" TEXT="rules: [">
<node CREATED="1563514210421" MODIFIED="1563514210421" TEXT="{">
<node CREATED="1563514210423" MODIFIED="1563514210423" TEXT="test: /\.css$/,"/>
<node CREATED="1563514210425" MODIFIED="1563514210425" TEXT="use: [">
<node CREATED="1563514210426" MODIFIED="1563514210426" TEXT="&apos;style-loader&apos;,"/>
<node CREATED="1563514210427" MODIFIED="1563514210427" TEXT="&apos;css-loader&apos;"/>
</node>
<node CREATED="1563514210427" MODIFIED="1563514210427" TEXT="]"/>
</node>
<node CREATED="1563514210428" MODIFIED="1563514210428" TEXT="}"/>
<node CREATED="1563514210429" ID="ID_1786461505" MODIFIED="1563514210429" TEXT=", {">
<node CREATED="1563514210430" MODIFIED="1563514210430" TEXT="test: /\.(png|svg|jpg|gif)$/,"/>
<node CREATED="1563514210431" ID="ID_1377853810" MODIFIED="1563514210431" TEXT="use: [">
<node CREATED="1563514210431" ID="ID_1414053298" MODIFIED="1563514210431" TEXT="&apos;file-loader&apos;"/>
</node>
<node CREATED="1563514210432" ID="ID_128206380" MODIFIED="1563514210432" TEXT="]"/>
</node>
<node CREATED="1563514210433" ID="ID_389926723" MODIFIED="1563514210433" TEXT="},"/>
<node COLOR="#3333ff" CREATED="1563514210433" ID="ID_1689316901" MODIFIED="1563514256053" STYLE="bubble" TEXT="{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563514210434" ID="ID_633601443" MODIFIED="1563514235716" STYLE="bubble" TEXT="test : /\.(woff|woff2|eot|ttf|otf)$/,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563514210434" ID="ID_1919820746" MODIFIED="1563514235716" STYLE="bubble" TEXT="use:[">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563514210435" ID="ID_999298958" MODIFIED="1563514235716" STYLE="bubble" TEXT="&apos;file-loader&apos;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563514210436" ID="ID_258719345" MODIFIED="1563514235716" STYLE="bubble" TEXT="]">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563514210436" ID="ID_947118807" MODIFIED="1563514235918" STYLE="bubble" TEXT="}">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563514210437" MODIFIED="1563514210437" TEXT="]"/>
</node>
<node CREATED="1563514210438" MODIFIED="1563514210438" TEXT="}"/>
</node>
<node CREATED="1563514210439" ID="ID_1483315799" MODIFIED="1563514215129" TEXT="};"/>
</node>
<node CREATED="1563514306817" FOLDED="true" ID="ID_690602716" MODIFIED="1563514344524" TEXT="css &#xbcc0;&#xacbd;">
<node COLOR="#3333ff" CREATED="1563514311072" ID="ID_1357146062" MODIFIED="1563514312566" STYLE="bubble" TEXT="@font-face{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563514311083" ID="ID_748394782" MODIFIED="1563514312833" STYLE="bubble" TEXT="font-family: &apos;My-Font&apos;;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563514311085" ID="ID_1330869632" MODIFIED="1563514313199" STYLE="bubble" TEXT="src: url(&apos;./NanumGothic-Regular.ttf&apos;),url(&apos;./NanumGothicCoding-Regular.ttf&apos;);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563514311089" ID="ID_308821510" MODIFIED="1563514314228" STYLE="bubble" TEXT="}">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563514311091" MODIFIED="1563514311091" TEXT=".hello {">
<node CREATED="1563514311093" MODIFIED="1563514311093" TEXT="color: red;"/>
<node CREATED="1563514311094" MODIFIED="1563514311094" TEXT="font-family: &apos;My-Font&apos;;"/>
<node CREATED="1563514311096" MODIFIED="1563514311096" TEXT="background: url(&apos;./recycle.png&apos;);"/>
<node CREATED="1563514311097" MODIFIED="1563514311097" TEXT="}"/>
</node>
</node>
</node>
<node CREATED="1563518956724" ID="ID_965699193" MODIFIED="1563519020647" TEXT="data Loading">
<node CREATED="1563518962460" ID="ID_1625344552" MODIFIED="1563518964865" TEXT="&#xc124;&#xce58;">
<node CREATED="1563518972606" MODIFIED="1563518972606" TEXT="npm install --save-dev csv-loader xml-loader"/>
</node>
<node CREATED="1563518993393" ID="ID_1656973496" MODIFIED="1563518997809" TEXT="webpack.config.js &#xcd94;&#xac00;">
<node CREATED="1563518987835" ID="ID_360360260" MODIFIED="1563518996420" TEXT="const path = require(&apos;path&apos;);"/>
<node CREATED="1563518987837" FOLDED="true" ID="ID_1664121496" MODIFIED="1563519019292" TEXT="module.exports = {">
<node CREATED="1563518987838" MODIFIED="1563518987838" TEXT="entry: &apos;./src/index.js&apos;,"/>
<node CREATED="1563518987840" MODIFIED="1563518987840" TEXT="output: {">
<node CREATED="1563518987842" MODIFIED="1563518987842" TEXT="filename: &apos;bundle.js&apos;,"/>
<node CREATED="1563518987843" MODIFIED="1563518987843" TEXT="path: path.resolve(__dirname, &apos;dist&apos;)"/>
</node>
<node CREATED="1563518987846" MODIFIED="1563518987846" TEXT="},"/>
<node CREATED="1563518987847" ID="ID_1641852349" MODIFIED="1563518987847" TEXT="module: {">
<node CREATED="1563518987850" ID="ID_784234529" MODIFIED="1563518987850" TEXT="rules: [">
<node CREATED="1563518987852" ID="ID_742249910" MODIFIED="1563518987852" TEXT="{">
<node CREATED="1563518987853" MODIFIED="1563518987853" TEXT="test: /\.css$/,"/>
<node CREATED="1563518987855" MODIFIED="1563518987855" TEXT="use: [">
<node CREATED="1563518987857" MODIFIED="1563518987857" TEXT="&apos;style-loader&apos;,"/>
<node CREATED="1563518987859" MODIFIED="1563518987859" TEXT="&apos;css-loader&apos;"/>
</node>
<node CREATED="1563518987860" MODIFIED="1563518987860" TEXT="]"/>
</node>
<node CREATED="1563518987862" ID="ID_1690105441" MODIFIED="1563518987862" TEXT="}"/>
<node CREATED="1563518987864" ID="ID_1527724791" MODIFIED="1563518987864" TEXT=", {">
<node CREATED="1563518987866" MODIFIED="1563518987866" TEXT="test: /\.(png|svg|jpg|gif)$/,"/>
<node CREATED="1563518987867" MODIFIED="1563518987867" TEXT="use: [">
<node CREATED="1563518987869" MODIFIED="1563518987869" TEXT="&apos;file-loader&apos;"/>
</node>
<node CREATED="1563518987871" MODIFIED="1563518987871" TEXT="]"/>
</node>
<node CREATED="1563518987872" ID="ID_527105427" MODIFIED="1563518987872" TEXT="},"/>
<node CREATED="1563518987874" ID="ID_915698839" MODIFIED="1563518987874" TEXT="{">
<node CREATED="1563518987875" MODIFIED="1563518987875" TEXT="test : /\.(woff|woff2|eot|ttf|otf)$/,"/>
<node CREATED="1563518987877" MODIFIED="1563518987877" TEXT="use:[">
<node CREATED="1563518987879" MODIFIED="1563518987879" TEXT="&apos;file-loader&apos;"/>
</node>
<node CREATED="1563518987884" MODIFIED="1563518987884" TEXT="]"/>
</node>
<node COLOR="#3333ff" CREATED="1563518987885" ID="ID_272103880" MODIFIED="1563519009990" STYLE="bubble" TEXT="},{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563518987887" ID="ID_782346568" MODIFIED="1563519010629" STYLE="bubble" TEXT="test: /\.(csv|tsv)$/,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563518987889" ID="ID_1617570643" MODIFIED="1563519010947" STYLE="bubble" TEXT="use:[">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563518987890" ID="ID_1868600484" MODIFIED="1563519011446" STYLE="bubble" TEXT="&apos;csv-loader&apos;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563518987892" ID="ID_1579367730" MODIFIED="1563519012111" STYLE="bubble" TEXT="]">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563518987893" ID="ID_1120382910" MODIFIED="1563519012702" STYLE="bubble" TEXT="},{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563518987895" ID="ID_1353018078" MODIFIED="1563519013847" STYLE="bubble" TEXT="test: /\.xml$/,">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1563518987897" ID="ID_576633026" MODIFIED="1563519014110" STYLE="bubble" TEXT="use:[">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1563518987899" ID="ID_1760527431" MODIFIED="1563519015214" STYLE="bubble" TEXT="&apos;xml-loader&apos;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1563518987901" ID="ID_978862875" MODIFIED="1563519014695" STYLE="bubble" TEXT="]">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563518987903" ID="ID_1714042389" MODIFIED="1563518987903" TEXT="}"/>
</node>
<node CREATED="1563518987904" MODIFIED="1563518987904" TEXT="]"/>
</node>
<node CREATED="1563518987906" MODIFIED="1563518987906" TEXT="}"/>
</node>
<node CREATED="1563518987908" ID="ID_1328957626" MODIFIED="1563518996346" TEXT="};"/>
</node>
<node CREATED="1563519026354" FOLDED="true" ID="ID_1380957900" MODIFIED="1563519046507" TEXT="index js &#xcd94;&#xac00;">
<node CREATED="1563519037872" MODIFIED="1563519037872" TEXT="import _ from &apos;lodash&apos;;"/>
<node CREATED="1563519037874" MODIFIED="1563519037874" TEXT="import &apos;./style.css&apos;;"/>
<node CREATED="1563519037876" ID="ID_1893349115" MODIFIED="1563519037876" TEXT="import Icon from &apos;./recycle.png&apos;;"/>
<node COLOR="#3333ff" CREATED="1563519037879" ID="ID_1689633658" MODIFIED="1563519041370" STYLE="bubble" TEXT="import Data from &apos;./data.xml&apos;;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563519037880" ID="ID_900304286" MODIFIED="1563519037880" TEXT="function component() {">
<node CREATED="1563519037884" MODIFIED="1563519037884" TEXT="const element = document.createElement(&apos;div&apos;);"/>
<node CREATED="1563519037888" MODIFIED="1563519037888" TEXT="// Lodash, currently included via a script, is required for this line to work"/>
<node CREATED="1563519037890" MODIFIED="1563519037890" TEXT="element.innerHTML = _.join([&apos;&#xc548;&#xb155;&apos;, &apos;&#xc6f9;&#xd3a9; &#xace0;&#xc591;&#xc544;&apos;], &apos; &apos;);"/>
<node CREATED="1563519037892" MODIFIED="1563519037892" TEXT="element.classList.add(&apos;hello&apos;);"/>
<node CREATED="1563519037895" MODIFIED="1563519037895" TEXT="//add the image to our exisitng div."/>
<node CREATED="1563519037898" ID="ID_321965575" MODIFIED="1563519037898" TEXT="const myIcon = new Image();"/>
<node CREATED="1563519037899" ID="ID_663114590" MODIFIED="1563519037899" TEXT="myIcon.src = Icon;"/>
<node CREATED="1563519037901" ID="ID_1732093917" MODIFIED="1563519037901" TEXT="element.appendChild(myIcon);"/>
<node COLOR="#3333ff" CREATED="1563519037903" ID="ID_309914455" MODIFIED="1563519043815" STYLE="bubble" TEXT="console.log(Data);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563519037904" MODIFIED="1563519037904" TEXT="return element;"/>
<node CREATED="1563519037905" MODIFIED="1563519037905" TEXT="}"/>
<node CREATED="1563519037906" MODIFIED="1563519037906" TEXT="document.body.appendChild(component());"/>
</node>
</node>
</node>
</node>
</node>
</map>

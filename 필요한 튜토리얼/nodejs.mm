<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1563357265691" ID="ID_1123568473" MODIFIED="1563357388156" TEXT="nodeJS">
<node CREATED="1563357371681" ID="ID_900935524" MODIFIED="1568491948473" POSITION="right" TEXT="&#xd568;&#xc218;&#xc5d0; &#xb300;&#xd55c; &#xac83;">
<node CREATED="1563357392161" ID="ID_1798328365" MODIFIED="1563357492595" TEXT="&#xd568;&#xc218;&#xc120;&#xc5b8;">
<node CREATED="1563357492575" FOLDED="true" ID="ID_536169701" MODIFIED="1563357510240" TEXT="&#xd568;&#xc218; statement">
<node CREATED="1563357375056" ID="ID_724845151" MODIFIED="1563357504596" TEXT="function callHero(){">
<node CREATED="1563357375057" MODIFIED="1563357375057" TEXT="console.log(&quot;hi, Superman, it is a function statement&quot;);"/>
</node>
<node CREATED="1563357375057" ID="ID_1049637786" MODIFIED="1563357395060" TEXT="}"/>
</node>
<node CREATED="1563357397439" FOLDED="true" ID="ID_1447581239" MODIFIED="1563357508323" TEXT="&#xd568;&#xc218; expression">
<node CREATED="1563357375058" ID="ID_796525698" MODIFIED="1563357405074" TEXT="const exp1 = function callHero(){">
<node CREATED="1563357375058" MODIFIED="1563357375058" TEXT="console.log(&quot;Hi, Superman, it is a function ex&quot;);"/>
</node>
<node CREATED="1563357375059" ID="ID_1439590563" MODIFIED="1563357405068" TEXT="}"/>
</node>
</node>
</node>
<node CREATED="1563357518768" ID="ID_1797068492" MODIFIED="1565731871646" POSITION="right" TEXT="&#xbaa8;&#xb4c8;&#xacfc; require">
<node CREATED="1563358510938" ID="ID_457339077" MODIFIED="1565731877509" TEXT="app.js">
<node CREATED="1563358524884" ID="ID_982944969" MODIFIED="1563358524884" TEXT="console.log(&apos;hi,I am oratree&apos;);"/>
<node CREATED="1563358524886" ID="ID_888241725" MODIFIED="1563358524886" TEXT="const heroes = require(&apos;./heroes&apos;);"/>
<node CREATED="1563358524887" ID="ID_13365144" MODIFIED="1563358524887" TEXT="heroes.callHero();"/>
<node CREATED="1563358524888" ID="ID_1826247232" MODIFIED="1563358524888" TEXT="console.log(heroes.heroList);"/>
<node CREATED="1563358524889" ID="ID_281710414" MODIFIED="1563358524889" TEXT="console.log(heroes.adder(6,7));"/>
</node>
<node CREATED="1563358514000" ID="ID_297712982" MODIFIED="1565731878734" TEXT="heroes.js">
<node CREATED="1563358533578" ID="ID_1966672340" MODIFIED="1563358533578" TEXT="module.exports.callHero = function callHero(){">
<node CREATED="1563358533579" MODIFIED="1563358533579" TEXT="console.log(&quot;hi, Superman, it is a function statement&quot;);"/>
</node>
<node CREATED="1563358533579" ID="ID_712661176" MODIFIED="1563358533579" TEXT="};"/>
<node CREATED="1563358533580" ID="ID_1395401675" MODIFIED="1563358533580" TEXT="module.exports.heroList = [&apos;Superman&apos;,&apos;Birdman&apos;];"/>
<node CREATED="1563358533580" ID="ID_1705311839" MODIFIED="1563358533580" TEXT="module.exports.adder = function adder(a,b){">
<node CREATED="1563358533580" MODIFIED="1563358533580" TEXT="return a+b;"/>
</node>
<node CREATED="1563358533581" ID="ID_1067486499" MODIFIED="1563358533581" TEXT="};"/>
</node>
<node COLOR="#3333ff" CREATED="1563358633504" ID="ID_1408078538" MODIFIED="1563358641477" STYLE="bubble" TEXT="heroes.js(&#xbcf4;&#xd1b5; &#xc774;&#xb807;&#xac8c; &#xbaa8;&#xb4c8; &#xc124;&#xc815;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1563358641972" ID="ID_1693513068" MODIFIED="1563358641972" TEXT="function callHero(){">
<node CREATED="1563358641973" MODIFIED="1563358641973" TEXT="console.log(&quot;hi, Superman, it is a function statement&quot;);"/>
</node>
<node CREATED="1563358641974" MODIFIED="1563358641974" TEXT="}"/>
<node CREATED="1563358641974" MODIFIED="1563358641974" TEXT="const heroList = [&apos;Superman&apos;,&apos;Birdman&apos;];"/>
<node CREATED="1563358641974" MODIFIED="1563358641974" TEXT="function adder(a,b){">
<node CREATED="1563358641975" MODIFIED="1563358641975" TEXT="return a+b;"/>
</node>
<node CREATED="1563358641976" ID="ID_913344778" MODIFIED="1563358641976" TEXT="};"/>
<node CREATED="1563358641976" MODIFIED="1563358641976" TEXT="module.exports ={">
<node CREATED="1563358641977" MODIFIED="1563358641977" TEXT="callHero,"/>
<node CREATED="1563358641977" MODIFIED="1563358641977" TEXT="heroList,"/>
<node CREATED="1563358641977" MODIFIED="1563358641977" TEXT="adder"/>
</node>
<node CREATED="1563358641978" MODIFIED="1563358641978" TEXT="}"/>
</node>
</node>
<node CREATED="1563365545801" ID="ID_1925728577" MODIFIED="1568491921442" POSITION="right" TEXT="event">
<node CREATED="1563365549144" ID="ID_625422859" MODIFIED="1563365549144" TEXT="const events = require(&apos;events&apos;);"/>
<node CREATED="1563365549149" ID="ID_647051559" MODIFIED="1563365549149" TEXT="const util = require(&apos;util&apos;);"/>
<node CREATED="1563365549150" ID="ID_1583106363" MODIFIED="1563365549150" TEXT="const Hero = function(name){">
<node CREATED="1563365549151" MODIFIED="1563365549151" TEXT="this.name = name;"/>
</node>
<node CREATED="1563365549152" ID="ID_1308933056" MODIFIED="1563365549152" TEXT="}"/>
<node CREATED="1563365549153" ID="ID_1170255190" MODIFIED="1563365549153" TEXT="util.inherits(Hero,events.EventEmitter);"/>
<node CREATED="1563365549154" ID="ID_1471697943" MODIFIED="1563365549154" TEXT="const superman = new Hero(&apos;Superman&apos;); // {name : &apos;Superman&apos;}"/>
<node CREATED="1563365549155" ID="ID_1958120807" MODIFIED="1563365549155" TEXT="const birdman = new Hero(&apos;birdman&apos;); // {name : &apos;Superman&apos;}"/>
<node CREATED="1563365549156" ID="ID_934978965" MODIFIED="1563365549156" TEXT="const batman = new Hero(&apos;batman&apos;); // {name : &apos;Superman&apos;}"/>
<node CREATED="1563365549157" ID="ID_1932754477" MODIFIED="1563365549157" TEXT="console.log(superman);"/>
<node CREATED="1563365549158" ID="ID_1454619982" MODIFIED="1563365549158" TEXT="const heroList =[superman,birdman,batman];"/>
<node CREATED="1563365549159" ID="ID_976573246" MODIFIED="1563365549159" TEXT="heroList.forEach(function(hero) {">
<node CREATED="1563365549159" ID="ID_1038830448" MODIFIED="1563365549159" TEXT="hero.on(&apos;call&apos;,function(message){">
<node CREATED="1563365549161" ID="ID_980430017" MODIFIED="1563365549161" TEXT="console.log(hero.name + &apos;fights with Joker&apos; + message);"/>
</node>
<node CREATED="1563365549162" MODIFIED="1563365549162" TEXT="})"/>
</node>
<node CREATED="1563365549163" ID="ID_1120359937" MODIFIED="1563365549163" TEXT="});"/>
<node CREATED="1563365549163" ID="ID_874936945" MODIFIED="1563365549163" TEXT="superman.emit(&apos;call&apos;,&apos;&#xace0;&#xb9c8;&#xc6cc;&#xc694;&apos;);"/>
<node CREATED="1563365549164" MODIFIED="1563365549164" TEXT="birdman.emit(&apos;call&apos;,&apos;&#xace0;&#xb9c8;&#xc6cc;&#xc694;&apos;);"/>
<node CREATED="1563365549165" MODIFIED="1563365549165" TEXT="batman.emit(&apos;call&apos;,&apos;&#xace0;&#xb9c8;&#xc6cc;&#xc694;&apos;);"/>
</node>
<node CREATED="1563366224519" FOLDED="true" ID="ID_270163606" MODIFIED="1568491921110" POSITION="right" TEXT="File">
<node CREATED="1563366231553" FOLDED="true" ID="ID_794467239" MODIFIED="1568491920269" TEXT="&#xb3d9;&#xae30;&#xb85c; &#xc77d;&#xae30;">
<node CREATED="1563366226079" ID="ID_478986182" MODIFIED="1563366238533" TEXT="let fs = require(&apos;fs&apos;);"/>
<node CREATED="1563366226082" ID="ID_1071618222" MODIFIED="1563366238536" TEXT="const fsTest = fs.readFileSync(&apos;app.js&apos;,&apos;utf-8&apos;);"/>
<node CREATED="1563366226085" ID="ID_1103269532" MODIFIED="1563366226085" TEXT="console.log(fsTest);"/>
</node>
<node CREATED="1563366281438" FOLDED="true" ID="ID_500955411" MODIFIED="1568491920269" TEXT="&#xbe44;&#xb3d9;&#xae30;&#xb85c; &#xc77d;&#xae30;1">
<node CREATED="1563366421055" MODIFIED="1563366421055" TEXT="let fs = require(&apos;fs&apos;);"/>
<node CREATED="1563366421056" ID="ID_1803967208" MODIFIED="1563366421056" TEXT="const fsTest = fs.readFile(&apos;app.js&apos;, (err, data) =&gt; {">
<node CREATED="1563366421057" MODIFIED="1563366421057" TEXT="if (err) throw err;"/>
<node CREATED="1563366421058" MODIFIED="1563366421058" TEXT="console.log(data);"/>
<node CREATED="1563366421059" MODIFIED="1563366421059" TEXT="});"/>
</node>
<node CREATED="1563366421060" ID="ID_1742224427" MODIFIED="1563366421060" TEXT="console.log(&apos;efe&apos;);"/>
<node CREATED="1563366444550" ID="ID_668408102" MODIFIED="1563366457234" TEXT="&#xb2f5;(&#xc774;&#xbbf8;&#xc9c0;) &#xbc84;&#xd37c;&#xb85c; &#xb098;&#xc634;">
<node CREATED="1563366447200" ID="ID_421907505" MODIFIED="1563366447200">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="nodejs_6765777283173577201.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1563366539550" FOLDED="true" ID="ID_518358552" MODIFIED="1568491920269" TEXT="&#xbe44;&#xb3d9;&#xae30;&#xb85c; &#xc77d;&#xae30;2(utf-8&#xb85c; &#xc124;&#xc815;)">
<node CREATED="1563366547996" ID="ID_270132078" MODIFIED="1563366547996" TEXT="let fs = require(&apos;fs&apos;);"/>
<node CREATED="1563366547998" ID="ID_1494433046" MODIFIED="1563366547998" TEXT="const fsTest = fs.readFile(&apos;app.js&apos;,&apos;utf-8&apos;, (err, data) =&gt; {">
<node CREATED="1563366548000" MODIFIED="1563366548000" TEXT="if (err) throw err;"/>
<node CREATED="1563366548003" ID="ID_860378692" MODIFIED="1563366548003" TEXT="console.log(data);"/>
<node CREATED="1563366548004" ID="ID_965023721" MODIFIED="1563366548004" TEXT="});"/>
</node>
<node CREATED="1563366548008" ID="ID_337999808" MODIFIED="1563366548008" TEXT="console.log(&apos;efe&apos;);"/>
</node>
<node CREATED="1563414295389" FOLDED="true" ID="ID_1965360417" MODIFIED="1568491920269" TEXT="&#xb3d9;&#xae30;&#xb85c; &#xc4f0;&#xae30;">
<node CREATED="1563414315840" ID="ID_668386652" MODIFIED="1563414315840" TEXT="const fsTest = fs.readFile(&apos;app.js&apos;,&apos;utf-8&apos;, (err, data) =&gt; {">
<node CREATED="1563414315841" MODIFIED="1563414315841" TEXT="if (err) throw err;"/>
<node CREATED="1563414315842" ID="ID_1901540075" MODIFIED="1563414315842" TEXT="console.log(data);"/>
<node COLOR="#3333ff" CREATED="1563414315842" ID="ID_1469280939" MODIFIED="1563414318016" STYLE="bubble" TEXT="fs.writeFileSync(&apos;message.txt&apos;,data);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563414315843" ID="ID_874256002" MODIFIED="1563414321007" TEXT="});">
<font NAME="SansSerif" SIZE="12"/>
</node>
</node>
</node>
<node CREATED="1563414616985" FOLDED="true" ID="ID_1961446835" MODIFIED="1568491920269" TEXT="&#xbe44;&#xb3d9;&#xae30;&#xb85c; &#xc4f0;&#xae30;">
<node COLOR="#3333ff" CREATED="1563414619424" ID="ID_893731851" MODIFIED="1563414620529" STYLE="bubble" TEXT="  fs.writeFile(&apos;message11.txt&apos;,&apos;wefwefwf&apos;,(err) =&gt; {&#xa;    if(err) throw err;&#xa;    console.log(&apos;file completly write&apos;);&#xa;  });">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1563422899420" FOLDED="true" ID="ID_1871672481" MODIFIED="1568491920269" TEXT="&#xb3d9;&#xae30;&#xb85c; &#xc0ad;&#xc81c;">
<node CREATED="1563422917917" MODIFIED="1563422917917" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563422917919" MODIFIED="1563422917919" TEXT="fs.unlinkSync(&apos;message.txt&apos;);"/>
<node CREATED="1563422917920" MODIFIED="1563422917920" TEXT="console.log(1);"/>
</node>
<node CREATED="1563422903573" FOLDED="true" ID="ID_1552590923" MODIFIED="1568491920269" TEXT="&#xbe44;&#xb3d9;&#xae30;&#xb85c; &#xc0ad;&#xc81c;">
<node CREATED="1563423033704" MODIFIED="1563423033704" TEXT="fs.unlink(&apos;message.txt&apos;,()=&gt;{">
<node CREATED="1563423033708" MODIFIED="1563423033708" TEXT="console.log(&quot;deleted the file.&quot;);"/>
</node>
<node CREATED="1563423033711" MODIFIED="1563423033711" TEXT="});"/>
</node>
<node CREATED="1563423111555" FOLDED="true" ID="ID_965960079" MODIFIED="1568491920269" TEXT="&#xb3d9;&#xae30;&#xb85c; &#xd3f4;&#xb354; &#xb9cc;&#xb4e4;&#xae30;">
<node CREATED="1563423123634" MODIFIED="1563423123634" TEXT="fs.mkdirSync(&apos;test&apos;);"/>
</node>
<node CREATED="1563423140582" FOLDED="true" ID="ID_1132718361" MODIFIED="1568491920269" TEXT="&#xc2f1;&#xd06c;&#xb85c; &#xd3f4;&#xb354; &#xc0ad;&#xc81c;">
<node CREATED="1563423143155" MODIFIED="1563423143155" TEXT="fs.rmdirSync(&apos;test&apos;);"/>
</node>
<node CREATED="1563423906031" FOLDED="true" ID="ID_36913592" MODIFIED="1563423909762" TEXT="&#xbcf5;&#xd569;&#xc801; &#xc5f0;&#xc2b5;">
<node CREATED="1563423909177" MODIFIED="1563423909177" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563423909179" MODIFIED="1563423909179" TEXT="fs.unlink(&apos;message.txt&apos;,()=&gt;{">
<node CREATED="1563423909181" MODIFIED="1563423909181" TEXT="console.log(&quot;deleted the file.&quot;);"/>
</node>
<node CREATED="1563423909184" MODIFIED="1563423909184" TEXT="});"/>
<node CREATED="1563423909185" MODIFIED="1563423909185" TEXT="fs.writeFileSync(&apos;message.txt&apos;,&apos;Hi, I am Jupeter&apos;);"/>
<node CREATED="1563423909187" MODIFIED="1563423909187" TEXT="fs.mkdir(&apos;test&apos;,()=&gt;{">
<node CREATED="1563423909188" MODIFIED="1563423909188" TEXT="fs.readFile(&apos;message.txt&apos;,&apos;utf-8&apos;,(err,data) =&gt;{">
<node CREATED="1563423909191" MODIFIED="1563423909191" TEXT="fs.writeFileSync(&apos;./test/newMessage.txt&apos;,data)"/>
</node>
<node CREATED="1563423909193" MODIFIED="1563423909193" TEXT="});"/>
</node>
<node CREATED="1563423909197" MODIFIED="1563423909197" TEXT="});"/>
<node CREATED="1563423909198" MODIFIED="1563423909198" TEXT="console.log(1);"/>
</node>
</node>
<node CREATED="1563423910453" ID="ID_1982412557" MODIFIED="1568491914206" POSITION="right" TEXT="http">
<node CREATED="1563424209734" ID="ID_1033775365" MODIFIED="1563424212616" TEXT="&#xc11c;&#xbc84;&#xb9cc;&#xb4e4;&#xae30;">
<node CREATED="1563425549613" MODIFIED="1563425549613" TEXT="const http = require(&apos;http&apos;);"/>
<node COLOR="#3333ff" CREATED="1563425549617" ID="ID_1184270054" MODIFIED="1563425551392" STYLE="bubble" TEXT="const server = http.createServer((req,res) =&gt;{">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1563425549620" MODIFIED="1563425551371" TEXT="res.writeHead(200);"/>
<node CREATED="1563425549623" ID="ID_1855956603" MODIFIED="1563425551371" TEXT="res.end(&apos;Okay, I am listening your request, give me one.&apos;);"/>
<node CREATED="1563425549625" ID="ID_1182708515" MODIFIED="1563425551371" TEXT="console.log(&apos;Server is listening...&apos;);"/>
</node>
<node CREATED="1563425549627" ID="ID_1700884553" MODIFIED="1563425549627" TEXT="})"/>
<node CREATED="1563425549629" MODIFIED="1563425549629" TEXT="server.listen(5500,&apos;127.0.0.1&apos;);"/>
<node CREATED="1563425549631" MODIFIED="1563425549631" TEXT="console.log(&apos;&apos;);"/>
<node CREATED="1563425549633" MODIFIED="1563425549633" TEXT="console.log(&apos;server is running&apos;);"/>
</node>
</node>
<node CREATED="1563425853972" FOLDED="true" ID="ID_292138073" MODIFIED="1568491913984" POSITION="right" TEXT="stream">
<node CREATED="1563425860213" ID="ID_1931335726" MODIFIED="1563425862655" TEXT="&#xc11c;&#xbc84;&#xc5d0;&#xc11c; &#xc2a4;&#xd2b8;&#xb9bc;">
<node CREATED="1563427575386" ID="ID_1982757786" MODIFIED="1563427575386" TEXT="const http = require(&apos;http&apos;);"/>
<node CREATED="1563427575389" ID="ID_608998583" MODIFIED="1563427575389" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563427575390" ID="ID_1895549858" MODIFIED="1563427575390" TEXT="const readable = fs.createReadStream(&apos;./message.txt&apos;);"/>
<node CREATED="1563427575391" ID="ID_1258099513" MODIFIED="1563427575391" TEXT="const writable = fs.createWriteStream(&apos;./newMessage.txt&apos;);"/>
<node CREATED="1563427575399" ID="ID_216047599" MODIFIED="1563427575399" TEXT="readable.on(&apos;data&apos;,(data) =&gt;{">
<node CREATED="1563427575400" ID="ID_1098111238" MODIFIED="1563427575400" TEXT="console.log(&apos;readable stream is working&apos;);"/>
<node CREATED="1563427575402" ID="ID_1715742508" MODIFIED="1563427575402" TEXT="writable.write(data);"/>
</node>
<node CREATED="1563427575403" ID="ID_1474486007" MODIFIED="1563427575403" TEXT="});"/>
</node>
<node CREATED="1563427694213" ID="ID_1244147440" MODIFIED="1563427698848" TEXT="&#xc6f9;&#xc11c;&#xbc84;&#xc5d0;&#xc11c; &#xd074;&#xb77c;&#xc774;&#xc5b8;&#xd2b8;&#xb85c;"/>
<node CREATED="1563427699068" ID="ID_1653974345" MODIFIED="1563427703632" TEXT="&#xd074;&#xb77c;&#xc774;&#xc5b8;&#xd2b8;&#xc5d0;&#xc11c; &#xc6f9;&#xc11c;&#xbc84;&#xb85c;"/>
</node>
<node CREATED="1563429441100" FOLDED="true" ID="ID_1372718028" MODIFIED="1568491911455" POSITION="right" TEXT="pipe">
<node CREATED="1563429463188" ID="ID_1845978297" MODIFIED="1563429463188" TEXT="const http = require(&apos;http&apos;);"/>
<node CREATED="1563429463191" ID="ID_133149780" MODIFIED="1563429463191" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563429463193" ID="ID_903223537" MODIFIED="1563429463193" TEXT="const readable = fs.createReadStream(&apos;./message.txt&apos;);"/>
<node CREATED="1563429463195" ID="ID_401830175" MODIFIED="1563429463195" TEXT="const writable = fs.createWriteStream(&apos;./newMessage.txt&apos;);"/>
<node CREATED="1563429463196" ID="ID_902525933" MODIFIED="1563429463196" TEXT="// readable.on(&apos;data&apos;,(data) =&gt;{"/>
<node CREATED="1563429463196" ID="ID_817423140" MODIFIED="1563429463196" TEXT="//     console.log(&apos;readable stream is working&apos;);"/>
<node CREATED="1563429463197" ID="ID_692182375" MODIFIED="1563429463197" TEXT="//     writable.write(data);"/>
<node CREATED="1563429463198" ID="ID_1814720863" MODIFIED="1563429463198" TEXT="// });"/>
<node CREATED="1563429463199" ID="ID_487345252" MODIFIED="1563429463199" TEXT="const server = http.createServer((req,res) =&gt;{">
<node CREATED="1563429463200" ID="ID_1042464352" MODIFIED="1563429463200" TEXT="res.writeHead(200);"/>
<node COLOR="#3333ff" CREATED="1563429463201" ID="ID_427229984" MODIFIED="1563429474323" STYLE="bubble" TEXT="readable.pipe(res);">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1563429463202" ID="ID_334269435" MODIFIED="1563429463202" TEXT="//res.end(&apos;Okay, I am listening your request, give me one.&apos;);"/>
<node CREATED="1563429463203" ID="ID_556572894" MODIFIED="1563429463203" TEXT="console.log(&apos;Server is listening...&apos;);"/>
</node>
<node CREATED="1563429463204" ID="ID_1177485013" MODIFIED="1563429463204" TEXT="})"/>
<node CREATED="1563429463205" ID="ID_30706305" MODIFIED="1563429463205" TEXT="server.listen(5500,&apos;127.0.0.1&apos;);"/>
<node CREATED="1563429463205" ID="ID_1745493014" MODIFIED="1563429463205" TEXT="console.log(&apos;&apos;);"/>
<node CREATED="1563429463206" ID="ID_1640393921" MODIFIED="1563429463206" TEXT="console.log(&apos;server is running&apos;);"/>
<node CREATED="1563429463207" ID="ID_1294326038" MODIFIED="1563429463207" TEXT="//readable.pipe(writable);"/>
</node>
<node CREATED="1563430757907" FOLDED="true" ID="ID_1723751535" MODIFIED="1568491909534" POSITION="right" TEXT="html pipie">
<node CREATED="1563430760953" ID="ID_341156972" MODIFIED="1563430760953" TEXT="const http = require(&apos;http&apos;);"/>
<node CREATED="1563430760954" ID="ID_366084648" MODIFIED="1563430760954" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563430760955" ID="ID_755998239" MODIFIED="1563430760955" TEXT="const readable = fs.createReadStream(&apos;./message.html&apos;);"/>
<node CREATED="1563430760956" ID="ID_470156943" MODIFIED="1563430760956" TEXT="const writable = fs.createWriteStream(&apos;./newMessage.txt&apos;);"/>
<node CREATED="1563430760957" ID="ID_602153108" MODIFIED="1563430760957" TEXT="// readable.on(&apos;data&apos;,(data) =&gt;{"/>
<node CREATED="1563430760958" ID="ID_220298789" MODIFIED="1563430760958" TEXT="//     console.log(&apos;readable stream is working&apos;);"/>
<node CREATED="1563430760959" ID="ID_1546196677" MODIFIED="1563430760959" TEXT="//     writable.write(data);"/>
<node CREATED="1563430760960" ID="ID_1650714012" MODIFIED="1563430760960" TEXT="// });"/>
<node CREATED="1563430760962" ID="ID_885548262" MODIFIED="1563430760962" TEXT="const server = http.createServer((req,res) =&gt;{">
<node CREATED="1563430760963" ID="ID_1089171029" MODIFIED="1563430760963" TEXT="res.writeHead(200,{&apos;Content-Type&apos;: &apos;text/html&apos;});"/>
<node CREATED="1563430760964" MODIFIED="1563430760964" TEXT="readable.pipe(res);"/>
<node CREATED="1563430760965" MODIFIED="1563430760965" TEXT="//res.end(&apos;Okay, I am listening your request, give me one.&apos;);"/>
<node CREATED="1563430760966" MODIFIED="1563430760966" TEXT="console.log(&apos;Server is listening...&apos;);"/>
</node>
<node CREATED="1563430760966" ID="ID_421819603" MODIFIED="1563430760966" TEXT="})"/>
<node CREATED="1563430760967" ID="ID_1520679381" MODIFIED="1563430760967" TEXT="server.listen(5500,&apos;127.0.0.1&apos;);"/>
<node CREATED="1563430760968" ID="ID_116444763" MODIFIED="1563430760968" TEXT="console.log(&apos;&apos;);"/>
<node CREATED="1563430760968" MODIFIED="1563430760968" TEXT="console.log(&apos;server is running&apos;);"/>
<node CREATED="1563430760969" MODIFIED="1563430760969" TEXT="//readable.pipe(writable);"/>
</node>
<node CREATED="1563443192403" ID="ID_28399277" MODIFIED="1568491895555" POSITION="right" TEXT="&#xac04;&#xb2e8;&#xd55c; &#xb77c;&#xc6b0;&#xd305;">
<node CREATED="1563443200031" MODIFIED="1563443200031" TEXT="const http = require(&apos;http&apos;);"/>
<node CREATED="1563443200033" MODIFIED="1563443200033" TEXT="const fs = require(&apos;fs&apos;);"/>
<node CREATED="1563443200033" MODIFIED="1563443200033" TEXT="// readable.on(&apos;data&apos;,(data) =&gt;{"/>
<node CREATED="1563443200034" MODIFIED="1563443200034" TEXT="//     console.log(&apos;readable stream is working&apos;);"/>
<node CREATED="1563443200035" MODIFIED="1563443200035" TEXT="//     writable.write(data);"/>
<node CREATED="1563443200035" MODIFIED="1563443200035" TEXT="// });"/>
<node CREATED="1563443200036" MODIFIED="1563443200036" TEXT="const server = http.createServer((req, res) =&gt; {">
<node CREATED="1563443200037" MODIFIED="1563443200037" TEXT="console.log(req.url);"/>
<node CREATED="1563443200038" MODIFIED="1563443200038" TEXT="if(req.url === &apos;/home&apos; || req.url === &quot;/&quot;){">
<node CREATED="1563443200041" MODIFIED="1563443200041" TEXT="fs.createReadStream(&apos;./index.html&apos;).pipe(res);"/>
</node>
<node CREATED="1563443200042" MODIFIED="1563443200042" TEXT="}"/>
<node CREATED="1563443200042" MODIFIED="1563443200042" TEXT="else if(req.url === &apos;/document&apos; ){">
<node CREATED="1563443200043" MODIFIED="1563443200043" TEXT="fs.createReadStream(&apos;./document.html&apos;).pipe(res);"/>
</node>
<node CREATED="1563443200044" MODIFIED="1563443200044" TEXT="}"/>
<node CREATED="1563443200045" MODIFIED="1563443200045" TEXT="else if(req.url === &apos;/contacts&apos; ){">
<node CREATED="1563443200045" MODIFIED="1563443200045" TEXT="fs.createReadStream(&apos;./contacts.html&apos;).pipe(res);"/>
</node>
<node CREATED="1563443200046" MODIFIED="1563443200046" TEXT="}"/>
</node>
<node CREATED="1563443200047" MODIFIED="1563443200047" TEXT="})"/>
<node CREATED="1563443200047" MODIFIED="1563443200047" TEXT="server.listen(5500, &apos;127.0.0.1&apos;);"/>
<node CREATED="1563443200048" MODIFIED="1563443200048" TEXT="//readable.pipe(writable);"/>
</node>
</node>
</map>

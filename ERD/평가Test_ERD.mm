<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1570188500128" ID="ID_910731083" MODIFIED="1571087024976" TEXT="&#xd3c9;&#xac00;ERD">
<hook NAME="accessories/plugins/CreationModificationPlugin_new.properties"/>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189045410" FOLDED="true" ID="ID_1991772313" MODIFIED="1572267926418" POSITION="right" STYLE="bubble" TEXT="eva_user">
<cloud/>
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570189125737" ID="ID_1878136139" MODIFIED="1570383203111" STYLE="bubble" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_516525150" ENDARROW="Default" ENDINCLINATION="152;0;" ID="Arrow_ID_1936111345" STARTARROW="None" STARTINCLINATION="152;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570199703998" ID="ID_1115559162" MODIFIED="1570383203112" TEXT="nickname(&#xb125;&#xb124;&#xc784;)"/>
<node CREATED="1570379443419" ID="ID_1074661293" MODIFIED="1570383203112" TEXT="user_login_id(&#xb85c;&#xadf8;&#xc778;&#xc6a9; &#xc544;&#xc774;&#xb514;)"/>
<node CREATED="1570201430987" ID="ID_1217597435" MODIFIED="1570383203113" TEXT="password(&#xc554;&#xd638;)"/>
<node CREATED="1570189129233" ID="ID_843643958" MODIFIED="1570383203117" TEXT="email(&#xc774;&#xba54;&#xc77c;)"/>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_224944945" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_779080087" MODIFIED="1570388019242" TEXT="evaluate"/>
<node CREATED="1570388026639" ID="ID_654106225" MODIFIED="1570388030410" TEXT="worksSave"/>
<node CREATED="1572228606174" ID="ID_732103902" MODIFIED="1572228608273" TEXT="ArtistSave"/>
<node CREATED="1570388036622" ID="ID_1258532452" MODIFIED="1570388037763" TEXT="artist">
<node CREATED="1570388039807" ID="ID_221775553" MODIFIED="1570388042442" TEXT="OneToOne"/>
</node>
</node>
</node>
<node COLOR="#3333ff" CREATED="1570189123466" FOLDED="true" ID="ID_823115216" MODIFIED="1573385027961" POSITION="right" STYLE="bubble" TEXT="evaluate">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570201625524" ID="ID_49493969" MODIFIED="1570383117272" STYLE="bubble" TEXT="eval_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570201636571" ID="ID_516525150" MODIFIED="1570383117272" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_516525150" ENDARROW="Default" ENDINCLINATION="152;0;" ID="Arrow_ID_1936111345" SOURCE="ID_1878136139" STARTARROW="None" STARTINCLINATION="152;0;"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570201644098" ID="ID_1932256498" MODIFIED="1570383117273" TEXT="eval_item_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xd15c; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1932256498" ENDARROW="Default" ENDINCLINATION="95;0;" ID="Arrow_ID_54834023" SOURCE="ID_893901578" STARTARROW="None" STARTINCLINATION="95;0;"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570201715748" ID="ID_1744847530" MODIFIED="1570643417299" TEXT="works_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1744847530" ENDARROW="Default" ENDINCLINATION="181;0;" ID="Arrow_ID_279562913" SOURCE="ID_215478684" STARTARROW="None" STARTINCLINATION="181;0;"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node CREATED="1570201703003" ID="ID_1092728263" MODIFIED="1570383117273" TEXT="eval_date(&#xd3c9;&#xac00; &#xc2dc;&#xac04;)"/>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189342913" FOLDED="true" ID="ID_410823363" MODIFIED="1573385027961" POSITION="right" STYLE="bubble" TEXT="evaluation_item">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570190822564" ID="ID_893901578" MODIFIED="1570383204889" STYLE="bubble" TEXT="eval_item_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xd15c; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_1932256498" ENDARROW="Default" ENDINCLINATION="95;0;" ID="Arrow_ID_54834023" STARTARROW="None" STARTINCLINATION="95;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570189921308" ID="ID_1467303721" MODIFIED="1570383204889" TEXT="subjectMatter(&#xc18c;&#xc7ac;)"/>
<node CREATED="1570190392805" ID="ID_1920594019" MODIFIED="1570383204890" TEXT="ev_text1(&#xd3c9;&#xac00;&#xd14d;&#xc2a4;&#xd2b8; &#xc0c1;&#xb2e8;)"/>
<node CREATED="1570190404700" ID="ID_52426446" MODIFIED="1570383204890" TEXT="ev_text2(&#xd3c9;&#xac00;&#xd14d;&#xc2a4;&#xd2b8; &#xd558;&#xb2e8;)"/>
<node CREATED="1572931196700" ID="ID_257539613" MODIFIED="1572931201951" TEXT="ev_value(&#xd3c9;&#xac00; &#xac12;)"/>
<node CREATED="1570190851502" ID="ID_837426600" MODIFIED="1570383204891" STYLE="fork" TEXT="donation(&#xae30;&#xbd80;)">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_1066688788" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_1749271054" MODIFIED="1570388019242" TEXT="evaluate"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189656666" FOLDED="true" ID="ID_1345748298" MODIFIED="1572267926420" POSITION="right" STYLE="bubble" TEXT="works">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570200683673" ID="ID_215478684" MODIFIED="1570383205463" STYLE="bubble" TEXT="work_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_1744847530" ENDARROW="Default" ENDINCLINATION="181;0;" ID="Arrow_ID_279562913" STARTARROW="None" STARTINCLINATION="181;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570190699821" ID="ID_81892006" MODIFIED="1570639869767" TEXT="type2_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node CREATED="1570190461676" ID="ID_767182587" MODIFIED="1570383205464" TEXT="subject(&#xc81c;&#xbaa9;)"/>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_1259491908" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_456484299" MODIFIED="1570388019242" TEXT="evaluate"/>
<node CREATED="1570388138134" ID="ID_1400887036" MODIFIED="1570388144810" TEXT="worksSave"/>
<node CREATED="1570388147262" ID="ID_815181879" MODIFIED="1570388148242" TEXT="create"/>
<node CREATED="1570643280420" ID="ID_26264173" MODIFIED="1570643297833" TEXT="fileSave"/>
</node>
<node CREATED="1571689135980" ID="ID_450590807" MODIFIED="1571689787691" TEXT="is_series">
<node CREATED="1571689141853" ID="ID_574097148" MODIFIED="1571689149632" TEXT="0&#xc774;&#xba74; &#xc2dc;&#xb9ac;&#xc988; &#xc544;&#xb2d8;"/>
<node CREATED="1571689149811" ID="ID_591110087" MODIFIED="1571689151160" TEXT="1&#xc774;&#xba74; &#xc2dc;&#xb9ac;&#xc988;"/>
</node>
<node CREATED="1570204589696" ID="ID_1541112293" MODIFIED="1570383141456" TEXT="create_date(&#xcc3d;&#xc791; &#xb0a0;&#xc9dc;)"/>
<node CREATED="1570204599225" ID="ID_267976604" LINK="#ID_1303840061" MODIFIED="1571689167689" TEXT="create_end_date(&#xb05d;&#xb098;&#xb294;&#xb0a0;&#xc9dc;)"/>
</node>
<node COLOR="#3333ff" CREATED="1570189805747" FOLDED="true" ID="ID_905974177" MODIFIED="1572267926420" POSITION="right" STYLE="bubble" TEXT="worksSave">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570202031109" ID="ID_1751658578" MODIFIED="1570384084497" STYLE="bubble" TEXT="work_save_id(&#xc800;&#xc791;&#xbb3c; &#xc800;&#xc7a5; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570202043219" ID="ID_1673328208" MODIFIED="1570202230169" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1572228021805" ID="ID_1699197814" MODIFIED="1572228075304" TEXT="save_date(&#xc800;&#xc791;&#xbb3c; &#xc800;&#xc7a5; &#xb0a0;&#xc9dc;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570202179452" ID="ID_1958614296" MODIFIED="1570202230359" TEXT="wroks_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1572228403150" FOLDED="true" ID="ID_1859576168" MODIFIED="1573382438539" POSITION="right" STYLE="bubble" TEXT="ArtistSave">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1572228436711" ID="ID_1425913919" MODIFIED="1572228448607" STYLE="bubble" TEXT="artist_save_id(&#xc800;&#xc791;&#xc790; &#xc800;&#xc7a5; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1572228467670" ID="ID_921995810" MODIFIED="1572228521917" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1572228476173" ID="ID_770857544" MODIFIED="1572228522389" TEXT="save_date(&#xc800;&#xc791;&#xc790; &#xc800;&#xc7a5; &#xb0a0;&#xc9dc;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1572228627109" ID="ID_234377302" MODIFIED="1572228633723" TEXT="artist_id(&#xc800;&#xc791;&#xc790; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1570204025839" ID="ID_573508692" MODIFIED="1574437249384" POSITION="right" STYLE="bubble" TEXT="create_art">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570204029935" ID="ID_17484764" MODIFIED="1570383141455" STYLE="bubble" TEXT="create_id(&#xcc3d;&#xc791; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570204201855" ID="ID_123670423" MODIFIED="1570386707668" TEXT="artist_id(&#xc800;&#xc791;&#xc790; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_123670423" ENDARROW="Default" ENDINCLINATION="111;0;" ID="Arrow_ID_630873394" SOURCE="ID_1040338839" STARTARROW="None" STARTINCLINATION="111;0;"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570204391928" ID="ID_1491470580" MODIFIED="1570383141456" TEXT="works_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1572313979378" ID="ID_529617255" MODIFIED="1572313986685" TEXT="save_date(&#xc800;&#xc7a5; &#xb0a0;&#xc9dc;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1573127407293" ID="ID_1695517315" MODIFIED="1573128845983" TEXT="artist_rank(&#xc800;&#xc791;&#xc790; &#xb300;&#xd45c;&#xc131;,&#xc800;&#xc791;&#xc790;&#xac00; &#xbcf5;&#xc218;&#xc77c; &#xacbd;&#xc6b0; &#xadf8; &#xc911;&#xc5d0; &#xb300;&#xd45c;&#xc131;&#xc744; &#xb760;&#xb294; &#xc2e0;&#xd638;, &#xd639;&#xc740; &#xc815;&#xb82c; &#xac12; , &#xc815;&#xb82c;&#xc740; &#xb2f9;&#xc5f0;&#xd788; &#xc624;&#xb984;&#xcc28;&#xc21c;)">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570190492325" FOLDED="true" ID="ID_180165791" MODIFIED="1573385027961" POSITION="right" STYLE="bubble" TEXT="artist">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570202714101" ID="ID_1040338839" MODIFIED="1570386707668" STYLE="bubble" TEXT="artist_id(&#xc800;&#xc791;&#xc790; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_123670423" ENDARROW="Default" ENDINCLINATION="111;0;" ID="Arrow_ID_630873394" STARTARROW="None" STARTINCLINATION="111;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570203193262" ID="ID_1400303485" MODIFIED="1570383206884" TEXT="art_name(&#xc774;&#xb984;)"/>
<node COLOR="#000000" CREATED="1570203215581" ID="ID_502686680" MODIFIED="1570383206884" TEXT="user_id(&#xc720;&#xc800;&#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node CREATED="1572217815272" ID="ID_437595392" MODIFIED="1572217835265" TEXT="add_date(&#xc800;&#xc791;&#xc790; &#xb4f1;&#xb85d; &#xb0a0;&#xc9dc;)"/>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_742411747" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570388147262" ID="ID_1945098226" MODIFIED="1570388148242" TEXT="create"/>
<node CREATED="1572228653765" ID="ID_561066033" MODIFIED="1572228657489" TEXT="ArtistSave"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570636847747" FOLDED="true" ID="ID_940368837" MODIFIED="1572267926421" POSITION="right" STYLE="bubble" TEXT="type1">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570637736653" ID="ID_568525617" MODIFIED="1570638609638" STYLE="bubble" TEXT="type1_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570637889427" ID="ID_437808232" MODIFIED="1570643961113" TEXT="type1_name"/>
<node COLOR="#6666ff" CREATED="1570639830428" ID="ID_6694740" MODIFIED="1570643262542" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570639835154" ID="ID_831783520" MODIFIED="1570643262541" TEXT="type2"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570637661306" FOLDED="true" ID="ID_1369038251" MODIFIED="1572267926421" POSITION="right" STYLE="bubble" TEXT="type2">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570637967380" ID="ID_141047140" MODIFIED="1570638608966" STYLE="bubble" TEXT="type2_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570638595267" ID="ID_88902455" MODIFIED="1570640172351" TEXT="type1_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
<node CREATED="1570638599114" ID="ID_1349135083" MODIFIED="1570638606326" TEXT="type2_name"/>
<node COLOR="#6666ff" CREATED="1570639879060" ID="ID_1072304621" MODIFIED="1570639957838" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="Dialog" SIZE="18"/>
<node CREATED="1570639882244" ID="ID_934001659" MODIFIED="1570639957838" TEXT="works"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570640298452" FOLDED="true" ID="ID_1928030582" MODIFIED="1571255240049" POSITION="right" STYLE="bubble" TEXT="fileSave">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570640324173" ID="ID_1971154851" MODIFIED="1570640387566" STYLE="bubble" TEXT="file_id(&#xd30c;&#xc77c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570640496459" ID="ID_1858177930" MODIFIED="1570640902935" TEXT="file_name(&#xc2e4;&#xc81c;&#xd30c;&#xc77c;&#xc774;&#xb984;)"/>
<node CREATED="1570640547331" ID="ID_69436593" MODIFIED="1570640720599" TEXT="file_path(&#xc2e4;&#xc81c;&#xd30c;&#xc77c;&#xacbd;&#xb85c;)"/>
<node CREATED="1570640614844" ID="ID_1008917784" MODIFIED="1570640928207" TEXT="save_file_name(&#xc800;&#xc7a5;&#xd30c;&#xc77c;&#xc774;&#xb984;)"/>
<node CREATED="1570640928483" ID="ID_1493012707" MODIFIED="1570640934463" TEXT="save_file_path(&#xc800;&#xc7a5;&#xd30c;&#xc77c;&#xacbd;&#xb85c;)"/>
<node CREATED="1570643433756" ID="ID_1091085937" MODIFIED="1570643444625" TEXT="file_type(&#xd30c;&#xc77c;&#xd0c0;&#xc785;)"/>
<node COLOR="#000000" CREATED="1570200683673" ID="ID_568478641" MODIFIED="1570643417299" TEXT="work_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="Dialog" SIZE="18"/>
</node>
</node>
<node CREATED="1570202278275" FOLDED="true" ID="ID_370048716" MODIFIED="1574065269866" POSITION="right" TEXT="&#xc815;&#xcc45;">
<node CREATED="1570195985846" FOLDED="true" ID="ID_949132852" MODIFIED="1573385031854" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1">
<node CREATED="1570195992918" ID="ID_1704575025" MODIFIED="1570198529448" TEXT="&#xbcf4;&#xb294; &#xac83;"/>
<node CREATED="1570198520483" ID="ID_1672519645" MODIFIED="1570198528024" TEXT="&#xb4e0;&#xb294; &#xac83;"/>
<node CREATED="1570198524340" ID="ID_382114831" MODIFIED="1570198525192" TEXT="&#xd558;&#xb294; &#xac83;">
<node CREATED="1571249891804" ID="ID_359155350" MODIFIED="1571249899186" TEXT="GAME"/>
<node CREATED="1571249899496" ID="ID_1986179586" MODIFIED="1571249907281" TEXT="UTILITY"/>
<node CREATED="1571250086128" ID="ID_259385037" MODIFIED="1571250088553" TEXT="EXAMINE"/>
</node>
</node>
<node CREATED="1570198530956" FOLDED="true" ID="ID_183244509" MODIFIED="1573385031854" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2">
<node CREATED="1570198535412" ID="ID_789841412" MODIFIED="1570198538879" TEXT="EPISODE"/>
<node CREATED="1570199125069" ID="ID_1347624261" MODIFIED="1570199130057" TEXT="GAME"/>
<node CREATED="1570199130365" ID="ID_1401066273" MODIFIED="1570199132594" TEXT="&#xc544;&#xb9c8; &#xc878;&#xb77c; &#xb9ce;&#xc744;&#xb4ef;"/>
</node>
<node CREATED="1570202302972" ID="ID_1097680040" MODIFIED="1570202320576" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xc0c8;&#xb85c; &#xb4f1;&#xb85d;&#xd558;&#xb294;&#xac74; &#xc720;&#xc800;&#xc758; &#xbaab;&#xc774;&#xb2e4;. "/>
<node CREATED="1570202420053" ID="ID_1376576235" MODIFIED="1570202656096" TEXT="&#xc77c;&#xb2e8; &#xc800;&#xc7a5;&#xb41c; &#xc800;&#xc791;&#xbb3c;&#xc740; &#xc800;&#xc7a5;&#xd55c; &#xc720;&#xc800; &#xb9d0;&#xace0;&#xb294; &#xb2e4;&#xc2dc; &#xd3b8;&#xc9d1;&#xd558;&#xc9c0; &#xbabb;&#xd55c;&#xb2e4;. &#xc989; &#xb77d;&#xc5d0; &#xac78;&#xb9b0;&#xb2e4;."/>
<node CREATED="1570202442756" ID="ID_1715444064" MODIFIED="1570202669096" TEXT="&#xad00;&#xb9ac;&#xc790;&#xb294; &#xd3b8;&#xc9d1; &#xb77d;&#xc744; &#xd480;&#xac70;&#xb098; &#xb2e4;&#xc2dc;&#xb77d;&#xc5d0; &#xb123;&#xc744; &#xc218; &#xc788;&#xb2e4;."/>
<node CREATED="1570203238350" ID="ID_266195234" MODIFIED="1570203271218" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xb4f1;&#xb85d;&#xd558;&#xb294; &#xacfc;&#xc815; &#xb610;&#xd55c; &#xc800;&#xc791;&#xbb3c; &#xc785;&#xb825;--&gt; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d; &#xacfc;&#xc815;&#xc774;&#xb2e4;."/>
<node CREATED="1570203271526" ID="ID_849018134" MODIFIED="1570203318905" TEXT="&#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d; &#xacfc;&#xc815;&#xc740; &#xae30;&#xc874;&#xc5d0; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8;&#xb97c; &#xac80;&#xc0c9;&#xd558;&#xc5ec; &#xcc3e;&#xace0; &#xc5c6;&#xc73c;&#xba74; &#xc0c8;&#xb85c; &#xb4f1;&#xb85d;&#xd558;&#xb294; &#xac83;&#xc73c;&#xb85c; &#xc774;&#xac83; &#xb610;&#xd55c; &#xcc98;&#xc74c; &#xb4f1;&#xb85d;&#xd558;&#xba74; &#xb77d;&#xc5d0; &#xac78;&#xb9ac;&#xace0; &#xad00;&#xb9ac;&#xc790;&#xac00; &#xd3b8;&#xc9d1;&#xb77d;&#xc744; &#xd480;&#xac70;&#xb098; &#xb2e4;&#xc2dc;&#xb77d;&#xc5d0; &#xb123;&#xc744; &#xc218; &#xc788;&#xb2e4;."/>
<node CREATED="1570204623760" ID="ID_1303840061" MODIFIED="1571689104632" TEXT="&#xb05d;&#xb098;&#xb294; &#xb0a0;&#xc9dc;&#xb294; &#xc5d0;&#xd53c;&#xc18c;&#xb4dc; &#xb4f1; &#xd544;&#xc694;&#xd55c; &#xac83;(&#xc800;&#xc791;&#xbb3c;&#xc5d0; &#xc0c1;&#xc18d;&#xb418;&#xb294; &#xac83;&#xc73c;&#xb85c; &#xbcc0;&#xacbd;)"/>
<node COLOR="#3333ff" CREATED="1571687115406" ID="ID_1541499368" MODIFIED="1572682779389" STYLE="bubble" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xc785;&#xb825;&#xd560; &#xc2dc;&#xc5d0; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8;&#xac00; &#xc5c6;&#xc73c;&#xba74; &#xcc3d;&#xc791;&#xb0a0;&#xc9dc;&#xb97c; &#xc785;&#xb825;&#xd558;&#xc9c0; &#xbabb;&#xd568;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1571688779596" FOLDED="true" ID="ID_612527941" MODIFIED="1573385031854" STYLE="bubble" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc774; &#xc2dc;&#xb9ac;&#xc988;&#xc77c; &#xacbd;&#xc6b0; &#xc644;&#xacb0;&#xb0a0;&#xc9dc;&#xb97c; &#xc785;&#xb825;&#xd560; &#xc218; &#xc788;&#xc74c;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1571689002134" ID="ID_1276612961" MODIFIED="1572682785508" TEXT="&#xc2dc;&#xb9ac;&#xc988;&#xc5d0; &#xb300;&#xd55c; &#xc815;&#xbcf4;&#xb294; &#xc800;&#xc791;&#xbb3c;&#xc774; &#xc800;&#xc7a5;"/>
<node CREATED="1571689014163" ID="ID_1959164045" MODIFIED="1572682785508" TEXT="0&#xc774;&#xba74; &#xc2dc;&#xb9ac;&#xc988; &#xc5c6;&#xc74c;"/>
<node CREATED="1571689016588" ID="ID_196791343" MODIFIED="1572682785509" TEXT="1&#xc774;&#xba74; &#xc2dc;&#xb9ac;&#xc988; &#xc788;&#xc74c;"/>
</node>
<node COLOR="#3333ff" CREATED="1571687325673" FOLDED="true" ID="ID_1320187447" MODIFIED="1573385031854" STYLE="bubble" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc81c;&#xbaa9;&#xc5d0; &#xb300;&#xd55c; &#xc911;&#xbcf5;&#xccb4;&#xd06c; &#xacfc;&#xc815; &#xac80;&#xc0c9;&#xd558;&#xb294; &#xacfc;&#xc815;&#xc774; &#xd544;&#xc218;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1571688772364" ID="ID_409332850" MODIFIED="1571688773423" TEXT="&#xcd94;&#xd6c4;&#xc5d0;"/>
<node COLOR="#3333ff" CREATED="1572682887729" ID="ID_654937225" MODIFIED="1572682891564" STYLE="bubble" TEXT="&#xc644;&#xb8cc;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1572682935639" FOLDED="true" ID="ID_1100460845" MODIFIED="1573385031854" TEXT="&#xba54;&#xb274;&#xc5d0; &#xb300;&#xd574;&#xc11c; &#xacb0;&#xc815;&#xc744; &#xd574;&#xc57c; &#xd560;&#xb4ef; &#xd558;&#xb2e4;.">
<node CREATED="1572682943937" ID="ID_311663986" MODIFIED="1572683230532" TEXT="&#xd604;&#xc7ac; &#xb4f1;&#xb85d;&#xb41c; &#xba54;&#xb274;&#xb294; &#xb2e4;&#xc74c;&#xacfc; &#xac19;&#xb2e4;.">
<node CREATED="1572683243654" ID="ID_1414013775" MODIFIED="1572683244297" TEXT="&#xd648;"/>
<node CREATED="1572683249416" ID="ID_106687316" MODIFIED="1572683251821" TEXT="&#xcf54;&#xba58;&#xd2b8; &#xb4f1;&#xb85d;"/>
<node CREATED="1572683231720" ID="ID_1103776602" MODIFIED="1572683235484" TEXT="&#xb4f1;&#xb85d;">
<node CREATED="1572683385357" ID="ID_524422419" MODIFIED="1572683387329" TEXT="&#xc800;&#xc791;&#xbb3c; &#xb4f1;&#xb85d;"/>
<node CREATED="1572683387496" ID="ID_845870724" MODIFIED="1572683389313" TEXT="&#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d;"/>
</node>
<node CREATED="1572683255613" ID="ID_1534819709" MODIFIED="1572683263845" TEXT="&#xcf54;&#xba58;&#xd2b8;">
<node CREATED="1572683379223" ID="ID_1193589815" MODIFIED="1572683382258" TEXT="&#xbcf4;&#xb294;&#xac83;"/>
<node CREATED="1572683380285" ID="ID_1729131802" MODIFIED="1572683383848" TEXT="&#xb4e3;&#xb294;&#xac83;"/>
<node CREATED="1572683377876" ID="ID_816887180" MODIFIED="1572683379030" TEXT="&#xd558;&#xb294;&#xac83;"/>
</node>
</node>
<node CREATED="1572683353340" ID="ID_1643258311" MODIFIED="1572683356983" TEXT="&#xc774;&#xac78; &#xc880; &#xbcc0;&#xacbd;&#xd574;&#xc57c; &#xd560;&#xb4ef; &#xd558;&#xb2e4;.">
<node CREATED="1572683364469" ID="ID_603702855" MODIFIED="1572683373763" TEXT="&#xc800;&#xc791;&#xbb3c;">
<node CREATED="1572683392580" ID="ID_1689714235" MODIFIED="1572683399143" TEXT="&#xcc3e;&#xae30;"/>
<node CREATED="1572683402286" ID="ID_1270615192" MODIFIED="1572683403046" TEXT="&#xb4f1;&#xb85d;"/>
</node>
<node CREATED="1572683609064" ID="ID_456604432" MODIFIED="1572683611174" TEXT="&#xc800;&#xc791;&#xc790;">
<node CREATED="1572683612042" ID="ID_1745068159" MODIFIED="1572683612775" TEXT="&#xcc3e;&#xae30;"/>
<node CREATED="1572683612951" ID="ID_1970978469" MODIFIED="1572683613561" TEXT="&#xb4f1;&#xb85d;"/>
</node>
<node CREATED="1572683614265" ID="ID_259901040" MODIFIED="1572683622857" TEXT="&#xcf54;&#xba58;&#xd2b8;">
<node CREATED="1572683626778" ID="ID_1788640145" MODIFIED="1572683632368" TEXT="&#xbcf4;&#xb294;&#xac83;"/>
<node CREATED="1572683632546" ID="ID_1502967636" MODIFIED="1572683635386" TEXT="&#xb4e3;&#xb294;&#xac83;"/>
<node CREATED="1572683635578" ID="ID_1474527459" MODIFIED="1572683636345" TEXT="&#xd558;&#xb294;&#xac83;"/>
<node CREATED="1572683637523" ID="ID_1747909390" MODIFIED="1572683638335" TEXT="&#xb4f1;&#xb85d;"/>
</node>
<node CREATED="1572683643406" ID="ID_416792462" MODIFIED="1572683649290" TEXT="&#xd648;&#xc740; &#xadf8;&#xb0e5; &#xc81c;&#xbaa9; &#xc785;&#xb825;&#xd558;&#xb294; &#xac83;&#xc73c;&#xb85c;"/>
</node>
</node>
<node CREATED="1572750559941" FOLDED="true" ID="ID_1220900993" MODIFIED="1573385031854" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc774; &#xb9cc;&#xc57d; &#xc911;&#xbcf5;&#xb41c; &#xc800;&#xc791;&#xbb3c;&#xc774;&#xb098; &#xc633;&#xc9c0; &#xc54a;&#xc740; &#xc800;&#xc791;&#xc790;&#xac00; &#xb4f1;&#xb85d;&#xb418;&#xc5b4;&#xc9c4; &#xc62c;&#xbc14;&#xb978; &#xc800;&#xc791;&#xbb3c;&#xc774;&#xb77c;&#xace0; &#xd558;&#xb354;&#xb77c;&#xb3c4; &#xc0ac;&#xc6a9;&#xc790;&#xb294; &#xd3c9;&#xac00;&#xb97c; &#xb4f1;&#xb85d;&#xd560; &#xc218; &#xc788;&#xb2e4;.">
<node CREATED="1572750691172" ID="ID_812662757" MODIFIED="1572750706234" TEXT="&#xcd94;&#xd6c4;&#xc5d0; &#xc81c;&#xc548;&#xc73c;&#xb974; &#xbc1b;&#xc744; &#xc2dc;&#xc5d0; &#xadf8;&#xc5d0; &#xb300;&#xd55c; &#xad50;&#xd1b5;&#xc815;&#xb9ac;&#xb97c; &#xad00;&#xb9ac;&#xc790;&#xac00; &#xd55c;&#xb2e4;."/>
</node>
<node CREATED="1572750710321" ID="ID_708396617" MODIFIED="1572750738546" TEXT="&#xace0;&#xb85c; &#xc81c;&#xc548; &#xae30;&#xb2a5;&#xc774; &#xd544;&#xc694;&#xd558;&#xace0;, &#xd574;&#xb2f9;&#xd558;&#xb294; &#xc11c;&#xbe44;&#xc2a4;&#xb97c; &#xc6b4;&#xc601;&#xd560; &#xad00;&#xb9ac;&#xc790; &#xd398;&#xc774;&#xc9c0; &#xb610;&#xd55c; &#xd544;&#xc694;&#xd558;&#xb2e4;."/>
</node>
<node CREATED="1572683665499" FOLDED="true" ID="ID_1925445576" MODIFIED="1573387247742" POSITION="right" TEXT="&#xc791;&#xc5c5;">
<node CREATED="1572683729443" ID="ID_1912108041" MODIFIED="1572683731983" TEXT="&#xb4f1;&#xb85d;&#xacfc;&#xc815;">
<node CREATED="1572683749217" ID="ID_999389353" MODIFIED="1572683973683" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc800;&#xc791;&#xc790; &#xb4f1;&#xb85d;&#xacfc;&#xc815;(70%)">
<node CREATED="1572683667032" ID="ID_1096698159" MODIFIED="1572683682965" TEXT="&#xd604;&#xc7ac; &#xc800;&#xc791;&#xbb3c; &#xb4f1;&#xb85d; &#xc800;&#xc791;&#xc790; &#xb4f1;&#xb85d; &#xacfc;&#xc815;&#xc744; &#xb05d;&#xb0c8;&#xb2e4;."/>
<node CREATED="1572683683180" ID="ID_907922054" MODIFIED="1572683712623" TEXT="&#xadf8;&#xb7ec;&#xb098; &#xc800;&#xc791;&#xbb3c; &#xb4f1;&#xb85d;&#xacfc;&#xc815;&#xacfc; &#xc800;&#xc791;&#xc790; &#xb4f1;&#xb85d;&#xacfc;&#xc815; &#xc911;&#xc5d0;&#xc11c; &#xc0c1;&#xc138; &#xbcf4;&#xae30;&#xc5d0; &#xad00;&#xb828;&#xb41c; &#xb0b4;&#xc6a9;&#xc5d0; &#xb300;&#xd574;&#xc11c; &#xacf5;&#xd1b5;&#xc801;&#xc73c;&#xb85c; &#xc791;&#xc5c5;&#xc774; &#xb4e4;&#xc5b4;&#xac00;&#xc57c;&#xd558;&#xb294; &#xbd80;&#xbd84;&#xc774; &#xc874;&#xc7ac;&#xd55c;&#xb2e4;."/>
<node CREATED="1572683713224" ID="ID_44621103" MODIFIED="1572683999309" TEXT="&#xc774;&#xb7ec;&#xd55c; &#xc800;&#xc791;&#xbb3c; &#xc0c1;&#xc138;&#xbcf4;&#xae30; &#xc800;&#xc791;&#xc790; &#xc0c1;&#xc138;&#xbcf4;&#xae30;&#xac00; &#xc774;&#xb904;&#xc9c4;&#xb2f4;&#xc5d0; &#xd558;&#xb294;&#xac8c; &#xc88b;&#xaca0;&#xb2e4;&#xb77c;&#xb294; &#xc0dd;&#xac01;&#xc774; &#xb4e0;&#xb2e4;.">
<font NAME="SansSerif" SIZE="12"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1572684006800" FOLDED="true" ID="ID_507856596" MODIFIED="1573214915948" STYLE="bubble" TEXT="&#xcf54;&#xba58;&#xd2b8; &#xb4f1;&#xb85d;&#xacfc;&#xc815;(70%)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1572684012955" ID="ID_1202720286" MODIFIED="1573214912673" TEXT="&#xd574;&#xb2f9; &#xc800;&#xc791;&#xbb3c;&#xacfc; &#xc800;&#xc791;&#xc790; &#xae30;&#xbc18;&#xc5d0; &#xc758;&#xd55c; &#xcf54;&#xba58;&#xd2b8; &#xb4f1;&#xb85d;&#xacfc;&#xc815;&#xc774;&#xb2e4;.">
<node CREATED="1572780966580" ID="ID_1879708560" MODIFIED="1573214912673" TEXT="&#xd3c9;&#xac00; &#xd654;&#xc0b4;&#xd45c;&#xc5d0; &#xb300;&#xd55c; &#xd655;&#xb300;">
<node CREATED="1572780989640" ID="ID_492378159" MODIFIED="1573214912673" TEXT="6&#xac01;&#xd615; ">
<node CREATED="1572782575448" ID="ID_1228207623" MODIFIED="1573214912673" TEXT="active &#xae30;&#xc900;">
<node CREATED="1572781049584" ID="ID_742388984" MODIFIED="1573214912673" TEXT="&#xac00;&#xb85c; 62"/>
<node CREATED="1572781051946" ID="ID_311530093" MODIFIED="1573214912673" TEXT="&#xb192;&#xc774; 110"/>
</node>
<node CREATED="1572782580997" ID="ID_1893598473" MODIFIED="1573214912673" TEXT="&#xc77c;&#xbc18;"/>
</node>
<node CREATED="1572782584080" ID="ID_601197140" MODIFIED="1573214912673" TEXT="&#xc0bc;&#xac01;&#xd615;">
<node CREATED="1572782590172" ID="ID_555711687" MODIFIED="1573214912673" TEXT="active&#xae30;&#xc900;">
<node CREATED="1572782653216" ID="ID_115574661" MODIFIED="1573214912673" TEXT="&#xac00;&#xb85c; 49"/>
<node CREATED="1572782657227" ID="ID_314627884" MODIFIED="1573214912673" TEXT="&#xb192;&#xc774; 110"/>
</node>
</node>
</node>
</node>
</node>
</node>
<node COLOR="#3333ff" CREATED="1572684082393" ID="ID_804649923" MODIFIED="1572684387827" STYLE="bubble" TEXT="&#xba54;&#xb274;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1572684389449" ID="ID_1885102342" MODIFIED="1572684422218" TEXT="&#xae30;&#xc874;&#xc758; &#xd5c8;&#xc811;&#xd55c; &#xba54;&#xb274;&#xb97c; &#xb72f;&#xc5b4;&#xace0;&#xce58;&#xace0; &#xcf54;&#xba58;&#xd2b8;&#xac00; &#xb4f1;&#xb85d;&#xb418;&#xb294; &#xc989;&#xc2dc; &#xb098;&#xb984;&#xb300;&#xb85c; &#xc774;&#xc6a9;&#xac00;&#xb2a5;&#xd55c; &#xd648; &#xae4c;&#xc9c0; &#xb9cc;&#xb4e4;&#xc5c8;&#xc73c;&#xba74; &#xd55c;&#xb2e4;."/>
<node CREATED="1572684511240" ID="ID_715149000" LINK="#ID_1643258311" MODIFIED="1572684527948" TEXT="&#xd574;&#xb2f9; &#xba54;&#xb274; &#xbc29;&#xd5a5;&#xc131;&#xc740; &#xc774;&#xcabd;&#xc5d0; &#xc788;&#xc73c;&#xb2c8; &#xcc38;&#xc870;"/>
<node COLOR="#3333ff" CREATED="1572747365952" ID="ID_182990162" MODIFIED="1572747371899" STYLE="bubble" TEXT="&#xc77c;&#xb2e8; &#xc644;&#xb8cc;(80%)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
</node>
<node CREATED="1572684093475" ID="ID_335931784" MODIFIED="1572684094282" TEXT="&#xb85c;&#xadf8;&#xc778;">
<node CREATED="1572684248469" ID="ID_680068764" MODIFIED="1572684252817" TEXT="&#xc9c4;&#xd589;&#xc0c1;&#xd669;(60%)">
<node CREATED="1572684296554" ID="ID_1669430173" MODIFIED="1572684300762" TEXT="SNS &#xb85c;&#xadf8;&#xc778; &#xacfc;&#xc815;&#xc774; &#xd544;&#xc694;&#xd558;&#xb2e4;"/>
</node>
</node>
<node CREATED="1572684097008" ID="ID_1594265224" MODIFIED="1572684098024" TEXT="&#xb9c8;&#xc774;&#xd398;&#xc774;&#xc9c0;">
<node CREATED="1572684306796" ID="ID_424651223" MODIFIED="1572684316051" TEXT="&#xac00;&#xc7a5; &#xb9c8;&#xc9c0;&#xb9c9;&#xc5d0; &#xc9c4;&#xd589;&#xd574;&#xc57c; &#xd560; &#xc0c1;&#xd669;&#xc774;&#xba70;"/>
<node CREATED="1572684316235" ID="ID_158849602" MODIFIED="1572684374318" TEXT="&#xc790;&#xc2e0;&#xc774; &#xb4f1;&#xb85d;&#xd55c; &#xc800;&#xc791;&#xbb3c; &#xc800;&#xc791;&#xc790;&#xc5d0; &#xb300;&#xd55c; &#xc0ad;&#xc81c; &#xae30;&#xb2a5;&#xacfc; &#xb77d; &#xae30;&#xb2a5;&#xc774; &#xd544;&#xc694;&#xd55c; &#xd398;&#xc774;&#xc9c0;&#xc774;&#xb2e4;."/>
</node>
<node COLOR="#3333ff" CREATED="1573125337417" ID="ID_168333488" MODIFIED="1573382599887" STYLE="bubble" TEXT="&#xd544;&#xc694;&#xd55c;&#xac83;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1573125341488" ID="ID_496707441" MODIFIED="1573382600532" STYLE="bubble" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xbd88;&#xb7ec;&#xc62c; &#xb54c; &#xc800;&#xc791;&#xc790;&#xac00; &#xb2e4;&#xc218;&#xc778; &#xacbd;&#xc6b0;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1573125356793" ID="ID_560589935" MODIFIED="1573382601455" STYLE="bubble" TEXT="&#xc800;&#xc791;&#xc790;&#xc5d0; &#xb300;&#xd55c; rank&#xac00; &#xc8fc;&#xc5b4;&#xc838;&#xc11c; &#xb300;&#xd45c; &#xc800;&#xc791;&#xc790; &#xd55c;&#xba85;&#xc774; &#xbcf4;&#xc5ec;&#xc8fc;&#xb3c4;&#xb85d; &#xba85;&#xd655;&#xd788; &#xd574;&#xc57c;&#xd568;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#3333ff" CREATED="1573125792962" ID="ID_1118060146" MODIFIED="1573382601628" STYLE="bubble" TEXT="&#xadf8;&#xb807;&#xc9c0; &#xc54a;&#xc73c;&#xba74; &#xc560;&#xcd08;&#xc5d0; &#xc800;&#xc791;&#xc790; &#xc778;&#xaca9;&#xad8c; &#xbcf4;&#xd638; &#xcd94;&#xc9c0;&#xac00; &#xbb34;&#xc0c9;&#xd574;&#xc9c8; &#xc218; &#xc788;&#xc74c;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1573382707604" ID="ID_455161691" MODIFIED="1573382716484" TEXT="EvalService 84"/>
<node CREATED="1573382733050" ID="ID_967476585" MODIFIED="1573382747573" TEXT="DynamicQuery 324 but can change ">
<node CREATED="1573382754545" MODIFIED="1573382754545" TEXT="searchWorksDynamic"/>
</node>
</node>
</node>
</node>
<node CREATED="1570384541341" FOLDED="true" ID="ID_299164639" MODIFIED="1573387248583" POSITION="right" TEXT="&#xad6c;&#xd604;&#xd574;&#xc57c; &#xd560;&#xac83;">
<node CREATED="1570384548494" ID="ID_935541164" MODIFIED="1570384567928" TEXT="&#xc77c;&#xbc18; &#xc720;&#xc800;&#xac00; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8;&#xac00; &#xb418;&#xc5b4;&#xc57c; &#xd568;. &#xadf8;&#xac70; &#xc2e0;&#xccad;&#xd558;&#xb294; &#xac83;&#xacfc; &#xc2e0;&#xccad;&#xc5d0; &#xb300;&#xd55c; &#xcee4;&#xbc0b;"/>
</node>
<node CREATED="1570478831830" FOLDED="true" ID="ID_1826492402" MODIFIED="1573387249319" POSITION="right" TEXT="&#xba54;&#xb274;">
<node CREATED="1570478845760" ID="ID_979006335" MODIFIED="1570478858554" TEXT="&#xcf54;&#xba58;&#xd2b8;&#xb4f1;&#xb85d;"/>
<node CREATED="1570478849655" ID="ID_246546064" MODIFIED="1570478856266" TEXT="&#xcf54;&#xba58;&#xd2b8;"/>
</node>
<node CREATED="1570479014767" FOLDED="true" ID="ID_1407586755" MODIFIED="1574065269866" POSITION="right" TEXT="&#xd654;&#xba74;">
<node COLOR="#3333ff" CREATED="1570479017584" FOLDED="true" ID="ID_304721571" MODIFIED="1573216364197" STYLE="bubble" TEXT="&#xd648;">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node CREATED="1570479501257" ID="ID_728144458" MODIFIED="1570650437522" TEXT="&#xd654;&#xba74;&#xc124;&#xacc4;(&#xc774;&#xbbf8;&#xc9c0;)">
<node CREATED="1570479598167" ID="ID_619179529" MODIFIED="1570650437522">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#xd3c9;&#xac00;Test_ERD_8900160936833913156.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1570650084112" FOLDED="true" ID="ID_1995661712" MODIFIED="1573216362971" TEXT="&#xd68c;&#xc6d0;&#xac00;&#xc785;(&#xc774;&#xbbf8;&#xc9c0;)">
<node CREATED="1570650422773" ID="ID_1004681261" MODIFIED="1570650422773">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#xd3c9;&#xac00;Test_ERD_4977960637654275460.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1571094640250" ID="ID_477525642" MODIFIED="1571094642437" TEXT="&#xb85c;&#xadf8;&#xc778;(&#xc774;&#xbbf8;&#xc9c0;)"/>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570650440176" ID="ID_679791530" MODIFIED="1570650463374" STYLE="bubble" TEXT="&#xd68c;&#xc6d0;&#xac00;&#xc785;&#xc2dc;&#xc5d0; email check&#xb294; sns &#xb85c;&#xadf8;&#xc778; &#xac1c;&#xbc1c;&#xd560;&#xb54c; &#xac19;&#xc774; &#xd558;&#xb294; &#xac83;&#xc73c;&#xb85c;">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
</node>
<node CREATED="1570636251126" FOLDED="true" ID="ID_1176679536" MODIFIED="1573216367394" TEXT="&#xc800;&#xc791;&#xbb3c; &#xb4f1;&#xb85d;(&#xc774;&#xbbf8;&#xc9c0;)">
<node CREATED="1570650020220" ID="ID_240602639" MODIFIED="1570650020220">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#xd3c9;&#xac00;Test_ERD_2268621821554902320.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1571094614934" ID="ID_1278123310" MODIFIED="1571094618349" TEXT="&#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d;(&#xc774;&#xbbf8;&#xc9c0;)"/>
<node CREATED="1570479023509" FOLDED="true" ID="ID_213136224" MODIFIED="1573224512880" TEXT="&#xcf54;&#xba58;&#xd2b8;&#xb4f1;&#xb85d;">
<node CREATED="1572751121931" ID="ID_612306918" MODIFIED="1572751121931">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#xd3c9;&#xac00;Test_ERD_5858090375333852333.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1573224515165" ID="ID_1315519905" MODIFIED="1573298289502" TEXT="&#xc800;&#xc791;&#xbb3c; &#xcc3e;&#xae30;(&#xc774;&#xbbf8;&#xc9c0;)">
<node CREATED="1573224519209" ID="ID_345735914" MODIFIED="1573224519209">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#xd3c9;&#xac00;Test_ERD_3454111675449972775.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1570479026310" ID="ID_240643526" MODIFIED="1570479027186" TEXT="&#xcf54;&#xba58;&#xd2b8;"/>
</node>
<node CREATED="1570481801312" FOLDED="true" ID="ID_1008996283" MODIFIED="1572877299736" POSITION="right" TEXT="bootStrap&#xc5d0;&#xc11c; &#xbbf8;&#xb514;&#xc5b4; &#xcffc;&#xb9ac;">
<node CREATED="1570481842009" ID="ID_1378046496" MODIFIED="1570481851699" TEXT="992 &#xc774;&#xd558;&#xbd80;&#xd130; &#xb2ec;&#xb77c;&#xc9c0;&#xb294;&#xac83;&#xc73c;&#xb85c; &#xbcf4;&#xc778;&#xb2e4;."/>
</node>
</node>
</map>

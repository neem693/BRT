<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1570188500128" ID="ID_910731083" MODIFIED="1571087024976" TEXT="&#xd3c9;&#xac00;ERD">
<hook NAME="accessories/plugins/CreationModificationPlugin_new.properties"/>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189045410" FOLDED="true" ID="ID_1991772313" MODIFIED="1570668699620" POSITION="right" STYLE="bubble" TEXT="eva_user">
<cloud/>
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
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
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_779080087" MODIFIED="1570388019242" TEXT="evaluate"/>
<node CREATED="1570388026639" ID="ID_654106225" MODIFIED="1570388030410" TEXT="worksSave"/>
<node CREATED="1570388036622" ID="ID_1258532452" MODIFIED="1570388037763" TEXT="artist">
<node CREATED="1570388039807" ID="ID_221775553" MODIFIED="1570388042442" TEXT="OneToOne"/>
</node>
</node>
</node>
<node COLOR="#3333ff" CREATED="1570189123466" FOLDED="true" ID="ID_823115216" MODIFIED="1570668699622" POSITION="right" STYLE="bubble" TEXT="evaluate">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570201625524" ID="ID_49493969" MODIFIED="1570383117272" STYLE="bubble" TEXT="eval_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570201636571" ID="ID_516525150" MODIFIED="1570383117272" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_516525150" ENDARROW="Default" ENDINCLINATION="152;0;" ID="Arrow_ID_1936111345" SOURCE="ID_1878136139" STARTARROW="None" STARTINCLINATION="152;0;"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570201644098" ID="ID_1932256498" MODIFIED="1570383117273" TEXT="eval_item_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xd15c; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1932256498" ENDARROW="Default" ENDINCLINATION="95;0;" ID="Arrow_ID_54834023" SOURCE="ID_893901578" STARTARROW="None" STARTINCLINATION="95;0;"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570201715748" ID="ID_1744847530" MODIFIED="1570643417299" TEXT="works_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1744847530" ENDARROW="Default" ENDINCLINATION="181;0;" ID="Arrow_ID_279562913" SOURCE="ID_215478684" STARTARROW="None" STARTINCLINATION="181;0;"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node CREATED="1570201703003" ID="ID_1092728263" MODIFIED="1570383117273" TEXT="eval_date(&#xd3c9;&#xac00; &#xc2dc;&#xac04;)"/>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189342913" FOLDED="true" ID="ID_410823363" MODIFIED="1570668699622" POSITION="right" STYLE="bubble" TEXT="evaluation_item">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570190822564" ID="ID_893901578" MODIFIED="1570383204889" STYLE="bubble" TEXT="eval_item_id(&#xd3c9;&#xac00; &#xc544;&#xc774;&#xd15c; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_1932256498" ENDARROW="Default" ENDINCLINATION="95;0;" ID="Arrow_ID_54834023" STARTARROW="None" STARTINCLINATION="95;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570189921308" ID="ID_1467303721" MODIFIED="1570383204889" TEXT="subjectMatter(&#xc18c;&#xc7ac;)"/>
<node CREATED="1570190392805" ID="ID_1920594019" MODIFIED="1570383204890" TEXT="ev_text1(&#xd3c9;&#xac00;&#xd14d;&#xc2a4;&#xd2b8; &#xc0c1;&#xb2e8;)"/>
<node CREATED="1570190404700" ID="ID_52426446" MODIFIED="1570383204890" TEXT="ev_text2(&#xd3c9;&#xac00;&#xd14d;&#xc2a4;&#xd2b8; &#xd558;&#xb2e8;)"/>
<node CREATED="1570190851502" ID="ID_837426600" MODIFIED="1570383204891" STYLE="fork" TEXT="donation(&#xae30;&#xbd80;)">
<font NAME="SansSerif" SIZE="12"/>
</node>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_1066688788" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_1749271054" MODIFIED="1570388019242" TEXT="evaluate"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570189656666" FOLDED="true" ID="ID_1345748298" MODIFIED="1571094730788" POSITION="right" STYLE="bubble" TEXT="works">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570200683673" ID="ID_215478684" MODIFIED="1570383205463" STYLE="bubble" TEXT="work_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_1744847530" ENDARROW="Default" ENDINCLINATION="181;0;" ID="Arrow_ID_279562913" STARTARROW="None" STARTINCLINATION="181;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570190699821" ID="ID_81892006" MODIFIED="1570639869767" TEXT="type2_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node CREATED="1570190461676" ID="ID_767182587" MODIFIED="1570383205464" TEXT="subject(&#xc81c;&#xbaa9;)"/>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_1259491908" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570387962656" ID="ID_456484299" MODIFIED="1570388019242" TEXT="evaluate"/>
<node CREATED="1570388138134" ID="ID_1400887036" MODIFIED="1570388144810" TEXT="worksSave"/>
<node CREATED="1570388147262" ID="ID_815181879" MODIFIED="1570388148242" TEXT="create"/>
<node CREATED="1570643280420" ID="ID_26264173" MODIFIED="1570643297833" TEXT="fileSave"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1570189805747" FOLDED="true" ID="ID_905974177" MODIFIED="1571094731346" POSITION="right" STYLE="bubble" TEXT="worksSave">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570202031109" ID="ID_1751658578" MODIFIED="1570384084497" STYLE="bubble" TEXT="work_save_id(&#xc800;&#xc791;&#xbb3c; &#xc800;&#xc7a5; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570202043219" ID="ID_1673328208" MODIFIED="1570202230169" TEXT="user_id(&#xc720;&#xc800; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570202179452" ID="ID_1958614296" MODIFIED="1570202230359" TEXT="wroks_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
</node>
<node COLOR="#3333ff" CREATED="1570204025839" FOLDED="true" ID="ID_573508692" MODIFIED="1570668699622" POSITION="right" STYLE="bubble" TEXT="create_art">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
<node COLOR="#3333ff" CREATED="1570204029935" ID="ID_17484764" MODIFIED="1570383141455" STYLE="bubble" TEXT="create_id(&#xcc3d;&#xc791; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570204201855" ID="ID_123670423" MODIFIED="1570386707668" TEXT="artist_id(&#xc800;&#xc791;&#xc790; &#xc544;&#xc774;&#xb514;)">
<linktarget COLOR="#b0b0b0" DESTINATION="ID_123670423" ENDARROW="Default" ENDINCLINATION="111;0;" ID="Arrow_ID_630873394" SOURCE="ID_1040338839" STARTARROW="None" STARTINCLINATION="111;0;"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node COLOR="#000000" CREATED="1570204391928" ID="ID_1491470580" MODIFIED="1570383141456" TEXT="works_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node CREATED="1570204589696" ID="ID_1541112293" MODIFIED="1570383141456" TEXT="create_date(&#xcc3d;&#xc791; &#xb0a0;&#xc9dc;)"/>
<node CREATED="1570204599225" ID="ID_267976604" LINK="#ID_1303840061" MODIFIED="1570383141456" TEXT="create_end_date2(&#xb05d;&#xb098;&#xb294;&#xb0a0;&#xc9dc;)"/>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570190492325" ID="ID_180165791" MODIFIED="1571094718987" POSITION="right" STYLE="bubble" TEXT="artist">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570202714101" ID="ID_1040338839" MODIFIED="1570386707668" STYLE="bubble" TEXT="artist_id(&#xc800;&#xc791;&#xc790; &#xc544;&#xc774;&#xb514;)">
<arrowlink DESTINATION="ID_123670423" ENDARROW="Default" ENDINCLINATION="111;0;" ID="Arrow_ID_630873394" STARTARROW="None" STARTINCLINATION="111;0;"/>
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570203193262" ID="ID_1400303485" MODIFIED="1570383206884" TEXT="art_name(&#xc774;&#xb984;)"/>
<node COLOR="#000000" CREATED="1570203215581" ID="ID_502686680" MODIFIED="1570383206884" TEXT="user_id(&#xc720;&#xc800;&#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node COLOR="#6666ff" CREATED="1570387947454" ID="ID_742411747" MODIFIED="1570387958188" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4; &#xc788;&#xb294;&#xacf3;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570388147262" ID="ID_1945098226" MODIFIED="1570388148242" TEXT="create"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570636847747" FOLDED="true" ID="ID_940368837" MODIFIED="1570668699623" POSITION="right" STYLE="bubble" TEXT="type1">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570637736653" ID="ID_568525617" MODIFIED="1570638609638" STYLE="bubble" TEXT="type1_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570637889427" ID="ID_437808232" MODIFIED="1570643961113" TEXT="type1_name"/>
<node COLOR="#6666ff" CREATED="1570639830428" ID="ID_6694740" MODIFIED="1570643262542" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570639835154" ID="ID_831783520" MODIFIED="1570643262541" TEXT="type2"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570637661306" FOLDED="true" ID="ID_1369038251" MODIFIED="1570668699623" POSITION="right" STYLE="bubble" TEXT="type2">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570637967380" ID="ID_141047140" MODIFIED="1570638608966" STYLE="bubble" TEXT="type2_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node COLOR="#000000" CREATED="1570638595267" ID="ID_88902455" MODIFIED="1570640172351" TEXT="type1_id(&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
<node CREATED="1570638599114" ID="ID_1349135083" MODIFIED="1570638606326" TEXT="type2_name"/>
<node COLOR="#6666ff" CREATED="1570639879060" ID="ID_1072304621" MODIFIED="1570639957838" STYLE="bubble" TEXT="&#xc678;&#xb798;&#xd0a4;">
<edge STYLE="bezier"/>
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
<node CREATED="1570639882244" ID="ID_934001659" MODIFIED="1570639957838" TEXT="works"/>
</node>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1570640298452" FOLDED="true" ID="ID_1928030582" MODIFIED="1570668699623" POSITION="right" STYLE="bubble" TEXT="fileSave">
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
<node COLOR="#3333ff" CREATED="1570640324173" ID="ID_1971154851" MODIFIED="1570640387566" STYLE="bubble" TEXT="file_id(&#xd30c;&#xc77c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xad74;&#xb9bc;" SIZE="16"/>
</node>
<node CREATED="1570640496459" ID="ID_1858177930" MODIFIED="1570640902935" TEXT="file_name(&#xc2e4;&#xc81c;&#xd30c;&#xc77c;&#xc774;&#xb984;)"/>
<node CREATED="1570640547331" ID="ID_69436593" MODIFIED="1570640720599" TEXT="file_path(&#xc2e4;&#xc81c;&#xd30c;&#xc77c;&#xacbd;&#xb85c;)"/>
<node CREATED="1570640614844" ID="ID_1008917784" MODIFIED="1570640928207" TEXT="save_file_name(&#xc800;&#xc7a5;&#xd30c;&#xc77c;&#xc774;&#xb984;)"/>
<node CREATED="1570640928483" ID="ID_1493012707" MODIFIED="1570640934463" TEXT="save_file_path(&#xc800;&#xc7a5;&#xd30c;&#xc77c;&#xacbd;&#xb85c;)"/>
<node CREATED="1570643433756" ID="ID_1091085937" MODIFIED="1570643444625" TEXT="file_type(&#xd30c;&#xc77c;&#xd0c0;&#xc785;)"/>
<node COLOR="#000000" CREATED="1570200683673" ID="ID_568478641" MODIFIED="1570643417299" TEXT="work_id(&#xc800;&#xc791;&#xbb3c; &#xc544;&#xc774;&#xb514;)">
<font BOLD="true" NAME="&#xd568;&#xcd08;&#xb86c;&#xbc14;&#xd0d5;" SIZE="18"/>
</node>
</node>
<node CREATED="1570202278275" ID="ID_370048716" MODIFIED="1571087091810" POSITION="right" TEXT="&#xc815;&#xcc45;">
<node CREATED="1570195985846" ID="ID_949132852" MODIFIED="1570195987403" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;1">
<node CREATED="1570195992918" ID="ID_1704575025" MODIFIED="1570198529448" TEXT="&#xbcf4;&#xb294; &#xac83;"/>
<node CREATED="1570198520483" ID="ID_1672519645" MODIFIED="1570198528024" TEXT="&#xb4e0;&#xb294; &#xac83;"/>
<node CREATED="1570198524340" ID="ID_382114831" MODIFIED="1570198525192" TEXT="&#xd558;&#xb294; &#xac83;"/>
</node>
<node CREATED="1570198530956" ID="ID_183244509" MODIFIED="1570198534712" TEXT="&#xc800;&#xc791;&#xbb3c; &#xc720;&#xd615;2">
<node CREATED="1570198535412" ID="ID_789841412" MODIFIED="1570198538879" TEXT="EPISODE"/>
<node CREATED="1570199125069" ID="ID_1347624261" MODIFIED="1570199130057" TEXT="GAME"/>
<node CREATED="1570199130365" ID="ID_1401066273" MODIFIED="1570199132594" TEXT="&#xc544;&#xb9c8; &#xc878;&#xb77c; &#xb9ce;&#xc744;&#xb4ef;"/>
</node>
<node CREATED="1570202302972" ID="ID_1097680040" MODIFIED="1570202320576" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xc0c8;&#xb85c; &#xb4f1;&#xb85d;&#xd558;&#xb294;&#xac74; &#xc720;&#xc800;&#xc758; &#xbaab;&#xc774;&#xb2e4;. "/>
<node CREATED="1570202420053" ID="ID_1376576235" MODIFIED="1570202656096" TEXT="&#xc77c;&#xb2e8; &#xc800;&#xc7a5;&#xb41c; &#xc800;&#xc791;&#xbb3c;&#xc740; &#xc800;&#xc7a5;&#xd55c; &#xc720;&#xc800; &#xb9d0;&#xace0;&#xb294; &#xb2e4;&#xc2dc; &#xd3b8;&#xc9d1;&#xd558;&#xc9c0; &#xbabb;&#xd55c;&#xb2e4;. &#xc989; &#xb77d;&#xc5d0; &#xac78;&#xb9b0;&#xb2e4;."/>
<node CREATED="1570202442756" ID="ID_1715444064" MODIFIED="1570202669096" TEXT="&#xad00;&#xb9ac;&#xc790;&#xb294; &#xd3b8;&#xc9d1; &#xb77d;&#xc744; &#xd480;&#xac70;&#xb098; &#xb2e4;&#xc2dc;&#xb77d;&#xc5d0; &#xb123;&#xc744; &#xc218; &#xc788;&#xb2e4;."/>
<node CREATED="1570203238350" ID="ID_266195234" MODIFIED="1570203271218" TEXT="&#xc800;&#xc791;&#xbb3c;&#xc744; &#xb4f1;&#xb85d;&#xd558;&#xb294; &#xacfc;&#xc815; &#xb610;&#xd55c; &#xc800;&#xc791;&#xbb3c; &#xc785;&#xb825;--&gt; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d; &#xacfc;&#xc815;&#xc774;&#xb2e4;."/>
<node CREATED="1570203271526" ID="ID_849018134" MODIFIED="1570203318905" TEXT="&#xc544;&#xd2f0;&#xc2a4;&#xd2b8; &#xb4f1;&#xb85d; &#xacfc;&#xc815;&#xc740; &#xae30;&#xc874;&#xc5d0; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8;&#xb97c; &#xac80;&#xc0c9;&#xd558;&#xc5ec; &#xcc3e;&#xace0; &#xc5c6;&#xc73c;&#xba74; &#xc0c8;&#xb85c; &#xb4f1;&#xb85d;&#xd558;&#xb294; &#xac83;&#xc73c;&#xb85c; &#xc774;&#xac83; &#xb610;&#xd55c; &#xcc98;&#xc74c; &#xb4f1;&#xb85d;&#xd558;&#xba74; &#xb77d;&#xc5d0; &#xac78;&#xb9ac;&#xace0; &#xad00;&#xb9ac;&#xc790;&#xac00; &#xd3b8;&#xc9d1;&#xb77d;&#xc744; &#xd480;&#xac70;&#xb098; &#xb2e4;&#xc2dc;&#xb77d;&#xc5d0; &#xb123;&#xc744; &#xc218; &#xc788;&#xb2e4;."/>
<node CREATED="1570204623760" ID="ID_1303840061" MODIFIED="1570387838195" TEXT="&#xb05d;&#xb098;&#xb294; &#xb0a0;&#xc9dc;&#xb294; &#xc5d0;&#xd53c;&#xc18c;&#xb4dc; &#xb4f1; &#xd544;&#xc694;&#xd55c; &#xac83;"/>
</node>
<node CREATED="1570384541341" FOLDED="true" ID="ID_299164639" MODIFIED="1571087093670" POSITION="right" TEXT="&#xad6c;&#xd604;&#xd574;&#xc57c; &#xd560;&#xac83;">
<node CREATED="1570384548494" ID="ID_935541164" MODIFIED="1570384567928" TEXT="&#xc77c;&#xbc18; &#xc720;&#xc800;&#xac00; &#xc544;&#xd2f0;&#xc2a4;&#xd2b8;&#xac00; &#xb418;&#xc5b4;&#xc57c; &#xd568;. &#xadf8;&#xac70; &#xc2e0;&#xccad;&#xd558;&#xb294; &#xac83;&#xacfc; &#xc2e0;&#xccad;&#xc5d0; &#xb300;&#xd55c; &#xcee4;&#xbc0b;"/>
</node>
<node CREATED="1570478831830" FOLDED="true" ID="ID_1826492402" MODIFIED="1571087094566" POSITION="right" TEXT="&#xba54;&#xb274;">
<node CREATED="1570478845760" ID="ID_979006335" MODIFIED="1570478858554" TEXT="&#xcf54;&#xba58;&#xd2b8;&#xb4f1;&#xb85d;"/>
<node CREATED="1570478849655" ID="ID_246546064" MODIFIED="1570478856266" TEXT="&#xcf54;&#xba58;&#xd2b8;"/>
</node>
<node CREATED="1570479014767" ID="ID_1407586755" MODIFIED="1571087029826" POSITION="right" TEXT="&#xd654;&#xba74;">
<node COLOR="#3333ff" CREATED="1570479017584" FOLDED="true" ID="ID_304721571" MODIFIED="1571087085022" STYLE="bubble" TEXT="&#xd648;">
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
<node CREATED="1570650084112" FOLDED="true" ID="ID_1995661712" MODIFIED="1571087085022" TEXT="&#xd68c;&#xc6d0;&#xac00;&#xc785;(&#xc774;&#xbbf8;&#xc9c0;)">
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
<font BOLD="true" NAME="a&#xace0;&#xb515;15" SIZE="24"/>
</node>
<node CREATED="1570636251126" ID="ID_1176679536" MODIFIED="1571094645266" TEXT="&#xc800;&#xc791;&#xbb3c; &#xb4f1;&#xb85d;(&#xc774;&#xbbf8;&#xc9c0;)">
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
<node CREATED="1570479023509" ID="ID_213136224" MODIFIED="1570479026146" TEXT="&#xcf54;&#xba58;&#xd2b8;&#xb4f1;&#xb85d;"/>
<node CREATED="1570479026310" ID="ID_240643526" MODIFIED="1570479027186" TEXT="&#xcf54;&#xba58;&#xd2b8;"/>
</node>
<node CREATED="1570481801312" ID="ID_1008996283" MODIFIED="1571087017979" POSITION="right" TEXT="bootStrap&#xc5d0;&#xc11c; &#xbbf8;&#xb514;&#xc5b4; &#xcffc;&#xb9ac;">
<node CREATED="1570481842009" ID="ID_1378046496" MODIFIED="1570481851699" TEXT="992 &#xc774;&#xd558;&#xbd80;&#xd130; &#xb2ec;&#xb77c;&#xc9c0;&#xb294;&#xac83;&#xc73c;&#xb85c; &#xbcf4;&#xc778;&#xb2e4;."/>
</node>
</node>
</map>

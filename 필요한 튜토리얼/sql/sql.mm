<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1582971871809" ID="ID_1371382797" MODIFIED="1624424531772" TEXT="sql">
<hook NAME="accessories/plugins/RevisionPlugin.properties"/>
<hook NAME="accessories/plugins/CreationModificationPlugin_new.properties"/>
<node CREATED="1582971917096" ID="ID_688226061" MODIFIED="1582971923917" POSITION="right" TEXT="delete cascade once">
<node CREATED="1582971912386" ID="ID_489683932" LINK="https://stackoverflow.com/questions/129265/cascade-delete-just-once" MODIFIED="1582971912386" TEXT="https://stackoverflow.com/questions/129265/cascade-delete-just-once"/>
</node>
<node CREATED="1624435685568" ID="ID_1070357745" MODIFIED="1624435686939" POSITION="right" TEXT="&#xcffc;&#xb9ac;">
<node CREATED="1624435687776" ID="ID_8237812" MODIFIED="1624435692550" TEXT="&#xc11c;&#xbe0c;&#xcffc;&#xb9ac;"/>
<node CREATED="1624435692942" ID="ID_1273668378" MODIFIED="1624435695565" TEXT="&#xc778;&#xb77c;&#xc778;&#xbdf0; &#xc11c;&#xbe0c;&#xcffc;&#xb9ac;"/>
<node CREATED="1624435695871" ID="ID_897912627" MODIFIED="1624435696986" TEXT="&#xd558;&#xc704;&#xcffc;&#xb9ac;"/>
</node>
<node CREATED="1599815196828" ID="ID_116045282" MODIFIED="1599815199261" POSITION="right" TEXT="&#xd558;&#xc704;&#xcffc;&#xb9ac;">
<node CREATED="1599815195140" ID="ID_260267834" LINK="https://infodbbase.tistory.com/45" MODIFIED="1599815195140" TEXT="https://infodbbase.tistory.com/45"/>
</node>
<node BACKGROUND_COLOR="#ffffff" COLOR="#ff3333" CREATED="1624424533612" ID="ID_1094263084" MODIFIED="1624424537852" POSITION="right" STYLE="bubble" TEXT="mustcontaint">
<font BOLD="true" NAME="Dialog" SIZE="24"/>
<node CREATED="1624424538373" ID="ID_1219064950" LINK="https://stackoverflow.com/questions/23721598/sql-child-must-contain-all-specified-values" MODIFIED="1624424538373" TEXT="https://stackoverflow.com/questions/23721598/sql-child-must-contain-all-specified-values"/>
<node CREATED="1624424592819" ID="ID_1703348677" MODIFIED="1624424594158" TEXT="jpql"/>
</node>
<node CREATED="1624437503342" ID="ID_1334267140" MODIFIED="1624437524322" POSITION="right" TEXT="sql oneToMany&#xc5d0;&#xc11c; many&#xc5d0; &#xad00;&#xd55c; &#xcffc;&#xb9ac;">
<node CREATED="1624437524831" MODIFIED="1624437524831" TEXT="SELECT distinct dummy.*"/>
<node CREATED="1624437524832" MODIFIED="1624437524832" TEXT="FROM ( SELECT dummy.* FROM dummy LEFT OUTER JOIN"/>
<node CREATED="1624437524832" MODIFIED="1624437524832" TEXT="dummy_dummy_child child ON dummy.id = child.dummy_id"/>
<node CREATED="1624437524833" ID="ID_1409217797" MODIFIED="1624437524833" TEXT="GROUP BY dummy.id"/>
<node CREATED="1624437524833" MODIFIED="1624437524833" TEXT="HAVING COUNT(dummy.id) = 2 ) dummy"/>
<node CREATED="1624437524833" MODIFIED="1624437524833" TEXT="LEFT OUTER JOIN dummy_dummy_child child"/>
<node CREATED="1624437524834" MODIFIED="1624437524834" TEXT="ON dummy.id = child.dummy_id"/>
<node CREATED="1624437524834" MODIFIED="1624437524834" TEXT="WHERE child.dummy_child_id in (8, 10) limit 10"/>
</node>
</node>
</map>

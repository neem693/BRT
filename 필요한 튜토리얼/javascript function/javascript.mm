<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1590720758205" ID="ID_1813722365" MODIFIED="1590721026420" TEXT="&#xb0b4;&#xac00;&#xb9cc;&#xb4e0; &#xd568;&#xc218;">
<node CREATED="1590721027788" ID="ID_1512170669" MODIFIED="1606267499925" POSITION="right" TEXT="tablesort">
<node CREATED="1590721032336" FOLDED="true" ID="ID_1106817762" MODIFIED="1606267501929" TEXT="tableSort(sortinfo){">
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="let prop = sortinfo.prop;"/>
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="let order = sortinfo.order;"/>
<node CREATED="1590721032336" ID="ID_438078819" MODIFIED="1600157184146" TEXT="this.tableData = this.tableData.sort((a,b)=&gt;{">
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="let key = prop.split(&quot;.&quot;);"/>
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="let object_a = Object.assign(a);"/>
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="let object_b = Object.assign(b);"/>
<node CREATED="1590721032336" FOLDED="true" ID="ID_1245225532" MODIFIED="1600157185791" TEXT="if(key.length &gt; 1){">
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="for(var i =0; i&lt;key.length; i++){">
<node CREATED="1590721032336" MODIFIED="1590721032336" TEXT="if(this.$utils.isEmpty(object_a[key[i]])){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_a = null;"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="break;"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_a = object_a[key[i]];"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="for(var j =0; j&lt;key.length; j++){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="if(this.$utils.isEmpty(object_b[key[j]])){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_b = null;"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="break;"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_b = object_b[key[j]]"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
</node>
<node CREATED="1590721032351" FOLDED="true" ID="ID_339219010" MODIFIED="1600157185791" TEXT="}else{">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_a = object_a[key[0]];"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="object_b = object_b[key[0]];"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" FOLDED="true" ID="ID_134325729" MODIFIED="1600157185791" TEXT="if(order == &quot;descending&quot;){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="if(this.$utils.isEmpty(object_a)){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="return -1;"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="if(this.$utils.isEmpty(object_b)){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="return 1;"/>
</node>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="}"/>
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="return object_a.toString().localeCompare(object_b.toString());"/>
</node>
<node CREATED="1590721032351" FOLDED="true" ID="ID_1878899373" MODIFIED="1600157185791" TEXT="}else if(order == &quot;ascending&quot;){">
<node CREATED="1590721032351" MODIFIED="1590721032351" TEXT="if(this.$utils.isEmpty(object_b)){">
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="return -1;"/>
</node>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="}"/>
<node CREATED="1590721032367" ID="ID_854179783" MODIFIED="1590721032367" TEXT="if(this.$utils.isEmpty(object_a)){">
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="return 1;"/>
</node>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="}"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="return object_b.toString().localeCompare(object_a.toString());"/>
</node>
<node CREATED="1590721032367" FOLDED="true" ID="ID_103977829" MODIFIED="1600157185791" TEXT="}else if(order == null){">
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="// console.log(a[&apos;cd&apos;]);"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="return b[&apos;cd&apos;].toString().localeCompare(a[&apos;cd&apos;].toString());"/>
</node>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="}"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="// if(order == &quot;descending&quot;){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         if(this.$utils.isEmpty(a[prop])){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//                 return -1;"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         }"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         if(this.$utils.isEmpty(b[prop])){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//                 return 1;"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         }"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         return a[prop].toString().localeCompare(b[prop].toString());"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="// }else if(order == &quot;ascending&quot;){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         if(this.$utils.isEmpty(b[prop])){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//                 return -1;"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         }"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         if(this.$utils.isEmpty(a[prop])){"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//                 return 1;"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         }"/>
<node CREATED="1590721032367" MODIFIED="1590721032367" TEXT="//         return b[prop].toString().localeCompare(a[prop].toString());"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="// }else if(order == null){"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="//         // console.log(a[&apos;cd&apos;]);"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="//         return b[&apos;cd&apos;].toString().localeCompare(a[&apos;cd&apos;].toString());"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="// }"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="// console.log(a[prop].localeCompare(b[prop]));"/>
</node>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="})"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="// console.log(this.tableData);"/>
<node CREATED="1590721032382" MODIFIED="1590721032382" TEXT="}"/>
</node>
</node>
<node CREATED="1606267502930" ID="ID_1332116361" MODIFIED="1606267511234" POSITION="right" TEXT="youtube api">
<node CREATED="1606267511602" ID="ID_96080193" LINK="https://developers.google.com/youtube/player_parameters?hl=ko" MODIFIED="1606267511602" TEXT="https://developers.google.com/youtube/player_parameters?hl=ko"/>
<node CREATED="1606267755497" ID="ID_335623507" MODIFIED="1606267759906" TEXT="&#xae30;&#xbcf8;&#xc801;&#xc73c;&#xb85c; &#xc774;&#xc6a9;&#xd558;&#xb824;&#xba74;"/>
</node>
</node>
</map>

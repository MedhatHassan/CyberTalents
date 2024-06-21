<?php

$search = $POST['search'];
if (!preg_match('/^-?[0-9a-z]+$/m', $POST["search"])) {
  die("<h1><font color=\"red\">Hack Detected");    
}

$query = "SELECT * FROM topics where topicname like '%$search%'";
$res = mysql_query($query); 
$val = mysql_fetch_array($res);

?>
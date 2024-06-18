<?php
include('./access.php');
include('./index.php');
if($_COOKIE['api_key'] == $apikey) 
echo "Flag: $flag";
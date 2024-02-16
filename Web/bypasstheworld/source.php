$name = preg_replace('/\/' ,'',$name);
$pass = preg_replace('/\'/','', $pass);
$query = "SELECT * FROM users where name = `$name` and password = `$pass`";
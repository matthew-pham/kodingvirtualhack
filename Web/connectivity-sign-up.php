<?php 
define('DB_HOST', 'localhost'); 
define('DB_NAME', 'test'); 
define('DB_USER','francesco'); 
define('DB_PASSWORD','pass'); 
$con=mysql_connect(DB_HOST,DB_USER,DB_PASSWORD) or die("Failed to connect to MySQL: " . mysql_error()); 
$db=mysql_select_db(DB_NAME,$con) or die("Failed to connect to MySQL: " . mysql_error()); function NewUser() 
{
 
$userName = $_POST['user']; 
$password = $_POST['pass']; 
$query = "INSERT INTO UserName (userName,pass) VALUES ('$userName','$password')"; 
$data = mysql_query ($query)or die(mysql_error()); 
if($data) 
{  header('Location: http://169.44.61.135/generic.html'); }
} function SignUp() { if(!empty($_POST['user'])) 
{ $query = mysql_query("SELECT * FROM UserName WHERE userName = '$_POST[user]' AND pass = '$_POST[pass]'") or die(mysql_error()); 
if(!$row = mysql_fetch_array($query) or die(mysql_error())) { newuser(); 
    
} 
else 
{ echo "SORRY...YOU ARE ALREADY REGISTERED USER...";
}
}
}
if(isset($_POST['submit'])) { SignUp();
} 
?>


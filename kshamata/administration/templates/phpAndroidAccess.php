<?php
    session_start();
    function redirect($url, $statusCode = 303)
    {
        header('Location: ' . $url, true, $statusCode);
        die();
    }


	$email_login=$_POST["email1"];
	$password_login=$_POST["password1"];
    $user='root';
    $pass='';
    $dbname='kshamata23';

	   if ($email_login && $password_login) {
            $conn = new mysqli('localhost',$user,$pass,$dbname) or die("Connection failed");

            $sql = "SELECT * FROM user WHERE email='".$email_login."' ";
            $result = $conn->query($sql);
            $row=mysqli_fetch_array($result);
            if($row)
            {
                $password=$row["password"];
                $_SESSION["unid"] = $row["v_id"];
            }
            
            if($password==$password_login)
            {
                //echo "correct password";
                //redirect('http://localhost/ProjectHub-master/landing.php?id=1');
                $response["valid"]=1;
                 
             

            }
            else{
              //   echo "<h1>Incorrect Password</h1>"; 
              //   redirect("http://localhost/ProjectHub-master/index.php?id=1");
            	$response["valid"]=0;
              
             }
           

        }
    echo json_encode($response);
	$conn->close();

?>
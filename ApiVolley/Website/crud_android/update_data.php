<?php  
	include_once('connection.php'); 

	$username = $_POST['username'];

	$grup = $_POST['grup'];
	$nama = $_POST['nama'];
	$password = $_POST['password'];

	$getdata = mysqli_query($koneksi,"SELECT * FROM tb_mahasiswa WHERE username ='$username'"); 
	$rows = mysqli_num_rows($getdata);
	

	$respose = array();

	if($rows > 0 )
	{
		$query = "UPDATE tb_mahasiswa SET grup='$grup',nama='$nama',password='$password' WHERE username='$username'";
		$exequery = mysqli_query($koneksi,$query);
		if($exequery)
		{
				$respose['code'] =1;
				$respose['message'] = "Update Success";
		}
		else
		{
				$respose['code'] =0;
				$respose['message'] = "Failed Update";
		}
	}
	else
	{
				$respose['code'] =0;
				$respose['message'] = "Failed Update : data tidak ditemukan";
	}
	

	echo json_encode($respose);
?>


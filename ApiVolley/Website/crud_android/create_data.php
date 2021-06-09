<?php 
	include_once('connection.php'); 


	$username =$_POST['username'];
	$grup=$_POST['grup'];
	$nama=$_POST['nama'];
	$password=$_POST['password'];


	$insert = "INSERT INTO tb_mahasiswa(username, grup, nama, password) VALUES ('$username','$grup','$nama','$password')";

	$exeinsert = mysqli_query($koneksi,$insert);

	$response = array();

	if($exeinsert)
	{
		$response['code'] =1;
		$response['message'] = "Success ! Data di tambahkan";
	}
	else
	{
		$response['code'] =0;
		$response['message'] = "Failed ! Data Gagal di tambahkan";
	}

		echo json_encode($response);

 ?>
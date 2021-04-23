package com.fahirasalsabila.kelompok5_manajemenfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String filename;
    String fileContent;
    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText2);
        filename = "myFile.txt";
        fileContent = "myFileDir";
    }
    public void next(View view){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    public void savePublic(View view) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStorageDirectory();
        File createDir = new File(folder.getAbsolutePath()+"/Kelompok6");
        createDir.mkdir();
        File myFile = new File(createDir,"myData1.txt");
        writeData(myFile, info);
        editText.setText("");
    }
    public void savePrivate(View view) {
        String setData = editText.getText().toString();
        File folder = getExternalFilesDir("kelompok5");
        File myFile = new File(folder, "mydata2.txt");
        writeData(myFile, setData);
        editText.setText("");
     }
    private void writeData(File myFile, String data){
        FileOutputStream fileOutputStream = null;
        try {
            System.out.println("TES");
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(MainActivity.this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
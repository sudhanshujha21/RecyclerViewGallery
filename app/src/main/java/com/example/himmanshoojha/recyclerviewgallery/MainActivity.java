package com.example.himmanshoojha.recyclerviewgallery;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   private RecyclerView recyclerView1_v;
    Button btn;

    private RecyclerView.LayoutManager layoutManager_v;

    ArrayList<String> filePaths = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView1_v = (RecyclerView) findViewById(R.id.recyclervv);

        layoutManager_v = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);

        recyclerView1_v.setLayoutManager(layoutManager_v);

        recyclerView1_v.setHasFixedSize(true);
        btn = (Button)findViewById(R.id.bttn);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        filePaths.clear();
        FilePickerBuilder.getInstance().setMaxCount(6)
            .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.AppTheme)
                .pickPhoto(MainActivity.this);



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case FilePickerConst.REQUEST_CODE:
                if(resultCode==RESULT_OK && data!=null){

                    filePaths =data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_PHOTOS);
                    Imagegallery imagy;
                    ArrayList<Imagegallery>imagegalleries = new ArrayList<>();

                    try
                    {
                        for (String path:filePaths){
                            imagy = new Imagegallery();
                            imagy.setUri(Uri.fromFile(new File(path)));
                            imagegalleries.add(imagy);
                        }
                        recyclerView1_v.setAdapter(new MyAdapter(this,imagegalleries));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        }
    }
}

package com.sayem.android.mergeimagedemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sayem.android.mergeimagedemo.databinding.FirstActivityBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_CODE_OPEN_GALLERY = 101;
    private static final int REQUEST_CODE_ADD_EMO = 102;


    private FirstActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.first_activity);
        binding.selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGalleryButtonClicked(view, REQUEST_CODE_OPEN_GALLERY);
            }
        });

        binding.addEmoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGalleryButtonClicked(view, REQUEST_CODE_ADD_EMO);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_OPEN_GALLERY && resultCode == RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                binding.imageBaseView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.d(TAG, e.toString());
            }
        } else {
            if (data == null) {
                //Display an error
                return;
            }
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                binding.imageBaseView.setEmoBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.d(TAG, e.toString());
            }
        }
    }

    private void openGalleryButtonClicked(View view, int requestCode){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, requestCode);
    }
}

package com.midterm.tapvever2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class Image extends AppCompatActivity {
    //ImageView imageView;
    private Button uploadBtn,showAllBtn,btnback;
    private ImageView imageView;
    private ProgressBar progressBar;
    DatabaseReference root = FirebaseDatabase.getInstance().getReference("image");
    private StorageReference reference=FirebaseStorage.getInstance().getReference();
    private Uri imageUri;
    ActivityResultLauncher<String> mGetContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        uploadBtn= findViewById(R.id.upload_btn);
        btnback=findViewById(R.id.btnquayve);
        showAllBtn=findViewById(R.id.showall_btn);
        progressBar=findViewById(R.id.progressBar);
        imageView=findViewById(R.id.imageView);
        progressBar.setVisibility(View.VISIBLE);
        long Str=System.currentTimeMillis();

        mGetContent=registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        imageView.setImageURI(result);
                        imageUri=result;
                    }
                });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageUri !=null){
                    uploadtoFireBase(imageUri);
                }else{
                    Toast.makeText(Image.this,"Please Select Image",Toast.LENGTH_SHORT).show();
                }
            }

            private void uploadtoFireBase(Uri uri) {

                StorageReference fileRef= reference.child(Str + "." + getFileExtension(uri));
                fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                root.child(String.valueOf(Str)).setValue("");
                                Toast.makeText(Image.this, "Updload Success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar.setVisibility(View.VISIBLE);
                        Toast.makeText(Image.this,"Uploading Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private String getFileExtension(Uri mUri) {
                ContentResolver cr =getContentResolver();
                MimeTypeMap mime= MimeTypeMap.getSingleton();
                return mime.getExtensionFromMimeType(cr.getType(mUri));
            }
        });


        showAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Image.this, ImageAnimal.class);
                String S=String.valueOf(Str);
                intent.putExtra("Str",S);
                startActivity(intent);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });



    }


}
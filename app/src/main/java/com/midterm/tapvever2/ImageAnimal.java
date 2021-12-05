package com.midterm.tapvever2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ImageAnimal extends AppCompatActivity {
    private StorageReference mStorageReference;
    DatabaseReference name;
    TextView Nameanimal;
    Button btnread,btnsound;
    String sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_animal);

        Nameanimal=findViewById(R.id.nameAnimal);
        btnread=findViewById(R.id.quayve);
        btnsound=findViewById(R.id.soundbtn);

        final String Str ,Stranh;
        Str=getIntent().getStringExtra("Str");
        Stranh=Str.concat("_res.jpg");
        name=FirebaseDatabase.getInstance().getReference("image").child(Str);
        mStorageReference= FirebaseStorage.getInstance().getReference().child(Stranh);




        try {
            final File localFile= File.createTempFile(Str,"jpg");
            mStorageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(ImageAnimal.this,"Picture Retrived",Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.imageView2)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ImageAnimal.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        name.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String data=(String)snapshot.getValue();
               sound=data.toLowerCase(Locale.ROOT);
               Nameanimal.setText(data);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    public void nghethu(View view) {

        if(sound.equals("age")) {
           final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.age);
            mediaPlayer.start();
        }

        if(sound.equals("air")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.air);
            mediaPlayer.start();
        }
        if(sound.equals("ant")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ant);
            mediaPlayer.start();
        }
        if(sound.equals("apple")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.apple);
            mediaPlayer.start();
        }if(sound.equals("army")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.army);
            mediaPlayer.start();
        }if(sound.equals("arrow")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.arrow);
            mediaPlayer.start();
        }if(sound.equals("bee")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bee);
            mediaPlayer.start();
        }
        if(sound.equals("beetle")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.beetle);
            mediaPlayer.start();
        }
        if(sound.equals("box")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.box);
            mediaPlayer.start();
        }
        if(sound.equals("boy")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.boy);
            mediaPlayer.start();
        }
        if(sound.equals("bus")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bus);
            mediaPlayer.start();
        }
        if(sound.equals("butterfly")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.butterfly);
            mediaPlayer.start();
        }
        if(sound.equals("cat")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cat);
            mediaPlayer.start();
        }
        if(sound.equals("chicken")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.chicken);
            mediaPlayer.start();
        }
        if(sound.equals("chimpanzee")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.chimpanzee);
            mediaPlayer.start();
        }
        if(sound.equals("clams")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.clams);
            mediaPlayer.start();
        }
        if(sound.equals("coral")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.coral);
            mediaPlayer.start();
        }
        if(sound.equals("cormorant")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cormorant);
            mediaPlayer.start();
        }
        if(sound.equals("cow")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cow);
            mediaPlayer.start();
        }
        if(sound.equals("coyote")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.coyote);
            mediaPlayer.start();
        }
        if(sound.equals("crab")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.crab);
            mediaPlayer.start();
        }
        if(sound.equals("crow")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.crow);
            mediaPlayer.start();
        }
        if(sound.equals("deer")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.deer);
            mediaPlayer.start();
        }
        if(sound.equals("dog")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dog);
            mediaPlayer.start();
        }
        if(sound.equals("dolphin")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dolphin);
            mediaPlayer.start();
        }
        if(sound.equals("dove")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dove);
            mediaPlayer.start();
        }
        if(sound.equals("dragonfly")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dragonfly);
            mediaPlayer.start();
        }
        if(sound.equals("duck")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.duck);
            mediaPlayer.start();
        }
        if(sound.equals("elephant")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
            mediaPlayer.start();
        }
        if(sound.equals("fish")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fish);
            mediaPlayer.start();
        }
        if(sound.equals("flamingo")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.flamingo);
            mediaPlayer.start();
        }
        if(sound.equals("fox")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fox);
            mediaPlayer.start();
        }
        if(sound.equals("giraffe")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
            mediaPlayer.start();
        }
        if(sound.equals("goat")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.goat);
            mediaPlayer.start();
        }
        if(sound.equals("goldfish")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.goldfish);
            mediaPlayer.start();
        }
        if(sound.equals("goose")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.goose);
            mediaPlayer.start();
        }
        if(sound.equals("grasshopper")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.grasshopper);
            mediaPlayer.start();
        }
        if(sound.equals("hamster")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hamster);
            mediaPlayer.start();
        }
        if(sound.equals("hawk")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hawk);
            mediaPlayer.start();
        }
        if(sound.equals("hedgehog")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hedgehog);
            mediaPlayer.start();
        }
        if(sound.equals("pelican")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pelican);
            mediaPlayer.start();
        }
        if(sound.equals("penguin")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.penguin);
            mediaPlayer.start();
        }
        if(sound.equals("pig")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pig);
            mediaPlayer.start();
        }
        if(sound.equals("puppy")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.puppy);
            mediaPlayer.start();
        }
        if(sound.equals("rabbit")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
            mediaPlayer.start();
        }
        if(sound.equals("seagull")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.seagull);
            mediaPlayer.start();
        }
        if(sound.equals("seahorse")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.seahorse);
            mediaPlayer.start();
        }
        if(sound.equals("seal")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.seal);
            mediaPlayer.start();
        }
        if(sound.equals("shark")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.shark);
            mediaPlayer.start();
        }
        if(sound.equals("sheep")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sheep);
            mediaPlayer.start();
        }
        if(sound.equals("shrimp")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.shrimp);
            mediaPlayer.start();
        }
        if(sound.equals("spider")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.spider);
            mediaPlayer.start();
        }
        if(sound.equals("squid")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.squid);
            mediaPlayer.start();
        }
        if(sound.equals("starfish")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.starfish);
            mediaPlayer.start();
        }
        if(sound.equals("stork")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.stork);
            mediaPlayer.start();
        }
        if(sound.equals("swallow")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.swallow);
            mediaPlayer.start();
        }
        if(sound.equals("swan")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.swan);
            mediaPlayer.start();
        }
        if(sound.equals("turkey")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.turkey);
            mediaPlayer.start();
        }
        if(sound.equals("turtle")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.turtle);
            mediaPlayer.start();
        }
        if(sound.equals("walrus")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.walrus);
            mediaPlayer.start();
        }
        if(sound.equals("whale")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.whale);
            mediaPlayer.start();
        }
        if(sound.equals("woodpecker")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.woodpecker);
            mediaPlayer.start();
        }
        if(sound.equals("hippopotamus")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.hippopotamus);
            mediaPlayer.start();
        }
        if(sound.equals("horse")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.horse);
            mediaPlayer.start();
        }
        if(sound.equals("jellyfish")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.jellyfish);
            mediaPlayer.start();
        }
        if(sound.equals("kangaroo")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.kangaroo);
            mediaPlayer.start();
        }
        if(sound.equals("koala")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.koala);
            mediaPlayer.start();
        }
        if(sound.equals("ladybird")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ladybird);
            mediaPlayer.start();
        }
        if(sound.equals("leopard")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.leopard);
            mediaPlayer.start();
        }
        if(sound.equals("lion")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lion);
            mediaPlayer.start();
        }
        if(sound.equals("lobster")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lobster);
            mediaPlayer.start();
        }
        if(sound.equals("lobster")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lobster);
            mediaPlayer.start();
        }
        if(sound.equals("monkey")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.monkey);
            mediaPlayer.start();
        }
        if(sound.equals("mouse")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mouse);
            mediaPlayer.start();
        }
        if(sound.equals("octopus")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.octopus);
            mediaPlayer.start();
        }
        if(sound.equals("ostrich")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ostrich);
            mediaPlayer.start();
        }
        if(sound.equals("otter")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.otter);
            mediaPlayer.start();
        }
        if(sound.equals("owl")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.owl);
            mediaPlayer.start();
        }
        if(sound.equals("ox")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ox);
            mediaPlayer.start();
        }
        if(sound.equals("panda")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.panda);
            mediaPlayer.start();
        }
        if(sound.equals("parrot")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.parrot);
            mediaPlayer.start();
        }
        if(sound.equals("peacock")) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.peacock);
            mediaPlayer.start();
        }
    }
}
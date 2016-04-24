package com.example.anna.assignment3partb;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.WallpaperManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends Activity implements Secondfragment.TextClicked,SurfaceHolder.Callback{
    Button buttonSend;
    EditText textTo;
    MediaPlayer mp;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    VideoView video;
    @Override
    public void sendmp4(MediaPlayer mp, String str)
    {
       // video.start();
        Log.i("STR VALUE", str);
        mp.setDisplay(holder);
        mp.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

      //  play();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//set image as wallpaper
        Button buttonSetWallpaper = (Button)findViewById(R.id.btn1);
        ImageView imagePreview = (ImageView)findViewById(R.id.iv1);
        imagePreview.setImageResource(R.drawable.download);

        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setResource(R.raw.download);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
//set video on surfaceholder

        mPreview = (SurfaceView)findViewById(R.id.surfaceView);
        holder = mPreview.getHolder();
        holder.setFixedSize(800, 480);
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        FragmentManager fragmanager=getFragmentManager();
        FragmentTransaction fragtransaction=fragmanager.beginTransaction();
//        Primaryfragment frag1=new Primaryfragment();
//        Secondfragment frag2=new Secondfragment();
        Fragment frag1=getFragmentManager().findFragmentById(R.id.fragment1);
        Fragment frag2=getFragmentManager().findFragmentById(R.id.fragment2);
     //   Fragment frag3=getFragmentManager().findFragmentById(R.id.fragment3);
//        mp= MediaPlayer.create(MainActivity.this,R.raw.phoenix);
//        mp.start();
       // mp.setLooping(true);

        //send email to the artist
        buttonSend = (Button) findViewById(R.id.btn2);
        textTo = (EditText) findViewById(R.id.et1);
//        textSubject = (EditText) findViewById(R.id.editTextSubject);
//        textMessage = (EditText) findViewById(R.id.editTextMessage);

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = textTo.getText().toString();
//                String subject = textSubject.getText().toString();
//                String message = textMessage.getText().toString();
                String subject="Add me to your mailing list";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                //email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }});

        }


    @Override
    protected void onPause() {
        super.onPause();
     //   mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    //    mp.start();
    }
}

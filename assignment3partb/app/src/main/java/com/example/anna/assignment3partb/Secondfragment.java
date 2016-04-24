package com.example.anna.assignment3partb;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

import java.io.IOException;

/**
 * Created by anna on 3/29/16.
 */
public class Secondfragment extends ListFragment{
    TextClicked mCallback;

    public interface TextClicked{
        void sendmp4(MediaPlayer mp,String str);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Activity activity=getActivity();
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (TextClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }
    ThirdFragment s1=new ThirdFragment();
    MediaPlayer mp=new MediaPlayer();
    MediaPlayer mp1=new MediaPlayer();
    VideoView vid;
    String[] s={"Carnival of Rust","Choice Millionaire"};


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,s));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        switch (position)
        {

        case 0:
        Log.i("goes1", "goes into fragment 1 case 0");
            Log.i("goes1", "goes into fragment 1 case 0");
            mp.reset();
            try{
                AssetFileDescriptor afd = MyApp.getContext().getResources().openRawResourceFd(R.raw.potf1);
                if (afd == null) return;
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            try{
                mp.prepare();
            }
            catch (IOException e){e.printStackTrace();}
mCallback.sendmp4(mp,"DONE");
           // s1.playVideo(mp);
            break;
        case 1:
        Log.i("goes2", "goes into fragment 1 case 1");
        mp.reset();
        try{
            AssetFileDescriptor afd1 = MyApp.getContext().getResources().openRawResourceFd(R.raw.potf2);
            if (afd1 == null) return;
            mp.setDataSource(afd1.getFileDescriptor(), afd1.getStartOffset(), afd1.getLength());
            afd1.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try{
            mp.prepare();
        }
        catch (IOException e){e.printStackTrace();}
        mCallback.sendmp4(mp,"DONE");
        //s1.playVideo(mp);
        //mp.setLooping(true);
        break;
        default:
        Log.i("Error has occured", "Error has occured");
        break;        }
    }
}

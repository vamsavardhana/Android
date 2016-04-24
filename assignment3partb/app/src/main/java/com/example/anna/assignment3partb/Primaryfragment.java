package com.example.anna.assignment3partb;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

/**
 * Created by anna on 3/29/16.
 */
public class Primaryfragment extends ListFragment{

    String[] s={"Carnival of Rust","Choice Millionaire"};
    MediaPlayer mp=new MediaPlayer();
//    MediaPlayer mp1=new MediaPlayer();

    //Context context=this.getContext();

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.fragment1, container, false);
//        return rootView;
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, s));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(mp.isPlaying()==true)
        {
            mp.stop();
        }
          switch (position)
          {
              case 0:
                  Log.i("goes1", "goes into fragment 1 case 0");
                  mp.reset();
                  try{
                      AssetFileDescriptor afd = MyApp.getContext().getResources().openRawResourceFd(R.raw.fallulah);
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
                  mp.start();
                  //mp.setLooping(true);
                  break;
              case 1:
                  Log.i("goes2", "goes into fragment 1 case 1");
                  mp.reset();
                  try{
                      AssetFileDescriptor afd1 = MyApp.getContext().getResources().openRawResourceFd(R.raw.phoenix);
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
                  mp.start();
                  //mp.setLooping(true);
                  break;
              default:
                  Log.i("Error has occured", "Error has occured");
                  break;


        }
    }
}

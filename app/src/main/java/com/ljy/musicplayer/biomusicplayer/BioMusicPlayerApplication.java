package com.ljy.musicplayer.biomusicplayer;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.ljy.musicplayer.biomusicplayer.model.Mindwave;
import com.ljy.musicplayer.biomusicplayer.presenter.AudioServiceInterface;

import java.io.File;

public class BioMusicPlayerApplication extends Application {
    private File musicDir;
    private boolean isStudyMode = false;

    //musicPlayer
    private Mindwave mindwave;
    private AudioServiceInterface mInterface;
    private static BioMusicPlayerApplication mInstance;


    public static BioMusicPlayerApplication getInstance() {
        return mInstance;
    }

    public File getMusicDir() {
        return musicDir;
    }
    public Mindwave getMindwave() {
        return mindwave;
    }
    public boolean isStudyMode() {
        return isStudyMode;
    }
    public AudioServiceInterface getServiceInterface() {
        return mInterface;
    }

    public void setMusicDir(File musicDir) {
        this.musicDir = musicDir;
    }
    public void setMindwave(Mindwave mindwave) {
        this.mindwave = mindwave;
    }
    public void setStudyMode(boolean studyMode) {
        isStudyMode = studyMode;
    }

    @Override
    public void onCreate() {
        Log.d("start", "" + "start application");
        super.onCreate();
        mInstance = this;
        mInterface = new AudioServiceInterface(getApplicationContext());
        musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
    }

}

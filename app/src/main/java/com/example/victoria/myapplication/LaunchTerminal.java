package com.example.victoria.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LaunchTerminal extends FragmentActivity {

    private TextView mVersionTextView;
    private static final String SELECTED_VERSION = "com.example.android.selected_version";
    private String mSelectedVersion;

    private static final String TAG = "LaunchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch_terminal);

        mSelectedVersion=getIntent().getStringExtra("SELECTED_VERSION");


        FragmentManager fm= getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            if (fragment==null){

                switch (mSelectedVersion) {
                    case "AvatarOnly":
                        fragment = new WelcomeAvatarOnly();
                        break;
                    case "NudingOnly":
                        fragment = new WelcomeNudgingOnly();
                        break;
                    case "CombinedVersion":
                        fragment = new WelcomeCombinedVersion();
                        break;
                    default:
                        fragment = new WelcomeStandardVersion();
                }
                    fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
            }



    }
}

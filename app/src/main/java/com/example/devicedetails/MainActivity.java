package com.example.devicedetails;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.ColorSpace;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

import static java.lang.Class.*;


public class MainActivity extends AppCompatActivity {

    public static final int numRows = 17;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView[] textViewsCol1 = new TextView[numRows], textViewsCol2 = new TextView[numRows];
        textViewsCol1[0] = (TextView)findViewById(R.id.row1col1);
        textViewsCol2[0] = (TextView)findViewById(R.id.row1col2);
        textViewsCol1[1] = (TextView)findViewById(R.id.row2col1);
        textViewsCol2[1] = (TextView)findViewById(R.id.row2col2);
        textViewsCol1[2] = (TextView)findViewById(R.id.row3col1);
        textViewsCol2[2] = (TextView)findViewById(R.id.row3col2);
        textViewsCol1[3] = (TextView)findViewById(R.id.row4col1);
        textViewsCol2[3] = (TextView)findViewById(R.id.row4col2);
        textViewsCol1[4] = (TextView)findViewById(R.id.row5col1);
        textViewsCol2[4] = (TextView)findViewById(R.id.row5col2);
        textViewsCol1[5] = (TextView)findViewById(R.id.row6col1);
        textViewsCol2[5] = (TextView)findViewById(R.id.row6col2);
        textViewsCol1[6] = (TextView)findViewById(R.id.row7col1);
        textViewsCol2[6] = (TextView)findViewById(R.id.row7col2);
        textViewsCol1[7] = (TextView)findViewById(R.id.row8col1);
        textViewsCol2[7] = (TextView)findViewById(R.id.row8col2);
        textViewsCol1[8] = (TextView)findViewById(R.id.row9col1);
        textViewsCol2[8] = (TextView)findViewById(R.id.row9col2);
        textViewsCol1[9] = (TextView)findViewById(R.id.row10col1);
        textViewsCol2[9] = (TextView)findViewById(R.id.row10col2);
        textViewsCol1[10] = (TextView)findViewById(R.id.row11col1);
        textViewsCol2[10] = (TextView)findViewById(R.id.row11col2);
        textViewsCol1[11] = (TextView)findViewById(R.id.row12col1);
        textViewsCol2[11] = (TextView)findViewById(R.id.row12col2);
        textViewsCol1[12] = (TextView)findViewById(R.id.row13col1);
        textViewsCol2[12] = (TextView)findViewById(R.id.row13col2);
        textViewsCol1[13] = (TextView)findViewById(R.id.row14col1);
        textViewsCol2[13] = (TextView)findViewById(R.id.row14col2);
        textViewsCol1[14] = (TextView)findViewById(R.id.row15col1);
        textViewsCol2[14] = (TextView)findViewById(R.id.row15col2);
        textViewsCol1[15] = (TextView)findViewById(R.id.row16col1);
        textViewsCol2[15] = (TextView)findViewById(R.id.row16col2);
        textViewsCol1[16] = (TextView)findViewById(R.id.row17col1);
        textViewsCol2[16] = (TextView)findViewById(R.id.row17col2);

        textViewsCol1[0].setText("Manufacturer");
        textViewsCol1[1].setText("Model");
        textViewsCol1[2].setText("Battery Capacity");
        textViewsCol1[3].setText("Battery Level");
        textViewsCol1[4].setText("Total RAM");
        textViewsCol1[5].setText("Available RAM");
        textViewsCol1[6].setText("Total Internal Storage");
        textViewsCol1[7].setText("Total External Storage");
        textViewsCol1[8].setText("Available Internal Storage");
        textViewsCol1[9].setText("Available External Storage");
        textViewsCol1[10].setText("Refresh Rate");
        textViewsCol1[11].setText("FINGERPRINT");
        textViewsCol1[12].setText("HARDWARE");
        textViewsCol1[13].setText("DISPLAY");
        textViewsCol1[14].setText("ID");
        textViewsCol1[15].setText("HOST");
        textViewsCol1[16].setText("BOARD");

//        Log.d("Build check", Build.BOARD);
//        Log.d("Build check", Build.FINGERPRINT);
//        Log.d("Build check", Build.HARDWARE);
//        Log.d("Build check", Build.DEVICE);
//        Log.d("Build check", Build.DISPLAY);
//        Log.d("Build check", Build.ID);
//        Log.d("Build check", Build.HOST);




        textViewsCol2[0].setText(Build.MANUFACTURER);
        textViewsCol2[1].setText(Build.MODEL);
        textViewsCol2[2].setText(getBatteryCapacity() + " mAh");
        textViewsCol2[3].setText(getBatteryLevel() + "%");
        textViewsCol2[4].setText(getTotalRAM());
        textViewsCol2[5].setText(getAvailableRAM());
        textViewsCol2[6].setText(getTotalInternalStorage());
        textViewsCol2[7].setText(getTotalExternalStorage());
        textViewsCol2[8].setText(getAvailableInternalStorage());
        textViewsCol2[9].setText(getAvailableExternalStorage());
        textViewsCol2[10].setText(getRefreshRate());
        textViewsCol2[11].setText(Build.FINGERPRINT);
        textViewsCol2[12].setText(Build.HARDWARE);
        textViewsCol2[13].setText(Build.DISPLAY);
        textViewsCol2[14].setText(Build.ID);
        textViewsCol2[15].setText(Build.HOST);
        textViewsCol2[16].setText(Build.BOARD);



        final ScrollView scrollview = (ScrollView) findViewById(R.id.scrollView2);
        Button buttonLeft = (Button) findViewById(R.id.button3);
        Button buttonRight = (Button) findViewById(R.id.button4);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.fullScroll(scrollview.FOCUS_UP);
                //scrollview.smoothScrollTo(0, scrollview.getTop());
                //scrollview.setScrollY(scrollview.getTop());
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.fullScroll(scrollview.FOCUS_DOWN);
                //scrollview.setScrollY(scrollview.getBottom());
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private double getBatteryLevel() {
        BatteryManager batteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
    }

    private double getBatteryCapacity() {
        Object mPowerProfile;
        double batteryCapacity = 0;
        final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";
        try {
            Class<?> powerProfileClass = Class.forName(POWER_PROFILE_CLASS);
            mPowerProfile = powerProfileClass.getConstructor(Context.class).newInstance(this);
            batteryCapacity = (double) powerProfileClass.getMethod("getBatteryCapacity").invoke(mPowerProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batteryCapacity;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String getRefreshRate(){
        Display display = ((WindowManager) Objects.requireNonNull(getSystemService(WINDOW_SERVICE))).getDefaultDisplay();
        float refreshRate = display.getRefreshRate();  //Refresh rate in frames per second
        return String.format("%.2f Hz", refreshRate);
    }

    private String getTotalRAM(){
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memInfo);
        }
        double RAMInGB = ((double)memInfo.totalMem)/(1024*1024*1024);
        return String.format("%.2f GB", RAMInGB);
    }

    private String getAvailableRAM(){
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memInfo);
        }
        double RAMInGB = ((double)memInfo.availMem)/(1024*1024*1024);
        return String.format("%.2f GB", RAMInGB);
    }

    private String getTotalInternalStorage(){
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long totalSize = statFs.getTotalBytes();
        return String.format("%.2f GB", (double)totalSize/(1024*1024*1024));
    }

    private String getTotalExternalStorage(){
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        long totalSize = statFs.getTotalBytes();
        return String.format("%.2f GB", (double)totalSize/(1024*1024*1024));
    }

    private String getAvailableInternalStorage(){
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        long availableSize = statFs.getAvailableBytes();
        return String.format("%.2f GB", (double)availableSize/(1024*1024*1024));
    }

    private String getAvailableExternalStorage(){
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        long availableSize = statFs.getAvailableBytes();
        return String.format("%.2f GB", (double)availableSize/(1024*1024*1024));
    }






}

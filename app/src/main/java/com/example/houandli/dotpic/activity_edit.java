package com.example.houandli.dotpic;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.Locale;

public class activity_edit extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RadioButton currentCell;
    public static int currentColor ;
    int down_x = 0;
    int down_y = 0;
    int up_x = 0;
    int up_y = 0;
    Rect rect11 = new Rect();
    Rect rect12 = new Rect();
    Rect rect13 = new Rect();
    Rect rect14 = new Rect();
    Rect rect21 = new Rect();
    Rect rect22 = new Rect();
    Rect rect23 = new Rect();
    Rect rect24 = new Rect();
    Rect rect31 = new Rect();
    Rect rect32 = new Rect();
    Rect rect33 = new Rect();
    Rect rect34 = new Rect();
    Rect rect41 = new Rect();
    Rect rect42 = new Rect();
    Rect rect43 = new Rect();
    Rect rect44 = new Rect();
    int checked_cell = 41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();

        //use the canvas saved in SharedPreferences
        SharedPreferences pref = getSharedPreferences("test",0);    //create a new file to save
        Editor editor = pref.edit();
        final RadioButton c1_1;
        RadioButton c1_2;
        RadioButton c1_3;
        RadioButton c1_4;
        RadioButton c2_1;
        RadioButton c2_2;
        RadioButton c2_3;
        RadioButton c2_4;
        RadioButton c3_1;
        RadioButton c3_2;
        RadioButton c3_3;
        RadioButton c3_4;
        RadioButton c4_1;
        RadioButton c4_2;
        RadioButton c4_3;
        RadioButton c4_4;
        c1_1 = (RadioButton)findViewById(R.id.c1_1);
        c1_2 = (RadioButton)findViewById(R.id.c1_2);
        c1_3 = (RadioButton)findViewById(R.id.c1_3);
        c1_4 = (RadioButton)findViewById(R.id.c1_4);
        c2_1 = (RadioButton)findViewById(R.id.c2_1);
        c2_2 = (RadioButton)findViewById(R.id.c2_2);
        c2_3 = (RadioButton)findViewById(R.id.c2_3);
        c2_4 = (RadioButton)findViewById(R.id.c2_4);
        c3_1 = (RadioButton)findViewById(R.id.c3_1);
        c3_2 = (RadioButton)findViewById(R.id.c3_2);
        c3_3 = (RadioButton)findViewById(R.id.c3_3);
        c3_4 = (RadioButton)findViewById(R.id.c3_4);
        c4_1 = (RadioButton)findViewById(R.id.c4_1);
        c4_2 = (RadioButton)findViewById(R.id.c4_2);
        c4_3 = (RadioButton)findViewById(R.id.c4_3);
        c4_4 = (RadioButton)findViewById(R.id.c4_4);
        int cell1_1 = pref.getInt("c1_1", 0);
        int cell1_2 = pref.getInt("c1_2", 0);
        int cell1_3 = pref.getInt("c1_3", 0);
        int cell1_4 = pref.getInt("c1_4", 0);
        int cell2_1 = pref.getInt("c2_1", 0);
        int cell2_2 = pref.getInt("c2_2", 0);
        int cell2_3 = pref.getInt("c2_3", 0);
        int cell2_4 = pref.getInt("c2_4", 0);
        int cell3_1 = pref.getInt("c3_1", 0);
        int cell3_2 = pref.getInt("c3_2", 0);
        int cell3_3 = pref.getInt("c3_3", 0);
        int cell3_4 = pref.getInt("c3_4", 0);
        int cell4_1 = pref.getInt("c4_1", 0);
        int cell4_2 = pref.getInt("c4_2", 0);
        int cell4_3 = pref.getInt("c4_3", 0);
        int cell4_4 = pref.getInt("c4_4", 0);
        c1_1.setBackgroundColor(cell1_1);
        c1_2.setBackgroundColor(cell1_2);
        c1_3.setBackgroundColor(cell1_3);
        c1_4.setBackgroundColor(cell1_4);
        c2_1.setBackgroundColor(cell2_1);
        c2_2.setBackgroundColor(cell2_2);
        c2_3.setBackgroundColor(cell2_3);
        c2_4.setBackgroundColor(cell2_4);
        c3_1.setBackgroundColor(cell3_1);
        c3_2.setBackgroundColor(cell3_2);
        c3_3.setBackgroundColor(cell3_3);
        c3_4.setBackgroundColor(cell3_4);
        c4_1.setBackgroundColor(cell4_1);
        c4_2.setBackgroundColor(cell4_2);
        c4_3.setBackgroundColor(cell4_3);
        c4_4.setBackgroundColor(cell4_4);
        currentCell = (RadioButton) findViewById(R.id.c4_4);
        currentColor = 0xffffffff;

        /*c1_1.getHitRect(rect11);
        c1_2.getHitRect(rect12);
        c1_3.getHitRect(rect13);
        c1_4.getHitRect(rect14);
        c2_1.getHitRect(rect21);
        c2_2.getHitRect(rect22);
        c2_3.getHitRect(rect23);
        c2_4.getHitRect(rect24);
        c3_1.getHitRect(rect31);
        c3_2.getHitRect(rect32);
        c3_3.getHitRect(rect33);
        c3_4.getHitRect(rect34);
        c4_1.getHitRect(rect41);
        c4_2.getHitRect(rect42);
        c4_3.getHitRect(rect43);
        c4_4.getHitRect(rect44);*/

        /*
        //--------------------Delete this to see choose cell by clicking-------------------
        //                     Use this to see floating pen
        //create a pen
        RelativeLayout frame = (RelativeLayout) findViewById(R.id.canvas);
        final penView ic_pen = new penView(activity_edit.this);
        ic_pen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //where to start
                        down_x = (int)event.getX();
                        down_y = (int)event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ic_pen.bitmapX = Math.round(event.getX()) - down_x + up_x;
                        ic_pen.bitmapY = Math.round(event.getY()) - down_y + up_y;
                        if (rect11.contains((int) event.getX(), (int) event.getY())) {
                            checked_cell = 11;
                            c1_1.setChecked(true);
                        }
                        ic_pen.invalidate();
                        break;
                    case MotionEvent.ACTION_UP:
                        up_x = ic_pen.bitmapX;
                        up_y = ic_pen.bitmapY;
                        break;
                }
                return true;
            }
        });
        frame.addView(ic_pen);
        //-------------------------------------------------------------------------------------*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public static final int TAKE_PHOTO = 1;
    private Uri imageUri;
    private String filename;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.rename) {
        }
        else if (id == R.id.clear) {
            RadioButton c1_1;
            RadioButton c1_2;
            RadioButton c1_3;
            RadioButton c1_4;
            RadioButton c2_1;
            RadioButton c2_2;
            RadioButton c2_3;
            RadioButton c2_4;
            RadioButton c3_1;
            RadioButton c3_2;
            RadioButton c3_3;
            RadioButton c3_4;
            RadioButton c4_1;
            RadioButton c4_2;
            RadioButton c4_3;
            RadioButton c4_4;
            c1_1 = (RadioButton)findViewById(R.id.c1_1);
            c1_2 = (RadioButton)findViewById(R.id.c1_2);
            c1_3 = (RadioButton)findViewById(R.id.c1_3);
            c1_4 = (RadioButton)findViewById(R.id.c1_4);
            c2_1 = (RadioButton)findViewById(R.id.c2_1);
            c2_2 = (RadioButton)findViewById(R.id.c2_2);
            c2_3 = (RadioButton)findViewById(R.id.c2_3);
            c2_4 = (RadioButton)findViewById(R.id.c2_4);
            c3_1 = (RadioButton)findViewById(R.id.c3_1);
            c3_2 = (RadioButton)findViewById(R.id.c3_2);
            c3_3 = (RadioButton)findViewById(R.id.c3_3);
            c3_4 = (RadioButton)findViewById(R.id.c3_4);
            c4_1 = (RadioButton)findViewById(R.id.c4_1);
            c4_2 = (RadioButton)findViewById(R.id.c4_2);
            c4_3 = (RadioButton)findViewById(R.id.c4_3);
            c4_4 = (RadioButton)findViewById(R.id.c4_4);
            c1_1.setBackgroundColor(0xffffffff);
            c1_2.setBackgroundColor(0xffffffff);
            c1_3.setBackgroundColor(0xffffffff);
            c1_4.setBackgroundColor(0xffffffff);
            c2_1.setBackgroundColor(0xffffffff);
            c2_2.setBackgroundColor(0xffffffff);
            c2_3.setBackgroundColor(0xffffffff);
            c2_4.setBackgroundColor(0xffffffff);
            c3_1.setBackgroundColor(0xffffffff);
            c3_2.setBackgroundColor(0xffffffff);
            c3_3.setBackgroundColor(0xffffffff);
            c3_4.setBackgroundColor(0xffffffff);
            c4_1.setBackgroundColor(0xffffffff);
            c4_2.setBackgroundColor(0xffffffff);
            c4_3.setBackgroundColor(0xffffffff);
            c4_4.setBackgroundColor(0xffffffff);
            SharedPreferences pref = getSharedPreferences("test",0);
            Editor editor = pref.edit();
            editor = pref.edit();
            editor.putInt("c1_1", 0xffffffff);
            editor.putInt("c1_2", 0xffffffff);
            editor.putInt("c1_3", 0xffffffff);
            editor.putInt("c1_4", 0xffffffff);
            editor.putInt("c2_1", 0xffffffff);
            editor.putInt("c2_2", 0xffffffff);
            editor.putInt("c2_3", 0xffffffff);
            editor.putInt("c2_4", 0xffffffff);
            editor.putInt("c3_1", 0xffffffff);
            editor.putInt("c3_2", 0xffffffff);
            editor.putInt("c3_3", 0xffffffff);
            editor.putInt("c3_4", 0xffffffff);
            editor.putInt("c4_1", 0xffffffff);
            editor.putInt("c4_2", 0xffffffff);
            editor.putInt("c4_3", 0xffffffff);
            editor.putInt("c4_4", 0xffffffff);
            editor.commit();
        }
        else if (id == R.id.export) {
            try {
                File cacheDir = new File(android.os.Environment.getExternalStorageDirectory(),"DCIM");
                if (!cacheDir.exists()) {
                    cacheDir.mkdirs();
                }
                String path = new File(android.os.Environment.getExternalStorageDirectory(),"DCIM") + "/screenshot.png";
                SavedCanvas.savePic(SavedCanvas.takeScreenShot(this), path);
                Toast.makeText(getApplicationContext(), "Canvas Saved!", Toast.LENGTH_SHORT).show();
            } catch (NullPointerException ignored) {
                ignored.printStackTrace();
            }
        }
        else if (id == R.id.share) {
        }
        else if (id == R.id.settings) {
            showlanguagechangedialog();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void showlanguagechangedialog() {
        //build the alert dialog from language_dialog.xml
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language_dialog, null);
        dialogBuilder.setView(dialogView);
        final Spinner spinner1 = (Spinner) dialogView.findViewById(R.id.spinner1);
        dialogBuilder.setTitle(getResources().getString(R.string.lang_set_title));
        dialogBuilder.setPositiveButton(R.string.lang_set_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int langpos = spinner1.getSelectedItemPosition();
                switch(langpos) {
                    case 0: //English
                        //save the selection in the shared preference
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                        setLangRecreate("en");
                        return;
                    case 1: //Mandarin
                        //save the selection in the shared preference
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "zh").commit();
                        setLangRecreate("zh");
                        return;
                }
            }
        });
        dialogBuilder.setNegativeButton(R.string.lang_set_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //if clicked on cancel, do nothing
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void setLangRecreate(String langval) {
        //change the language
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    String CellName;

    public void cell(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which cell was clicked
        switch(view.getId()) {
            case R.id.c1_1:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c1_1);
                    CellName = "c1_1";
                break;
            case R.id.c1_2:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c1_2);
                    CellName = "c1_2";
                break;
            case R.id.c1_3:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c1_3);
                    CellName = "c1_3";
                break;
            case R.id.c1_4:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c1_4);
                    CellName = "c1_4";
                break;

            case R.id.c2_1:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c2_1);
                    CellName = "c2_1";
                break;
            case R.id.c2_2:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c2_2);
                    CellName = "c2_2";
                break;
            case R.id.c2_3:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c2_3);
                    CellName = "c2_3";
                break;
            case R.id.c2_4:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c2_4);
                    CellName = "c2_4";
                break;

            case R.id.c3_1:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c3_1);
                    CellName = "c3_1";
                break;
            case R.id.c3_2:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c3_2);
                    CellName = "c3_2";
                break;
            case R.id.c3_3:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c3_3);
                    CellName = "c3_3";
                break;
            case R.id.c3_4:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c3_4);
                    CellName = "c3_4";
                break;

            case R.id.c4_1:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c4_1);
                    CellName = "c4_1";
                break;
            case R.id.c4_2:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c4_2);
                    CellName = "c4_2";
                break;
            case R.id.c4_3:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c4_3);
                    CellName = "c4_3";
                break;
            case R.id.c4_4:
                if (checked)
                    currentCell =(RadioButton) findViewById(R.id.c4_4);
                    CellName = "c4_4";
                break;
        }
    }/*

    public void cell(View view) {

        // Check which cell was clicked
        switch(checked_cell) {
            case 11:
                currentCell =(RadioButton) findViewById(R.id.c1_1);
                CellName = "c1_1";
                break;
            case 12:
                currentCell =(RadioButton) findViewById(R.id.c1_2);
                CellName = "c1_2";
                break;
            case 13:
                currentCell =(RadioButton) findViewById(R.id.c1_3);
                CellName = "c1_3";
                break;
            case 14:
                currentCell =(RadioButton) findViewById(R.id.c1_4);
                CellName = "c1_4";
                break;

            case 21:
                currentCell =(RadioButton) findViewById(R.id.c2_1);
                CellName = "c2_1";
                break;
            case 22:
                currentCell =(RadioButton) findViewById(R.id.c2_2);
                CellName = "c2_2";
                break;
            case 23:
                currentCell =(RadioButton) findViewById(R.id.c2_3);
                CellName = "c2_3";
                break;
            case 24:
                currentCell =(RadioButton) findViewById(R.id.c2_4);
                CellName = "c2_4";
                break;

            case 31:
                currentCell =(RadioButton) findViewById(R.id.c3_1);
                CellName = "c3_1";
                break;
            case 32:
                currentCell =(RadioButton) findViewById(R.id.c3_2);
                CellName = "c3_2";
                break;
            case 33:
                currentCell =(RadioButton) findViewById(R.id.c3_3);
                CellName = "c3_3";
                break;
            case 34:
                currentCell =(RadioButton) findViewById(R.id.c3_4);
                CellName = "c3_4";
                break;

            case 41:
                currentCell =(RadioButton) findViewById(R.id.c4_1);
                CellName = "c4_1";
                break;
            case 42:
                currentCell =(RadioButton) findViewById(R.id.c4_2);
                CellName = "c4_2";
                break;
            case 43:
                currentCell =(RadioButton) findViewById(R.id.c4_3);
                CellName = "c4_3";
                break;
            case 44:
                currentCell =(RadioButton) findViewById(R.id.c4_4);
                CellName = "c4_4";
                break;
        }
    }*/

    public void pens(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pen_1:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_1);
                break;
            case R.id.pen_2:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_2);
                break;
            case R.id.pen_3:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_3);
                break;
            case R.id.pen_4:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_4);
                break;
            case R.id.pen_5:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_5);
                break;
            case R.id.pen_6:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_6);
                break;
            case R.id.pen_7:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_7);
                break;
            case R.id.pen_8:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_8);
                break;
            case R.id.pen_9:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_9);
                break;
            case R.id.pen_10:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_10);
                break;
            case R.id.pen_11:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_11);
                break;
            case R.id.pen_12:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_12);
                break;
            case R.id.pen_13:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_13);
                break;
            case R.id.pen_14:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_14);
                break;
            case R.id.pen_15:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_15);
                break;
            case R.id.pen_16:
                if (checked)
                    currentColor = getResources().getColor(R.color.pen_16);
                break;
        }
    }

    /*Typeface pixelFont = Typeface.createFromAsset(getAssets(),"font/Pixel.ttf");
    Button txt = (Button) findViewById(R.id.Btndot);
    txt.setTypeface(pixelFont);*/
    public void dot(View view){
        currentCell.setBackgroundColor(currentColor);
        SharedPreferences pref = getSharedPreferences("test",0);
        Editor editor = pref.edit();
        editor = pref.edit();
        editor.putInt(CellName, currentColor);
        editor.commit();
    }
}
package com.example.houandli.dotpic;

import android.widget.RadioButton;

public class CheckedRadioBtn {
    public void onRadioBtn(RadioButton RBtn, int up_x, int up_y){
        int[] position = new int[2];
        RBtn.getLocationOnScreen(position);
        //if ((position[0]<=up_x) && (up_x<=position[0]+128) && (position[1]<=up_y) && (up_y<=position[1]+128))
            RBtn.setChecked(true);
    }
}

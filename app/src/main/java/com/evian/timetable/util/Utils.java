package com.evian.timetable.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;


import java.io.File;

/**
 * 工具类：
 * 设置背景
 */
public class Utils {

    private static String PATH;
    private static final String BG_NAME = "bg.jpg";
    private static Bitmap bgBitmap = null;

    public static void setPATH(String PATH) {

        Utils.PATH = PATH;
    }

    public static void setBackGround(Context context,ImageView imageView) {
        setBackGround(context,imageView, Config.getBgId());
    }

    public static void setBackGround(Context context,ImageView imageView, int id) {

        if (bgBitmap == null) {
            refreshBg(context,id);
        }
        imageView.setImageBitmap(bgBitmap);
    }

    public static void refreshBg(Context context,int id) {

        if(id==0)
        {
            File file = new File(PATH, BG_NAME);
            if (file.exists()) {
                bgBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            }
        }
        else
        {
            bgBitmap=BitmapFactory.decodeResource(context.getResources(),id);
        }
    }

    public static void setCardViewAlpha(CardView cardView)
    {
        cardView.setAlpha(Config.getCardViewAlpha());
    }
}

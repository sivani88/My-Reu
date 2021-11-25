package com.example.maru.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FakeDateTime {

    public static Calendar generateTimeNow(Calendar mcal, String mDay, String mMonth, String mHour) {
        if (mDay != null)
            mcal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(mDay));
        if (mMonth != null)
            mcal.add(Calendar.MONTH, Integer.parseInt(mMonth));

        if (mHour != null)
            mcal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(mHour));
        mcal.set(Calendar.MINUTE, 00);
        mcal.set(Calendar.SECOND, 0);

        return mcal;
    }

    public static String getSimpleDateFormat(Calendar mCalendar) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        return dateFormat.format(mCalendar.getTime());

    }

    public static String getSimpleTimeFormat(Calendar mCalenadar) {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm", Locale.FRANCE);
        return hourFormat.format(mCalenadar.getTime());

    }

}

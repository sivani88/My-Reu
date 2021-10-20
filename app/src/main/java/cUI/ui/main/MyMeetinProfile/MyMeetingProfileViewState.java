package cUI.ui.main.MyMeetinProfile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyMeetingProfileViewState  {

    @NonNull
    private final String mName;
    @NonNull
    private final String avatarUrl;
    @NonNull
    private final String  mDate;
    @NonNull
    private final String mHour;
    @NonNull
    private final String subject;
    @NonNull
    private final String eMails;

    public MyMeetingProfileViewState(@NonNull String name, @NonNull String avatarUrl, @NonNull String date, @NonNull String hour, @NonNull String subject, @NonNull String eMails) {
        this.mName = name;
        this.avatarUrl = avatarUrl;
        mDate = date;
        mHour = hour;
        this.subject = subject;
        this.eMails = eMails;
    }

    @NonNull
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @NonNull
    public String getDate() {
        return mDate;
    }

    @NonNull
    public String getHaour() {
        return mHour;
    }

    @NonNull
    public String getSubject() {
        return subject;
    }

    @NonNull
    public String geteMails() {
        return eMails;
    }

    @NonNull
    public String getName() {
        return mName;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj)
        return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyMeetingProfileViewState that = (MyMeetingProfileViewState) obj;
        return  mName == that.mName && mDate == that.mDate && mHour == that.mHour && avatarUrl == that.avatarUrl && subject == that.subject && eMails == that.eMails;
    }
}




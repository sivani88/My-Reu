package cUI.ui.main.MyMeetinProfile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class MyMeetingProfileViewState  {

    @NonNull
    private final String mName;
    @NonNull
    private String avatarUrl;
    @NonNull
    private final String  mDate;
    @NonNull
    private final String mHour;
    @NonNull
    private final String subject;
    @NonNull
    private final String eMails;

    public MyMeetingProfileViewState(@NonNull String name, @NonNull String date, @NonNull String hour, @NonNull String subject, @NonNull String eMails) {
        mName = name;
        mDate = date;
        mHour = hour;
        this.subject = subject;
        this.eMails = eMails;
    }

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
    public String getHour() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMeetingProfileViewState that = (MyMeetingProfileViewState) o;
        return mName.equals(that.mName) &&
                avatarUrl.equals(that.avatarUrl) &&
                mDate.equals(that.mDate) &&
                mHour.equals(that.mHour) &&
                subject.equals(that.subject) &&
                eMails.equals(that.eMails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, avatarUrl, mDate, mHour, subject, eMails);
    }

    @Override
    public String toString() {
        return "MyMeetingProfileViewState{" +
                "mName='" + mName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mHour='" + mHour + '\'' +
                ", subject='" + subject + '\'' +
                ", eMails='" + eMails + '\'' +
                '}';
    }
}




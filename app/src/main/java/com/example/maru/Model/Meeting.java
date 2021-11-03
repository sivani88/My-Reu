package com.example.maru.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;

import com.example.maru.R;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class Meeting implements Parcelable {
    private long id;
    private String subject;
    private String mMail;
    private String mName;
    private String mDate;
    private String mHour;
    private boolean availability;
    private int avatarUrl;

    protected Meeting(Parcel in) {
        id = in.readLong();
        subject = in.readString();
        mMail = in.readString();
        mName = in.readString();
        mDate = in.readString();
        mHour = in.readString();
        availability = in.readByte() != 0;
        avatarUrl = in.readInt();
    }

    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {
        @Override
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        @Override
        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };

    public void setName() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(subject);
        dest.writeString(mMail);
        dest.writeString(mName);
        dest.writeString(mDate);
        dest.writeString(mHour);
        dest.writeByte((byte) (availability ? 1 : 0));
        dest.writeInt(avatarUrl);
    }

    private static class MeetingRoom {
        public int avatarUrl;
        public String mName;

        public MeetingRoom(int mAvatarUrl, String name) {
            avatarUrl = mAvatarUrl;
            mName = name;
        }
    }

    private static  List<MeetingRoom> MEETING_ROOMS = Arrays.asList(
            new MeetingRoom(R.drawable.london, "London"),
            new MeetingRoom(R.drawable.paris, "Paris"),
            new MeetingRoom(R.drawable.vienna, "Vienne"),
            new MeetingRoom(R.drawable.venise, "Venise"),
            new MeetingRoom(R.drawable.barcelona, "Barcelona"),
            new MeetingRoom(R.drawable.berlin, "Berlin"),
            new MeetingRoom(R.drawable.newyork, "NewYork"),
            new MeetingRoom(R.drawable.moscou , "Moscou"));

    public Meeting(long l, String subject,  String mail,  String date,  String hour) {
        this.subject = subject;
        mMail = mail;
        mDate = date;
        mHour = hour;
    }

    public Meeting(long id,  String subject,  String mail, String name, String date,  String hour, boolean availability,  int avatarUrl) {
        this.id = id;
        this.subject = subject;
        mMail = mail;
        mName = name;
        mDate = date;
        mHour = hour;
        this.availability = availability;
        this.avatarUrl = avatarUrl;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getMail() {
        return mMail;
    }

    public void setMail( String mail) {
        mMail = mail;
    }


    public String getName() {
        return mName;
    }

    public void setName( String name) {
        mName = name;
    }


    public String getDate() {
        return mDate;
    }

    public void setDate( String date) {
        mDate = date;
    }


    public String getHour() {
        return mHour;
    }

    public void setHour(String hour) {
        mHour = hour;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    public int getAvatarUrl() {
        for (int i = 0; i<MEETING_ROOMS.size(); i++) {
            if (MEETING_ROOMS.get(i).mName == mName)  {
                return MEETING_ROOMS.get(i).avatarUrl;
            }
        }
        return 0;

    }

    public void setAvatarUrl() {
        //this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id &&
                availability == meeting.availability &&
                avatarUrl == meeting.avatarUrl &&
                subject.equals(meeting.subject) &&
                mMail.equals(meeting.mMail) &&
                mName.equals(meeting.mName) &&
                mDate.equals(meeting.mDate) &&
                mHour.equals(meeting.mHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, mMail, mName, mDate, mHour, availability, avatarUrl);
    }

    public static DiffUtil.ItemCallback<Meeting> sItemCallback = new ItemCallback<Meeting>() {
        @Override
        public boolean areItemsTheSame( Meeting oldItem,  Meeting newItem) {

            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame( Meeting oldItem,  Meeting newItem) {
            return oldItem.equals(newItem);
        }
    };



}









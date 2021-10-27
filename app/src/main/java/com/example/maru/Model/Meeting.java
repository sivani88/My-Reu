package com.example.maru.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;

import java.util.Objects;

public class Meeting {
    private long id;
    @NonNull
    private String subject;
    @NonNull
    private String mMail;
    @NonNull
    private String mName;
    @NonNull
    private String mDate;
    @NonNull
    private String mHour;

    private boolean availability;
    @NonNull
    private String avatarUrl;


    public Meeting(long id, @NonNull String subject, @NonNull String mail, @NonNull String name, @NonNull String date, @NonNull String hour, boolean availability, @NonNull String avatarUrl) {
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

    @NonNull
    public String getSubject() {
        return subject;
    }

    public void setSubject(@NonNull String subject) {
        this.subject = subject;
    }

    @NonNull
    public String getMail() {
        return mMail;
    }

    public void setMail(@NonNull String mail) {
        mMail = mail;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }

    @NonNull
    public String getDate() {
        return mDate;
    }

    public void setDate(@NonNull String date) {
        mDate = date;
    }

    @NonNull
    public String getHour() {
        return mHour;
    }

    public void setHour(@NonNull String hour) {
        mHour = hour;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @NonNull
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(@NonNull String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id &&
                availability == meeting.availability &&
                subject.equals(meeting.subject) &&
                mMail.equals(meeting.mMail) &&
                mName.equals(meeting.mName) &&
                mDate.equals(meeting.mDate) &&
                mHour.equals(meeting.mHour) &&
                avatarUrl.equals(meeting.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, mMail, mName, mDate, mHour, availability, avatarUrl);
    }

    public static DiffUtil.ItemCallback<Meeting> sItemCallback = new ItemCallback<Meeting>() {
        @Override
        public boolean areItemsTheSame(@NonNull Meeting oldItem, @NonNull Meeting newItem) {

            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meeting oldItem, @NonNull Meeting newItem) {
            return oldItem.equals(newItem);
        }
    };





    }









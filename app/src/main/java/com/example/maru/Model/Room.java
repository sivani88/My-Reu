package com.example.maru.Model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Room {
    @NonNull
    private String mName;
    @NonNull
    private String mDate;
    @NonNull
    private String mHour;

    private boolean availability;
    @NonNull
    private String avatarUrl;

    public Room(@NonNull String name, @NonNull String date, @NonNull String hour, boolean availability, @NonNull String avatarUrl) {
        mName = name;
        mDate = date;
        mHour = hour;
        this.availability = availability;
        this.avatarUrl = avatarUrl;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public void setName(String name) {
        mName = name;
    }

    @NonNull
    public String getDate() {
        return mDate;
    }

    @NonNull
    public void setDate(String date) {
        mDate = date;
    }

    @NonNull
    public String getHour() {
        return mHour;
    }

    @NonNull
    public void setHour(String hour) {
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

    @NonNull
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return  mName == room.mName && mDate == room.mDate && mHour == room.mHour && availability == room.availability && avatarUrl == room.avatarUrl ;
    }


    @Override
    public int hashCode() {
        return Objects.hash(mName, mDate, mHour, availability, avatarUrl);
    }

    @Override
    public String toString() {
        return "Room{" +
                "mName='" + mName + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mHour='" + mHour + '\'' +
                ", availability=" + availability +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}

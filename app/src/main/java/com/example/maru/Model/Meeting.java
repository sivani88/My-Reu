package com.example.maru.Model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Meeting {
    private long id;
    @NonNull
    private String subject;
    @NonNull
    private String mMail;

    private Room mRoom;

    public Meeting(long id, String subject, String mail, Room room) {
        id = id;
        this.subject = subject;
        mMail = mail;
        mRoom = room;
    }

    public long getid() {
        return id;
    }

    public void setid(String id) {
        id = id;
    }

    @NonNull
    public String getSubject() {
        return subject;
    }

    @NonNull
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @NonNull
    public String getMail() {
        return mMail;
    }

    @NonNull
    public void setMail(String mail) {
        mMail = mail;
    }

    public Room getRoom() {
        return mRoom;
    }

    public void setRoom(Room room) {
        mRoom = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id && subject == meeting.subject && mMail == meeting.mMail && mRoom == meeting.mRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, mMail, mRoom);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", mMail='" + mMail + '\'' +
                '}';
    }
}

package com.example.gather;

public class Event {

    private String eventName;
    private String eventDescription;
    private String eventAddress; //Should this be something different for google integration?
    private long eventCost;
    private int eventMaxAttendees;
    private int eventMinAttendees;


    public Event() {
    }

    public void sendInvitation(){

    }

    public void updateRoster(){

    }

    public void updateDetails(){
        //Should this be done with setters instead of being a single function?
    }
}

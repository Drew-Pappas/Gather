package com.example.gather;

import java.util.List;

public class User {
    private String userID;
    private String userName;
    private int userAge;
    private List userHostedEvents; //Is this correct?
    private List userJoinedEvents;



    // Constructor for User class
    //Constructors allow you to create new INSTANCES of a particular object
    public User() {

    }

    //TODO Create basic constructor for user class


    public User(String userID) {
        this.userID = userID;
    }

    //Getters
    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public List getUserHostedEvents() {
        return userHostedEvents;
    }

    public List getUserJoinedEvents() {
        return userJoinedEvents;
    }


    //Setters

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public void setUserHostedEvents(List userHostedEvents) {
        this.userHostedEvents = userHostedEvents;
    }

    public void setUserJoinedEvents(List userJoinedEvents) {
        this.userJoinedEvents = userJoinedEvents;
    }

    //Class methods (functions that belong to classes that any instance can use)
    public void requestJoinEvent(){
        //Allows the user to request to join an event
    }

    public void createNewEvent(){
        //Allows the user to create a new event
    }



}

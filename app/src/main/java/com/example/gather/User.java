package com.example.gather;

import java.util.List;

public class User //Utilizes builder pattern
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // required
    private final String bio; // required
    private final List hostedEvents; // optional
    private final List joinedEvents; // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.bio = builder.bio;
        this.hostedEvents = builder.hostedEvents;
        this.joinedEvents = builder.joinedEvents;
    }

    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getBio() {
        return bio;
    }
    public List getHostedEvents() {
        return hostedEvents;
    }
    public List getJoinedEvents() {
        return joinedEvents;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.bio+", "+this.hostedEvents+", "+this.joinedEvents;
    }

    public static class UserBuilder
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String bio;
        private List hostedEvents;
        private List joinedEvents;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder bio(String bio) {
            this.bio = bio;
            return this;
        }
        public UserBuilder hostedEvents(List hostedEvents) {
            this.hostedEvents = hostedEvents;
            return this;
        }
        public UserBuilder joinedEvents(List joinedEvents) {
            this.joinedEvents = joinedEvents;
            return this;
        }
        //Return the finally constructed User object
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }

    //Class methods (functions that belong to classes that any instance can use)
    public void requestJoinEvent(){
        //Allows the user to request to join an event
    }

    public void createNewEvent(){
        //Allows the user to create a new event
    }
}
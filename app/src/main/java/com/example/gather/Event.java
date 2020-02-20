package com.example.gather;

import java.util.List;

public class Event {

    private String eventName;
    private String description;
    private String address; //Should this be something different for google integration?
    private long cost;
    private int maxAttendees;
    private int minAttendees;
    private List<User> attendees; //List of users


    private Event(EventBuilder builder) {
        this.eventName = builder.eventName;
        this.description = builder.description;
        this.address = builder.address;
        this.cost = builder.cost;
        this.maxAttendees = builder.maxAttendees;
        this.minAttendees = builder.minAttendees;
        this.attendees = builder.attendees;
    }

    //Getters
    public String getEventName(){return eventName;}
    public String getDescription(){return description;}
    public String getAddress(){return address;}
    public long getCost(){return cost;}
    public int getMaxAttendees(){return maxAttendees;}
    public int getMinAttendees(){return minAttendees;}
    public List getAttendees(){return attendees;}

    @Override
    public String toString() {
        return "Event: "+this.eventName+
                ", "+this.description+
                ", "+this.address+
                ", "+this.cost+
                ", "+this.maxAttendees+
                ", "+this.minAttendees+
                ", "+this.attendees;
    }

    public static class EventBuilder {
        private String eventName;
        private String description;
        private String address;
        private long cost;
        private int maxAttendees;
        private int minAttendees;
        private List<User> attendees;

        public EventBuilder eventName(String eventName){
            this.eventName = eventName;
            return this;
        }

        public EventBuilder description(String description){
            this.description = description;
            return this;
        }

        public EventBuilder address(String address){
            this.address = address;
            return this;
        }

        public EventBuilder cost(long cost){
            this.cost = cost;
            return this;
        }

        public EventBuilder maxAttendees(int maxAttendees){
            this.maxAttendees = maxAttendees;
            return this;
        }

        public EventBuilder minAttendees(int minAttendees){
            this.minAttendees = minAttendees;
            return this;
        }

        public EventBuilder attendees(List<User> attendees){
            this.attendees = attendees;
            return this;
        }

        public Event build() {
            Event event =  new Event(this);
            validateEventObject(event);
            return event;
        }

        private void validateEventObject(Event event) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }

    }

    //Operation methods

    public void sendInvitation(){

    }

    public void updateRoster(){

    }


}

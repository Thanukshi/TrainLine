package com.example.trainline.modal;

public class TrainScheduleModal {

    String startStation;
    String endStation;
    String departureTime;
    Float destination;
    Float ticketPrice;
    String trainType;

    //Generate Default Constructor
    public TrainScheduleModal(){

    }

    //Generate the Overload Constructor
    public TrainScheduleModal(String startStation, String endStation, String departureTime, Float destination, Float ticketPrice, String trainType) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.trainType = trainType;
    }

    //Setters and Getters

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Float getDestination() {
        return destination;
    }

    public void setDestination(Float destination) {
        this.destination = destination;
    }

    public Float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
}

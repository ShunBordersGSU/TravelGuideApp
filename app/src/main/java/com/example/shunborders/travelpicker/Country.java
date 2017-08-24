package com.example.shunborders.travelpicker;

import java.util.UUID;

/**
 * Created by shunborders on 2/28/17.
 */

public class Country {
    private UUID Id;
    private String Name;
    private String Continent;
    private String Flag;
    private String Info;
    private String Pic;
    private String Comments;
    private String Rating;


    public Country() {
        this.Id = (UUID.randomUUID());
    }

    public Country(UUID id){

        this.Id = id;
    }

    public Country(UUID id, String Name, String Continent, String Flag, String Info, String Pic){
        this.Id = id;
        this.Name = Name;
        this.Continent = Continent;
        this.Flag = Flag;
        this.Info = Info;
        this.Pic = Pic;
        this.Rating = "0.0";

    }

    public Country(String Name, String Continent, String Flag, String Info, String Pic){
        this.Id = (UUID.randomUUID());
        this.Name = Name;
        this.Continent = Continent;
        this.Flag = Flag;
        this.Info = Info;
        this.Pic = Pic;
        this.Rating = "0.0";

    }

    public UUID getId() {

        return Id;
    }

    public void setName(String Name){

        this.Name = Name;
    }

    public void setContinent(String Continent){

        this.Continent = Continent;
    }

    public void setFlag(String Flag){

        this.Flag = Flag;
    }

    public void setInfo(String Info){

        this.Info = Info;
    }

    public void setPic(String Pic){

        this.Pic = Pic;
    }

    public void setComments(String Comment){

        this.Comments = Comment;
    }

    public void setRating(String Rating){

        this.Rating = Rating;
    }

    public String getName(){

        return this.Name;
    }

    public String getContinent(){

        return this.Continent;
    }

    public String getFlag(){

        return this.Flag;
    }

    public String getInfo(){

        return this.Info;
    }

    public String getPic(){

        return this.Pic;
    }

    public String getComments(){

        return this.Comments;
    }

    public String getRating(){

        return this.Rating;
    }
}


package com.example.saravanakumar8.vitalmed.model;

/**
 * Created by saravanakumar8 on 9/9/2017.
 */

public class Datamodel {


    String hospitalname;
    String doctorname;
    String mobilename;
    String attendername;
    String date;
    String status;

    int images;


    public Datamodel() {

    }

    public Datamodel(String hospitalname, String doctorname, String mobilename, String date, String status) {
        this.hospitalname = hospitalname;
        this.doctorname = doctorname;
        this.mobilename = mobilename;
        this.attendername = attendername;
        this.date = date;
        this.status = status;
        this.images = images;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getMobilename() {
        return mobilename;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }



    public String getAttendername() {
        return attendername;
    }

    public void setAttendername(String attendername) {
        this.attendername = attendername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

}

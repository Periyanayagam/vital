package com.example.saravanakumar8.vitalmed.activeandroid;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Intel on 04-10-2017.
 */

//This is our table name
@Table(name = "Coldmodel")
public class Coldmodel extends Model {

    @Column(name = "hospitalname")
    String hospitalname;
    @Column(name = "doctorname")
    String doctorname;
    @Column(name = "mobilename")
    String mobilename;
    @Column(name = "date")
    String date;
    @Column(name = "status")
    String status;

    public Coldmodel() {
    }

    public  Coldmodel(String hospitalname, String doctorname, String mobilename, String date, String status) {
        this.hospitalname = hospitalname;
        this.doctorname = doctorname;
        this.mobilename = mobilename;
        this.date = date;
        this.status = status;
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
}

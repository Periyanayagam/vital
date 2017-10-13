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

    @Column(name = "request_id")
    String request_id;
    @Column(name = "customer_name")
    String customer_name;
    @Column(name = "contact_no")
    String contact_no;
    @Column(name = "eid")
    String eid;
    @Column(name = "equip_name")
    String equip_name;
    @Column(name = "equip_sl_no")
    String equip_sl_no;
    @Column(name = "contract_type")
    String contract_type;
    @Column(name = "sr_type")
    String sr_type;
    @Column(name = "eng_name")
    String eng_name;
    @Column(name = "status")
    String status;
    @Column(name = "problem")
    String problem;
    @Column(name = "created_dt")
    String created_dt;
    @Column(name = "groupID")
    String groupID;

    public Coldmodel() {
    }

    public Coldmodel(String request_id, String customer_name, String contact_no, String eid, String equip_name,
                     String equip_sl_no, String contract_type, String sr_type, String eng_name, String status,
                     String problem, String created_dt, String groupID) {
        this.request_id = request_id;
        this.customer_name = customer_name;
        this.contact_no = contact_no;
        this.eid = eid;
        this.equip_name = equip_name;
        this.equip_sl_no = equip_sl_no;
        this.contract_type = contract_type;
        this.sr_type = sr_type;
        this.eng_name = eng_name;
        this.status = status;
        this.problem = problem;
        this.created_dt = created_dt;
        this.groupID = groupID;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getEquip_sl_no() {
        return equip_sl_no;
    }

    public void setEquip_sl_no(String equip_sl_no) {
        this.equip_sl_no = equip_sl_no;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getSr_type() {
        return sr_type;
    }

    public void setSr_type(String sr_type) {
        this.sr_type = sr_type;
    }

    public String getEng_name() {
        return eng_name;
    }

    public void setEng_name(String eng_name) {
        this.eng_name = eng_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getCreated_dt() {
        return created_dt;
    }

    public void setCreated_dt(String created_dt) {
        this.created_dt = created_dt;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}

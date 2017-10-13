package com.example.saravanakumar8.vitalmed.Response.cold;
/**
 * Awesome Pojo Generator
 * */
public class ServiceList{
  private String eid;
  private String created_dt;
  private String groupID;
  private String equip_name;
  private String contract_type;
  private String problem;
  private String contact_no;
  private String eng_name;
  private String customer_name;
  private String sr_type;
  private String request_id;
  private String equip_sl_no;
  private String status;
  public ServiceList(){
  }
  public ServiceList(String eid,String created_dt,String groupID,String equip_name,String contract_type,String problem,String contact_no,String eng_name,String customer_name,String sr_type,String request_id,String equip_sl_no,String status){
   this.eid=eid;
   this.created_dt=created_dt;
   this.groupID=groupID;
   this.equip_name=equip_name;
   this.contract_type=contract_type;
   this.problem=problem;
   this.contact_no=contact_no;
   this.eng_name=eng_name;
   this.customer_name=customer_name;
   this.sr_type=sr_type;
   this.request_id=request_id;
   this.equip_sl_no=equip_sl_no;
   this.status=status;
  }
  public void setEid(String eid){
   this.eid=eid;
  }
  public String getEid(){
   return eid;
  }
  public void setCreated_dt(String created_dt){
   this.created_dt=created_dt;
  }
  public String getCreated_dt(){
   return created_dt;
  }
  public void setGroupID(String groupID){
   this.groupID=groupID;
  }
  public String getGroupID(){
   return groupID;
  }
  public void setEquip_name(String equip_name){
   this.equip_name=equip_name;
  }
  public String getEquip_name(){
   return equip_name;
  }
  public void setContract_type(String contract_type){
   this.contract_type=contract_type;
  }
  public String getContract_type(){
   return contract_type;
  }
  public void setProblem(String problem){
   this.problem=problem;
  }
  public String getProblem(){
   return problem;
  }
  public void setContact_no(String contact_no){
   this.contact_no=contact_no;
  }
  public String getContact_no(){
   return contact_no;
  }
  public void setEng_name(String eng_name){
   this.eng_name=eng_name;
  }
  public String getEng_name(){
   return eng_name;
  }
  public void setCustomer_name(String customer_name){
   this.customer_name=customer_name;
  }
  public String getCustomer_name(){
   return customer_name;
  }
  public void setSr_type(String sr_type){
   this.sr_type=sr_type;
  }
  public String getSr_type(){
   return sr_type;
  }
  public void setRequest_id(String request_id){
   this.request_id=request_id;
  }
  public String getRequest_id(){
   return request_id;
  }
  public void setEquip_sl_no(String equip_sl_no){
   this.equip_sl_no=equip_sl_no;
  }
  public String getEquip_sl_no(){
   return equip_sl_no;
  }
  public void setStatus(String status){
   this.status=status;
  }
  public String getStatus(){
   return status;
  }
}
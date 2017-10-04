package com.example.saravanakumar8.vitalmed.Response.cold;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ServiceList{
  @SerializedName("eid")
  @Expose
  private String eid;
  @SerializedName("created_dt")
  @Expose
  private String created_dt;
  @SerializedName("groupID")
  @Expose
  private String groupID;
  @SerializedName("equip_name")
  @Expose
  private String equip_name;
  @SerializedName("contract_type")
  @Expose
  private String contract_type;
  @SerializedName("problem")
  @Expose
  private String problem;
  @SerializedName("contact_no")
  @Expose
  private String contact_no;
  @SerializedName("eng_name")
  @Expose
  private String eng_name;
  @SerializedName("customer_name")
  @Expose
  private String customer_name;
  @SerializedName("sr_type")
  @Expose
  private String sr_type;
  @SerializedName("request_id")
  @Expose
  private String request_id;
  @SerializedName("equip_sl_no")
  @Expose
  private String equip_sl_no;
  @SerializedName("status")
  @Expose
  private String status;
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
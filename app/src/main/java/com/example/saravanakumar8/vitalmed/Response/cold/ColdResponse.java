package com.example.saravanakumar8.vitalmed.Response.cold;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class ColdResponse{
  @SerializedName("serviceList")
  @Expose
  private List<ServiceList> serviceList;
  public void setServiceList(List<ServiceList> serviceList){
   this.serviceList=serviceList;
  }
  public List<ServiceList> getServiceList(){
   return serviceList;
  }
}
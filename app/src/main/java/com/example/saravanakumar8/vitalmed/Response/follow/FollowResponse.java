package com.example.saravanakumar8.vitalmed.Response.follow;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class FollowResponse{
  private List<ServiceList> serviceList;
  public FollowResponse(){
  }
  public FollowResponse(List<ServiceList> serviceList){
   this.serviceList=serviceList;
  }
  public void setServiceList(List<ServiceList> serviceList){
   this.serviceList=serviceList;
  }
  public List<ServiceList> getServiceList(){
   return serviceList;
  }
}
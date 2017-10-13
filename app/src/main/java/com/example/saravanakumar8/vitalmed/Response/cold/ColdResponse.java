package com.example.saravanakumar8.vitalmed.Response.cold;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class ColdResponse {
    private List<ServiceList> serviceList;

    public ColdResponse() {
    }

    public ColdResponse(List<ServiceList> serviceList) {
        this.serviceList = serviceList;
    }

    public List<ServiceList> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceList> serviceList) {
        this.serviceList = serviceList;
    }
}
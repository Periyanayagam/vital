package com.example.saravanakumar8.vitalmed.Response.service;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class ServiceResponse {
    private List<ServiceList> serviceList;

    public ServiceResponse() {
    }

    public ServiceResponse(List<ServiceList> serviceList) {
        this.serviceList = serviceList;
    }

    public void setServiceList(List<ServiceList> serviceList) {
        this.serviceList = serviceList;
    }

    public List<ServiceList> getServiceList() {
        return serviceList;
    }
}
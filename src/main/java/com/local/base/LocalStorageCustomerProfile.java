package com.local.base;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LocalStorageCustomerProfile {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String languageCode;
    private String countryCode;
    private String title = null;
    private String uuid;
    private String mobileNo = null;
    private String dob = null;
    CommPref CommPrefObject;
    private String token = null;
    ArrayList<Object> addresses = new ArrayList<>();
    private String myToyotaId;
    private String tmeUuid = null;
    private String emailUuid = null;
    private String migrationType = null;
    private boolean active;
    private String hotspotIsActive = null;
    Extras ExtrasObject;
    private boolean personalDataTreatment;
    private boolean personalDataTransfer;
    private boolean personalDataSurvey;
    private String hotspotActivationStatus = null;

}

@Data
class Extras {
    private boolean hasPurchasedCars;
}

@Data
class CommPref {
    private boolean sms;
    private boolean tel;
    private boolean email;
    private boolean post;
    ArrayList<Object> emails = new ArrayList<>();
    ArrayList<Object> phones = new ArrayList<>();
    private String language;
    private boolean personalDataTreatment;
    private boolean personalDataTransfer;
    private boolean personalDataSurvey;

}

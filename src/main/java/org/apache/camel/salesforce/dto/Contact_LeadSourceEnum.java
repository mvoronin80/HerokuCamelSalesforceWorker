/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Sun Sep 03 19:42:54 EDT 2017
 */
package org.apache.camel.salesforce.dto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Salesforce Enumeration DTO for picklist LeadSource
 */
@Generated("org.apache.camel.maven.CamelSalesforceMojo")
public enum Contact_LeadSourceEnum {

    // Other
    OTHER("Other"),
    // Partner Referral
    PARTNER_REFERRAL("Partner Referral"),
    // Phone Inquiry
    PHONE_INQUIRY("Phone Inquiry"),
    // Purchased List
    PURCHASED_LIST("Purchased List"),
    // Web
    WEB("Web");

    final String value;

    private Contact_LeadSourceEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Contact_LeadSourceEnum fromValue(String value) {
        for (Contact_LeadSourceEnum e : Contact_LeadSourceEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}

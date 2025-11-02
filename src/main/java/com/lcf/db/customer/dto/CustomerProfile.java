package com.lcf.db.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_profile")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerProfile {

    @Id
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("serviceType")
    private String serviceType;

    @JsonProperty("channel")
    private String channel;

    @Embedded
    @JsonProperty("address")
    private CustomerAddress address;

}

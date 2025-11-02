package com.lcf.db.customer.controller;

import com.lcf.db.customer.dto.CustomerProfile;
import com.lcf.db.customer.dto.DeleteResponse;
import com.lcf.db.customer.service.CustomerProfileService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/pls/db/customerprofile")
public class CustomerProfileController {

    private CustomerProfileService customerProfileService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProfileController.class);

    @PostMapping(value = "/v1/profile/saveCustomerProfile", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerProfile> createPgPaymentLink(@RequestHeader Map<String, String> headers, @RequestBody CustomerProfile request) {
        CustomerProfile saved = customerProfileService.saveCustomerProfileInDds(request);
        return ResponseEntity.ok().body(saved);
    }

    @GetMapping(value = "/v1/profile/getCustomerProfile/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerProfile> getPaymentLinkDetails(
            @RequestHeader Map<String, String> headers,
            @PathVariable String customer_id) {

        LOGGER.info("customer_id : {}", customer_id);
        return ResponseEntity.ok(customerProfileService.getCustomerProfileByCustomerId(customer_id));
    }

    @DeleteMapping("/v1/profile/deleteCustomerProfile/{customerId}")
    public ResponseEntity<DeleteResponse> deleteCustomerProfile(@PathVariable String customerId) {
        LOGGER.info("customerId : {}", customerId);
        return customerProfileService.deleteCustomerProfileByCustomerId(customerId);
    }
}

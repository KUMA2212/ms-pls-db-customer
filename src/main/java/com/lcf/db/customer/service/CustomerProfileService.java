package com.lcf.db.customer.service;

import com.lcf.db.customer.common.ApplicationConstants;
import com.lcf.db.customer.dto.CustomerProfile;
import com.lcf.db.customer.dto.DeleteResponse;
import com.lcf.db.customer.exception.BaseException;
import com.lcf.db.customer.repository.CustomerProfileRepository;
import com.lcf.db.customer.utils.ApplicationUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerProfileService {

    private final CustomerProfileRepository customerRepository;

    public CustomerProfile saveCustomerProfileInDds(CustomerProfile request) {
        CustomerProfile saved = null;
        try {
            saved = customerRepository.save(request);
        } catch (Exception e) {
            ApplicationUtils.logException("LCF000422", e);
            throw new BaseException("FAILED TO CREATE CUSTOMER");
        }
        return saved;
    }

    public CustomerProfile getCustomerProfileByCustomerId(String customer_id) {
        CustomerProfile customerProfile = null;
        try {

            Optional<CustomerProfile> customer = customerRepository.findById(customer_id);
            if (customer.isPresent()) {
                customerProfile = customer.get();
            } else {
                throw new BaseException("CUSTOMER NOT FOUND");
            }
            return customerProfile;
        } catch (Exception e) {
            ApplicationUtils.logException("LCF000422", e);
            throw new BaseException("FAILED TO FETCH CUSTOMER");
        }
    }

    public ResponseEntity<DeleteResponse> deleteCustomerProfileByCustomerId(String customerId) {
        try {
            if (!customerRepository.existsById(customerId)) {
                DeleteResponse response = ApplicationUtils.setDeleteResponseRequest(customerId, ApplicationConstants.CUSTOMER_ID_NOT_FOUND, false, ApplicationConstants.STATUS_FAILURE);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                customerRepository.deleteById(customerId);
                DeleteResponse response = ApplicationUtils.setDeleteResponseRequest(customerId, ApplicationConstants.CUSTOMER_ID_DELETED_SUCCESSFULLY, true, ApplicationConstants.STATUS_SUCCESS);
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            ApplicationUtils.logException("LCF000422", e);
            throw new BaseException("FAILED TO DELETE CUSTOMER");
        }
    }

}
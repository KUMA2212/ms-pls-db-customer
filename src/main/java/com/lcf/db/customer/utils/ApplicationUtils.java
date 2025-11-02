package com.lcf.db.customer.utils;


import com.lcf.db.customer.dto.DeleteResponse;
import com.lcf.db.customer.service.CustomerProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  class ApplicationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProfileService.class);

    public static DeleteResponse setDeleteResponseRequest(String id, String message, boolean success, String status) {

        DeleteResponse response = new DeleteResponse();
        response.setId(id);
        response.setSuccess(success);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }

    public static void logException(String lcfCode, Exception e) {
        LOGGER.error("LCFErrorCode={},ErrorCause={},ErrorMessage={}", new Object[]{lcfCode, e.getMessage(), e.getCause()});
    }
}

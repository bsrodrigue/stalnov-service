package com.example.novelservice.auth.responses;

import com.example.novelservice.common.responses.SuccessResponse;
import org.springframework.http.HttpStatus;

public class AuthResponses {

    public static class CreateUserResponse extends SuccessResponse {
        public CreateUserResponse() {
            this.status = HttpStatus.CREATED;
            this.message = "User created successfully";
        }
    }

    public static class DeleteAccountResponse extends SuccessResponse {
        public DeleteAccountResponse() {
            this.status = HttpStatus.OK;
            this.message = "User account deleted successfully";
        }
    }
}

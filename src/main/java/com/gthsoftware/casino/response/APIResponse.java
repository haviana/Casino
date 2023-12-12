package com.gthsoftware.casino.response;

import com.gthsoftware.casino.utils.Constant;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class APIResponse<T> {

    // The status of the API response, indicating success or failure.
    private String status;

    // The HTTP status code associated with the API response.
    private Integer httpStatus;

    // A human-readable message providing additional information about the API response.
    private String message;

    // An internal code or identifier for the API response, aiding in error identification.
    private String internalCode;

    // The data payload included in the API response, holding the actual content.
    private T data;

    public APIResponse(String status, Integer httpStatus, String message, String internalCode, T data) {
        this.status = status;
        this.httpStatus = httpStatus;
        this.message = message;
        this.internalCode = internalCode;
        this.data = data;
    }

    public static <T> APIResponseBuilder<T> builder() {
        return new APIResponseBuilder<T>();
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Creates an APIResponse for a successful operation.
     *
     * @param data            The data to include in the response.
     * @param responseHashMap A map containing response messages.
     * @param key             The key corresponding to the desired response message.
     * @param <T>             The type of data to be included in the response.
     * @return An APIResponse indicating a successful operation.
     */
    public static <T> APIResponse<T> ok(T data, Map<String, String> responseHashMap, String key) {
        return APIResponse.<T>builder()
                .httpStatus(HttpStatus.OK.value())
                .status(Constant.RESULT_OK)
                .message(responseHashMap.get(key))
                .internalCode(key)
                .data(data)
                .build();
    }

    /**
     * Creates an APIResponse for a successful operation.
     *
     * @param data            The data to include in the response.
     * @param responseHashMap A map containing response messages.
     * @param key             The key corresponding to the desired response message.
     * @param <T>             The type of data to be included in the response.
     * @return An APIResponse indicating a successful operation.
     */
    public static <T> APIResponse<T> badRequest(T data, Map<String, String> responseHashMap, String key) {
        return APIResponse.<T>builder()
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .status(Constant.RESULT_KO)
                .message(responseHashMap.get(key))
                .internalCode(key)
                .data(data)
                .build();
    }

    /**
     * Creates an APIResponse for a successful operation.
     *
     * @param data            The data to include in the response.
     * @param responseHashMap A map containing response messages.
     * @param key             The key corresponding to the desired response message.
     * @param <T>             The type of data to be included in the response.
     * @return An APIResponse indicating a successful operation.
     */
    public static <T> APIResponse<T> notFound(T data, Map<String, String> responseHashMap, String key) {
        return APIResponse.<T>builder()
                .httpStatus(HttpStatus.NOT_FOUND.value())
                .status(Constant.RESULT_KO)
                .message(responseHashMap.get(key))
                .internalCode(key)
                .data(data)
                .build();
    }

    /**
     * Creates an APIResponse for a successful operation.
     *
     * @param data            The data to include in the response.
     * @param responseHashMap A map containing response messages.
     * @param key             The key corresponding to the desired response message.
     * @param <T>             The type of data to be included in the response.
     * @return An APIResponse indicating a successful operation.
     */
    public static <T> APIResponse<T> internalError(T data, Map<String, String> responseHashMap, String key) {
        return APIResponse.<T>builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(Constant.RESULT_KO)
                .message(responseHashMap.get(key))
                .internalCode(key)
                .data(data)
                .build();
    }
    public static class APIResponseBuilder<T> {
        private String status;
        private Integer httpStatus;
        private String message;
        private String internalCode;
        private T data;

        APIResponseBuilder() {
        }

        public APIResponseBuilder<T> status(String status) {
            this.status = status;
            return this;
        }

        public APIResponseBuilder<T> httpStatus(Integer httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public APIResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public APIResponseBuilder<T> internalCode(String internalCode) {
            this.internalCode = internalCode;
            return this;
        }

        public APIResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public APIResponse<T> build() {
            return new APIResponse<T>(this.status, this.httpStatus, this.message, this.internalCode, this.data);
        }

        public String toString() {
            return "APIResponse.APIResponseBuilder(status=" + this.status + ", httpStatus=" + this.httpStatus + ", message=" + this.message + ", internalCode=" + this.internalCode + ", data=" + this.data + ")";
        }
    }
}



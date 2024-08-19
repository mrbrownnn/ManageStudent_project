package com.fpt.booking.exception;


import com.fpt.booking.domain.payload.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;



@RestControllerAdvice
public class MultipartUploadException {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handlerFileUpload(MaxUploadSizeExceededException exception, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        return "Dung lượng của file quá 1MB. Mong người dùng kiểm tra lại";
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> handleException(IllegalArgumentException e) {
        return ResponseEntity.ok(MessageResponse.builder().message("Đăng nhập để sử dụng chức năng.").build());
    }

    @ExceptionHandler({ BadRequestException.class })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.ok(MessageResponse.builder().message("Forbidden.").build());
    }
}

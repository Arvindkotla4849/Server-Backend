package com.example.jpabookarental.jpademo.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomResponseHandler extends ResponseEntityExceptionHandler
{
    @Deprecated
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity handleEntityNotFound(UserNotFound exception, WebRequest request)
    {
        String date = new java.util.Date().toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(date, exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Deprecated
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
    {
        String date=new java.util.Date().toString();
        ExceptionResponse exceptionResponse=new ExceptionResponse( date,ex.getMessage(),request.getDescription(false));
        return  new ResponseEntity(exceptionResponse ,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @Deprecated
    @ExceptionHandler(DuplicateFound.class)
    public ResponseEntity handleEntityFound(DuplicateFound duplicateFound, WebRequest request){
        String date=new java.util.Date().toString();
        ExceptionResponse exceptionResponse=new ExceptionResponse(date, duplicateFound.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse ,HttpStatus.ALREADY_REPORTED);
    }


    @Override
    @Deprecated
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        String date=new Date().toString();
        ExceptionResponse response=new ExceptionResponse( date,ex.getMessage(),ex.getBindingResult().getFieldError().getDefaultMessage());
       // response.setMessage("authorname and booktitle should not be null");
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }

}

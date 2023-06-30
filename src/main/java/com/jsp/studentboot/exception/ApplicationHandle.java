package com.jsp.studentboot.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.studentboot.config.ResponceStructure;

@RestControllerAdvice
public class ApplicationHandle extends ResponseEntityExceptionHandler {
    @ExceptionHandler
	public ResponseEntity<ResponceStructure<String>> StudentNotFoundById(StudentNotFoundByIdException ex){
		ResponceStructure<String> responceStructure=new ResponceStructure<>();
		responceStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage(ex.getMessage());
		responceStructure.setData("Student Object with given Id is not present");
    	return new ResponseEntity<ResponceStructure<String>>(responceStructure,HttpStatus.NOT_FOUND);
    	
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	// Accepting all the errors comming from the postman and saving it inside a list<ObjectError>
    	List<ObjectError> errorlist=ex.getAllErrors();
    	//we are declaring a map so that we can print / display the data in key and value pair
    	//<field,message>
    	HashMap<String,String> errorMap = new HashMap<String,String>();
    	for(ObjectError error:errorlist) {
    		//here downcasted to fieldError type because we also need to get field 
    		//name which we can get using a method of fieldError (classes) i.e fieldError.getField()
    		FieldError fieldError = (FieldError) error;
    		//here er are getting the field 
    		String field= fieldError.getField();
    		//with the help of this getdefaultmessage() method we are getting a message that we have
    		//we have given over the field validation 
    		String meesage = error.getDefaultMessage();
    		//and here we are adding the key and value to the map we have created 
    		errorMap.put(field, meesage);
    	}
    	//returning the map 
    	return new ResponseEntity<Object>(errorMap,HttpStatus.NOT_FOUND);
    }
    
}

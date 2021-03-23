package com.microservice.vehicles.infrastructure.rest.spring.exception;

public class UnsuccessfullyException extends Exception {
  public UnsuccessfullyException(){
    super("Connection return an unsuccessfully response");
  }

  public UnsuccessfullyException(String message){
    super(message);
  }
}

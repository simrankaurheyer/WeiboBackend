package com.niit.project2.model;

import javax.persistence.Transient;

public class BaseDomain 
{    @Transient
       private String message;

      public String getMessage() {
    	  return message;
      }
      
      public void setMessage(String message) {
    	  this.message=message;
      }
       
	
}

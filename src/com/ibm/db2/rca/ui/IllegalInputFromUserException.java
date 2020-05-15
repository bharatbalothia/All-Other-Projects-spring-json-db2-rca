package com.ibm.db2.rca.ui;

public class IllegalInputFromUserException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1912517850517237545L;
	
    public IllegalInputFromUserException() 
    {
        super();
    }
    
    public IllegalInputFromUserException(String message) 
    {
        super(message);
    }

    public IllegalInputFromUserException(String message, Throwable throwable) 
    {
        super(message, throwable);        
    }
    
    public IllegalInputFromUserException(Throwable cause) 
    {
        super(cause);
    }
	
}

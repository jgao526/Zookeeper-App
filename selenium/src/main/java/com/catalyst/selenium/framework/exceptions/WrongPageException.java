package com.catalyst.selenium.framework.exceptions;

public class WrongPageException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public WrongPageException()
    {
    	super();
    }

    public WrongPageException(String message)
    {
    	super(message);
    }
}

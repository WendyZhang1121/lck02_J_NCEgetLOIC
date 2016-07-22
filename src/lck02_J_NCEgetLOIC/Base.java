package lck02_J_NCEgetLOIC;

import java.text.DateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

class Base {

	static DateFormat format =DateFormat.getDateInstance(DateFormat.MEDIUM);

	public Date parse(String str) throws ParseException, java.text.ParseException { 
		synchronized (getClass()) { // Synchronizes on Base.class
			return format.parse(str); 
			}
	}

	public Date doSomething(String str) throws ParseException, java.text.ParseException { 
		return new Helper().doSomethingAndParse(str);
	}
	
	private class Helper {
		public Date doSomethingAndParse(String str) throws ParseException, java.text.ParseException {
			synchronized (getClass()) { // Synchronizes on Helper.class // ...
			return format.parse(str); 
			}
		}
	}
}
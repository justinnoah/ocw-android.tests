package org.osuosl.ocw.test;

import java.util.Date;

import org.osuosl.ocw.Schedule;

import android.test.ActivityInstrumentationTestCase2;

public class ScheduleFunctionsTests extends
ActivityInstrumentationTestCase2<Schedule> {


	private Schedule sc;

	public ScheduleFunctionsTests() {
		super(null, Schedule.class);
	}

	@Override
	public void setUp() throws Exception{
		super.setUp();
		sc = getActivity();
	}
	
	
	
	
	public void test_getDayAsString(){
		Date date;
		String expectedDate;
		String returnedDate;
		boolean result;
		
		//Create a date, Monday 16th September 2013
		date = new Date(2012,8,16);
		//Write it using the format manually (E, MMMM d)
		expectedDate = "Mon, September 16";
		//See what our method returns
		returnedDate = sc.getDayAsString(date);
		//Check it matches
		result = returnedDate.equals(expectedDate);
		assertTrue(result);
		
	}


	public void test_isSameDay(){
		Date date1;
		Date date2;
		boolean result;
		
		date1 = new Date(1990,1,1);
		date2 = new Date(date1.getTime());
		
		//check that both dates are the same
		assertEquals(date1.getTime(), date2.getTime());
		
		//see if our method also says they're the same
		result = sc.isSameDay(date1,date2);
		assertTrue(result);
		
		//change the date +1 day
		date2 = new Date(1990,1,2);
		//check they're no longer the same
		boolean result2 = date1.getTime() == date2.getTime();
		assertFalse(result2);
		//check we no longer say they're the same
		result = sc.isSameDay(date1,date2);
		assertFalse(result);
		
		//Only date1 == null
		date1 = null;
		try{
			result = sc.isSameDay(date1,date2);
		} catch (IllegalArgumentException e){
				result = false;
		}
		assertFalse(result);
		
		//Both == null
		date2 = null;
		try{
			result = sc.isSameDay(date1,date2);
		} catch (IllegalArgumentException e){
				result = false;
		}
		assertFalse(result);
		
		//Only date2 == null
		date1 = new Date();
		try{
			result = sc.isSameDay(date1,date2);
		} catch (IllegalArgumentException e){
				result = false;
		}
		assertFalse(result);
		
	}
	
	
	
	
	public void test_SharedPreferences(){
		String key = "keyValue";
		String value = "dataValue";
		String retrievedValue;
		String noExist = "Doesn't exist";
		String emptyString = "";
		boolean success;
		
		success = sc.putPref(key,value);
		assertTrue(success);
		retrievedValue = sc.getPref(key);
		assertEquals(value, retrievedValue);
		
		key = null;
		value = null;
		
		success = sc.putPref(key,value);
		assertFalse(success);
		retrievedValue = sc.getPref(noExist);
		assertEquals(emptyString, retrievedValue);
		
	}
}

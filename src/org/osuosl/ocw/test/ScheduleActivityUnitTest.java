package org.osuosl.ocw.test;

import org.osuosl.ocw.Schedule;

import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

public class ScheduleActivityUnitTest extends android.test.ActivityUnitTestCase<Schedule> {
	
	
	private Schedule activity;
	
	
	private int descriptionId;
	
	public ScheduleActivityUnitTest() {
		super(Schedule.class);
	}
	
	
	@Override
	 protected void setUp() throws Exception {
	    super.setUp();
	    Intent intent = new Intent(getInstrumentation().getTargetContext(),
	        Schedule.class);
	    startActivity(intent, null, null);
	    activity = getActivity();
	  }
	
	
	@SmallTest
	 public void testDescription() {
	    
	    descriptionId = org.osuosl.ocw.R.id.description;
	    assertNotNull(activity.findViewById(descriptionId));
	    TextView view = (TextView) activity.findViewById(descriptionId);
	    
	    
	    
	    
	    
	  }
	
	
	
	
	
	
	
	
}

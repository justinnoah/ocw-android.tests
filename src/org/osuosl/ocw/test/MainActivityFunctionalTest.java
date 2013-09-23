package org.osuosl.ocw.test;

import org.osuosl.ocw.Main;
import org.osuosl.ocw.Schedule;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

public class MainActivityFunctionalTest extends
ActivityInstrumentationTestCase2<Main> {

	private Main activity;

	public MainActivityFunctionalTest() {
		super(null, Main.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		activity = getActivity();
	}
	
	@SmallTest
	public void testIntentTriggered(){
		
		ActivityMonitor monitor = getInstrumentation().addMonitor(Schedule.class.getName(), null, false);
		Schedule startedActivity = (Schedule) monitor
		        .waitForActivityWithTimeout(2000);
		    assertNotNull(startedActivity);
		
	}
}


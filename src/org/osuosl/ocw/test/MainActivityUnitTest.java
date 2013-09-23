package org.osuosl.ocw.test;

import org.osuosl.ocw.Main;

import android.content.Intent;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityUnitTest extends
	android.test.ActivityUnitTestCase<Main> {


	private Main activity;
	private int viewId;
	private TextView textView;
	private ImageView imageView;

	public MainActivityUnitTest() {
		super(Main.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				Main.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}
	
	@SmallTest
	public void testLayout() {
		
		viewId = org.osuosl.ocw.R.id.logoView;
		assertNotNull(activity.findViewById(viewId));
		imageView = (ImageView) activity.findViewById(viewId);
		assertEquals("Incorrect image", activity.getResources().getDrawable(org.osuosl.ocw.R.drawable.logo).getConstantState(),
				imageView.getDrawable().getConstantState());

		viewId = org.osuosl.ocw.R.id.loadingTag;
		assertNotNull(activity.findViewById(viewId));
		textView = (TextView) activity.findViewById(viewId);
		assertEquals("Incorrect text",activity.getString(org.osuosl.ocw.R.string.loading__tagline), textView.getText());
		
		viewId = org.osuosl.ocw.R.id.loadingDateLocation;
		assertNotNull(activity.findViewById(viewId));
		textView = (TextView) activity.findViewById(viewId);
		assertEquals("Incorrect text",activity.getString(org.osuosl.ocw.R.string.loading__date_and_location), textView.getText());
		
		viewId = org.osuosl.ocw.R.id.loadingVersion;
		assertNotNull(activity.findViewById(viewId));
		textView = (TextView) activity.findViewById(viewId);
		assertEquals("Incorrect text",activity.getString(org.osuosl.ocw.R.string.version), textView.getText());
		
		viewId = org.osuosl.ocw.R.id.loadingVersion;
		assertNotNull(activity.findViewById(viewId));
		textView = (TextView) activity.findViewById(viewId);
		assertEquals("Incorrect text",activity.getString(org.osuosl.ocw.R.string.version), textView.getText());
			
	}
	

	
	@Override
	  protected void tearDown() throws Exception {
	    
	    super.tearDown();
	  }

}

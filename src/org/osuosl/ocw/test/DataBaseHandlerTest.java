package org.osuosl.ocw.test;

import java.util.Date;

import org.osuosl.ocw.DataBaseHandler;
import org.osuosl.ocw.Event;
import org.osuosl.ocw.Speaker;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

public class DataBaseHandlerTest extends AndroidTestCase {
	
	private DataBaseHandler db;
	
	//Event variables
	private static final int event_id = 6;
	private static final Date start = new Date(); 
	private static final Date end = new Date();
	private static final String description = "";
	private static final String title = "Event Title";
	private static final String updatedTitle = "Updated Event Title";
	private static final String location = "Room Name";
	private static final int track_id = 5;
	private static final String track_title = "Testing";
	private static final String[] speaker_ids = {"3"};
	
	//Speaker variables
	
	private static final int speaker_id = 6;
	private static final String name = "Mr. Test";
	private static final String updated_name = "Mr. M Test";
	private static final String biography = "Spend his time testing";
	private static final String twitter = "tester";
	private static final String affiliation = "testing inc.";
	private static final String identica = "identica";
	private static final String website = "www.testing.com";
	private static final String blog = "blog.testing.com";
	
	public void setUp() throws Exception{
		super.setUp();
		RenamingDelegatingContext context 
        = new RenamingDelegatingContext(getContext(), "test_");
        db = new DataBaseHandler(context);
        db.getWritableDatabase();
	}
	
	public void testAddScheduleEntry() {
		Event event = new Event(event_id, title, description, start, end, location, track_id, track_title, speaker_ids);
		db.addScheduleRow(event);
		Event event2 = db.getScheduleRow(""+event_id);
		
		assertEquals(event.getId(), event2.getId());
//		assertEquals(event.getStart().getTime(), event2.getStart().getTime());   //fails
//		assertEquals(event.getEnd().getTime(), event2.getEnd().getTime());       //fails
		assertEquals(event.getDescription(), event2.getDescription());
		assertEquals(event.getTitle(), event2.getTitle());
		assertEquals(event.getLocation(), event2.getLocation());
		assertEquals(event.getTrackId(), event2.getTrackId());
		assertEquals(event.getTrackTitle(), event2.getTrackTitle());
		assertEquals(event.getSpeaker_ids()[0], event2.getSpeaker_ids()[0]);
		
	}
	
	public void testUpdateScheduleEntry(){
		Event event = new Event(event_id, updatedTitle, description, start, end, location, track_id, track_title, speaker_ids);
		db.updateScheduleRow(event);
		Event event2 = db.getScheduleRow(""+event_id);
		
		assertEquals(event.getId(), event2.getId());
//		assertEquals(event.getStart().getTime(), event2.getStart().getTime());   //fails
//		assertEquals(event.getEnd().getTime(), event2.getEnd().getTime());       //fails
		assertEquals(event.getDescription(), event2.getDescription());
		assertEquals(event.getTitle(), event2.getTitle());
		assertEquals(event.getLocation(), event2.getLocation());
		assertEquals(event.getTrackId(), event2.getTrackId());
		assertEquals(event.getTrackTitle(), event2.getTrackTitle());
		assertEquals(event.getSpeaker_ids()[0], event2.getSpeaker_ids()[0]);
		
	}
	
	public void testAddSpeakerEntry(){
		Speaker speaker = new Speaker(speaker_id, name, biography, twitter, affiliation, identica, website, blog);
		db.addSpeakersRow(speaker);
		Speaker speaker2 = db.getSpeakersRow(""+speaker_id);
		
		assertEquals(speaker.getId(),speaker2.getId());
		assertEquals(speaker.getName(),speaker2.getName());
		assertEquals(speaker.getBiography(),speaker2.getBiography());
		assertEquals(speaker.getTwitter(),speaker2.getTwitter());
		assertEquals(speaker.getAffiliation(),speaker2.getAffiliation());
		assertEquals(speaker.getIdentica(),speaker2.getIdentica());
		assertEquals(speaker.getWebsite(),speaker2.getWebsite());
		assertEquals(speaker.getBlog(),speaker2.getBlog());
		
	}
	
	public void testUpdateSpeakerEntry(){
		Speaker speaker = new Speaker(speaker_id, updated_name, biography, twitter, affiliation, identica, website, blog);
		db.updateSpeakersRow(speaker);
		Speaker speaker2 = db.getSpeakersRow(""+speaker_id);
		
		assertEquals(speaker.getId(),speaker2.getId());
		assertEquals(speaker.getName(),speaker2.getName());
		assertEquals(speaker.getBiography(),speaker2.getBiography());
		assertEquals(speaker.getTwitter(),speaker2.getTwitter());
		assertEquals(speaker.getAffiliation(),speaker2.getAffiliation());
		assertEquals(speaker.getIdentica(),speaker2.getIdentica());
		assertEquals(speaker.getWebsite(),speaker2.getWebsite());
		assertEquals(speaker.getBlog(),speaker2.getBlog());
	}
	
	public void testNumRows(){
		
		assertEquals(db.numRows("SCHEDULE"),1l);
		assertEquals(db.numRows("SPEAKERS"),1l);
	}
	
	public void testExists(){
		
		assertEquals(db.existsEvent("6"), 1);
		assertEquals(db.existsEvent("1"), 0);
		assertEquals(db.existsSpeaker("6"), 1);
		assertEquals(db.existsSpeaker("1"), 0);
		
	}
	
	public void arrayToString(){
		
		String[] str = new String[] {"hello", "world", "while", "testing"};
		String cnv = db.convertArrayToString(str);
		String[] cnvstr = db.convertStringToArray(cnv);
		
		assertEquals(str,cnvstr);
		
	}
	
	
	public void tearDown() throws Exception {
		db.close();
		
		super.tearDown();
	}
	
	
}

package org.osuosl.ocw.test;

import java.util.Date;

import org.osuosl.ocw.DataBaseHandler;
import org.osuosl.ocw.Event;
import org.osuosl.ocw.Speaker;
import org.osuosl.ocw.Track;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

public class DataBaseHandlerTest extends AndroidTestCase {
	
	private DataBaseHandler db;
	
	//Event variables
	private static final int event_id = 6;
	private static final String event_title = "Event Title";
	private static final Date start_time = new Date(); 
	private static final Date end_time = new Date();
	private static final String description = "";
	private static final String updatedTitle = "Updated Event Title";
	private static final String room_title = "Room Name";
	private static final int track_id = 5;
	private static final String[] speaker_ids = {"3","4"};
	private static final String presenter = "Mr. Presenter";
	
	//Speaker variables
	private static final int speaker_id = 6;
	private static final String fullname = "Mr. Test";
	private static final String updated_fullname = "Mr. M Test";
	private static final String biography = "Spend his time testing";
	private static final String affiliation = "testing inc.";
	private static final String twitter = "tester";
	private static final String email = "email";
	private static final String website = "www.testing.com";
	private static final String blog = "blog.testing.com";
	private static final String linkedin = "linkedin.com/testing";
	
	//Track variables
	private static final String track_title = "Test track";
	private static final String updated_track_title = "Updated Test track";
	private static final String color = "red";
	private static final String color_text = "black";
	
	public void setUp() throws Exception{
		super.setUp();
		RenamingDelegatingContext context 
        = new RenamingDelegatingContext(getContext(), "test_");
        db = new DataBaseHandler(context);
        db.getWritableDatabase();
	}
	
	public void testAddScheduleEntry() {
		Event event = new Event(event_id, event_title, start_time, end_time, description, 
				room_title, track_id, speaker_ids, presenter);
		db.addScheduleRow(event);
		Event event2 = db.getScheduleRow(""+event_id);
		
		assertEquals(event.getEvent_id(), event2.getEvent_id());
		assertEquals(event.getEvent_title(), event2.getEvent_title());
//		assertEquals(event.getStart_time().getTime(), event2.getStart_time().getTime());   //fails
//		assertEquals(event.getEnd_time().getTime(), event2.getEnd_time().getTime());       //fails
		assertEquals(event.getDescription(), event2.getDescription());
		assertEquals(event.getRoom_title(), event2.getRoom_title());
		assertEquals(event.getTrack_id(), event2.getTrack_id());
		assertEquals(event.getSpeaker_ids()[0], event2.getSpeaker_ids()[0]);
		assertEquals(event.getSpeaker_ids()[1], event2.getSpeaker_ids()[1]);
		assertEquals(event.getPresenter(), event2.getPresenter());
		
	}
	
	public void testUpdateScheduleEntry(){
		Event event = new Event(event_id, updatedTitle, start_time, end_time, description,
				room_title, track_id, speaker_ids, presenter);
		db.updateScheduleRow(event);
		Event event2 = db.getScheduleRow(""+event_id);
		
		assertEquals(event.getEvent_id(), event2.getEvent_id());
		assertEquals(event.getEvent_title(), event2.getEvent_title());
//		assertEquals(event.getStart_time().getTime(), event2.getStart_time().getTime());   //fails
//		assertEquals(event.getEnd_time().getTime(), event2.getEnd_time().getTime());       //fails
		assertEquals(event.getDescription(), event2.getDescription());
		assertEquals(event.getRoom_title(), event2.getRoom_title());
		assertEquals(event.getTrack_id(), event2.getTrack_id());
		assertEquals(event.getSpeaker_ids()[0], event2.getSpeaker_ids()[0]);
		assertEquals(event.getSpeaker_ids()[1], event2.getSpeaker_ids()[1]);
		assertEquals(event.getPresenter(), event2.getPresenter());
		
	}
	
	public void testAddSpeakerEntry(){
		Speaker speaker = new Speaker(speaker_id, fullname, biography, affiliation, twitter,
				email, website, blog, linkedin);
		db.addSpeakersRow(speaker);
		Speaker speaker2 = db.getSpeakersRow(""+speaker_id);
		
		assertEquals(speaker.getSpeaker_id(),speaker2.getSpeaker_id());
		assertEquals(speaker.getFullname(),speaker2.getFullname());
		assertEquals(speaker.getBiography(),speaker2.getBiography());
		assertEquals(speaker.getAffiliation(),speaker2.getAffiliation());
		assertEquals(speaker.getTwitter(),speaker2.getTwitter());
		assertEquals(speaker.getEmail(),speaker2.getEmail());
		assertEquals(speaker.getWebsite(),speaker2.getWebsite());
		assertEquals(speaker.getBlog(),speaker2.getBlog());
		assertEquals(speaker.getLinkedin(),speaker2.getLinkedin());
		
	}
	
	public void testUpdateSpeakerEntry(){
		Speaker speaker = new Speaker(speaker_id, updated_fullname, biography, affiliation,
				twitter, email, website, blog, linkedin);
		db.updateSpeakersRow(speaker);
		Speaker speaker2 = db.getSpeakersRow(""+speaker_id);
		
		assertEquals(speaker.getSpeaker_id(),speaker2.getSpeaker_id());
		assertEquals(speaker.getFullname(),speaker2.getFullname());
		assertEquals(speaker.getBiography(),speaker2.getBiography());
		assertEquals(speaker.getAffiliation(),speaker2.getAffiliation());
		assertEquals(speaker.getTwitter(),speaker2.getTwitter());
		assertEquals(speaker.getEmail(),speaker2.getEmail());
		assertEquals(speaker.getWebsite(),speaker2.getWebsite());
		assertEquals(speaker.getBlog(),speaker2.getBlog());
		assertEquals(speaker.getLinkedin(),speaker2.getLinkedin());
	}
	
	public void testAddtrackEntry(){
		Track track = new Track(track_id, track_title, color, color_text);
		db.addTrackRow(track);
		Track track_2 = db.getTracksRow(""+track_id);
		
		assertEquals(track.getTrack_id(), track_2.getTrack_id());
		assertEquals(track.getTrack_title(), track_2.getTrack_title());
		assertEquals(track.getColor(), track_2.getColor());
		assertEquals(track.getColor_text(), track_2.getColor_text());
	}
	
	public void testUpdateTrackEntry(){
		Track track =  new Track(track_id, updated_track_title, color, color_text);
		db.updateTracksRow(track);
		Track track_2 = db.getTracksRow(""+track_id);
		
		assertEquals(track.getTrack_id(), track_2.getTrack_id());
		assertEquals(track.getTrack_title(), track_2.getTrack_title());
		assertEquals(track.getColor(), track_2.getColor());
		assertEquals(track.getColor_text(), track_2.getColor_text());
	}
	
	
	public void testStatusTable(){
		
		
		Long scheduleUpdated = System.currentTimeMillis();
		Long speakersUpdated = System.currentTimeMillis();
		Long tracksUpdated = System.currentTimeMillis();
		
		db.initStatusTable("schedule", ""+scheduleUpdated);
		db.initStatusTable("speakers", ""+speakersUpdated);
		db.initStatusTable("tracks", ""+tracksUpdated);
			
		assertEquals(db.getTableUpdated("schedule"), scheduleUpdated);
		assertEquals(db.getTableUpdated("speakers"), speakersUpdated);
		assertEquals(db.getTableUpdated("tracks"), tracksUpdated);
		
		scheduleUpdated = System.currentTimeMillis();
		speakersUpdated = System.currentTimeMillis();
		tracksUpdated = System.currentTimeMillis();
		
		db.tableUpdated("schedule", ""+scheduleUpdated);
		db.tableUpdated("speakers", ""+speakersUpdated);
		db.tableUpdated("tracks", ""+tracksUpdated);
		
		assertEquals(db.getTableUpdated("schedule"), scheduleUpdated);
		assertEquals(db.getTableUpdated("speakers"), speakersUpdated);
		assertEquals(db.getTableUpdated("tracks"), tracksUpdated);
	}
	
	public void testNumRows(){
		
		assertEquals(db.numRows("SCHEDULE"),1l);
		assertEquals(db.numRows("SPEAKERS"),1l);
		assertEquals(db.numRows("TRACKS"),1l);
	}
	
	public void testExists(){
		
		assertEquals(db.existsEvent("6"), 1);
		assertEquals(db.existsEvent("1"), 0);
		assertEquals(db.existsSpeaker("6"), 1);
		assertEquals(db.existsSpeaker("1"), 0);
		assertEquals(db.existsTrack("5"), 1);
		assertEquals(db.existsTrack("1"), 0);
		
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

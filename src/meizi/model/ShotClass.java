package meizi.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import meizi.serialization.MyDateDeserializer;
import meizi.serialization.MyDateSerializer;
import meizi.serialization.MyTimeDeserializer;
import meizi.serialization.MyTimeSerializer;

public class ShotClass {
	public ShotClass(){
		
	}

	/*
	 * 4.1 Title
	 */
	public TitleClass Title;
	public static class TitleClass{
		/*
		 * 4.1.1 Shot Title 
		 */
		public String ShotTitle;
	}
	
	/*
	 * 4.2 Subject
	 */
	public SubjectClass Subject;
	public static class SubjectClass{
		/*
		 * 4.2.1 Subject term
		 */
		public List<String> SubjectTerm;
		/*
		 * 4.2.2 Keyword
		 */
		public List<String> Keyword;
	}
	
	/*
	 * 4.3 Description
	 */
	public DescriptionClass Description;
	public static class DescriptionClass{
		/*
		 * 4.3.1 Description of Content
		 */
		public String DescriptionofContent;
		/*
		 * 4.3.2 Shooting Place
		 */
		public String ShootingPlace;
		/*
		 * 4.3.3 Camera Motion
		 */
		public List<String> CameraMotion;
		/*
		 * 4.3.4 Scene Range
		 */
		public List<String> SceneRange;
		/*
		 * 4.3.5 Camera Angle
		 */
		public List<String> CameraAngle;
		/*
		 * 4.3.6 Natural Sound
		 */
		public String NaturalSound;
	}
	
	/*
	 * 4.4 Date
	 */
	@JsonProperty(value = "Date")
	public DateClass myDate;
	public static class DateClass{
		/*
		 * 4.4.1 Shooting Date
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date ShootingDate;
	}
	
	/*
	 * 4.5 Format
	 */
	public FormatClass Format;
	public static class FormatClass {
		/*
		 * 4.5.1 Duration
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date Duration;
		/*
		 * 4.5.2 Starting Point
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date StartingPoint;
	}
	
	/*
	 * 4.6 Relation
	 */
	public RelationClass Relation;
	public static class RelationClass{

		/*
		 * 4.6.1 Is Part of 
		 */
		public String IsPartof;
		/*
		 * 4.6.2 References 
		 */
		public List<String> References;
	}

}

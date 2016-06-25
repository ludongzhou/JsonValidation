package meizi.model;

import java.util.Date;
import java.util.List;

import meizi.serialization.MyDateDeserializer;
import meizi.serialization.MyDateSerializer;
import meizi.serialization.MyTimeDeserializer;
import meizi.serialization.MyTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SceneClass {
	public SceneClass(){
		
	}
	
	/*
	 * 3.1 Title
	 */
	public TitleClass Title;
	public static class TitleClass{
		/*
		 * 3.1.1 Scene Title
		 */
		public String SceneTitle;
	}
	
	/*
	 * 3.2 Subject
	 */
	public SubjectClass Subject;
	public static class SubjectClass{
		/*
		 * 3.2.1 Subject term
		 */
		public List<String> SubjectTerm;
		/*
		 * 3.2.2 Keyword
		 */
		public List<String> Keyword;
	}
	
	/*
	 * 3.3 Description
	 */
	public DescriptionClass Description;
	public static class DescriptionClass{
		/*
		 * 3.3.1 Description of Content
		 */
		public String DescriptionofContent;
		/*
		 * 3.3.2 Date of Event 
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date DateofEvent;		
		/*
		 * 3.3.3 Natural Sound
		 */
		public String NaturalSound;
	}
	
	/*
	 * 3.4 Format
	 */
	public List<FormatClass> Format;
	public static class FormatClass {
		/*
		 * 3.4.1 Duration
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date Duration;
		/*
		 * 3.4.2 Starting Point
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date StartingPoint;
		/*
		 * 3.4.3 Subtitle Form
		 */
		public String SubtitleForm;
	}
	
	/*
	 * 3.5 Relation
	 */
	public List<RelationClass> Relation;
	public static class RelationClass{

		/*
		 * 3.5.1 Is Part of 
		 */
		public String IsPartof;
		/*
		 * 3.5.2 References 
		 */
		public List<String> References;
	}

	
}

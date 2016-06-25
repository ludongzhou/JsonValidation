package meizi.model;

import java.util.Date;
import java.util.List;

import meizi.serialization.MyDateDeserializer;
import meizi.serialization.MyDateSerializer;
import meizi.serialization.MyTimeDeserializer;
import meizi.serialization.MyTimeSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SequenceClassAlone {
	public SequenceClassAlone(){
		
	}
	
	/*
	 * 2.1 Title
	 */

	public TitleClass Title;
	public static class TitleClass {
		/*
		 * 2.1.1 Proper Title
		 */
		public String ProperTitle;
		
		/*
		 * 2.1.2 Parallel Proper Title
		 */
		public List<String> ParallelProperTitle;
		
		/*
		 * 2.1.3 Series Title
		 */
		public String SeriesTitle;
	}
	
	/*
	 * 2.2 Subject
	 */
	public SubjectClass Subject;
	public static class SubjectClass{
		/*
		 * 2.1.1 Class
		 */
		@JsonProperty(value = "Class")
		public List<ClassClass> myClass;            ////////////
		public static class ClassClass{
			/*
			 * 2.1.1.1 Classification
			 */
			public String Classification;
			/*
			 * 2.1.1.2 Class Number
			 */
			public String ClassNumber;
		}

		/*
		 * 2.1.2 Subject Term
		 */
		public List<String> SubjectTerm;
		/*
		 * 2.1.3 Keyword
		 */
		public List<String> Keyword;
	}
	
	/*
	 * 2.3 Description
	 */
	public DescriptionClass Description;
	public static class DescriptionClass{
		/*
		 * 2.3.1 Description of Content
		 */
		public String DescriptionofContent;
		/*
		 * 2.3.2 Date of Event
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date DateofEvent;
		/*
		 * 2.3.3 Awards
		 */
		public List<AwardsClass> Awards;
		public static class AwardsClass{
			/*
			 * 2.3.3.1 Name of Awards
			 */
			public String NameofAwards;
			/*
			 * 2.3.3.2 Item of Awards
			 */
			public String ItemofAwards;
			/*
			 * 2.3.3.3 Winners of Awards
			 */
			public List<String> WinnersofAwards;
			/*
			 * 2.3.3.4 Year or Time of Awards
			 */
			public Integer YearorTimeofAwards;
			/*
			 * 2.3.3.5 Date of Awards
			 */
			@JsonSerialize(using = MyDateSerializer.class)
			@JsonDeserialize(using = MyDateDeserializer.class)
			public Date DateofAwards;
		}
		
		/*
		 * 2.3.4 Natural Sound
		 */
		public String NaturalSound;
	
	}
	
	/*
	 * 2.4 Creator
	 */
	public CreatorClass Creator;
	public static class CreatorClass{
		/*
		 * 2.4.1 Description of Creator
		 */
		public List<DescriptionofCreatorClass> DescriptionofCreator;
		public static class DescriptionofCreatorClass{
			/*
			 * 2.4.1.1 Name of Creator
			 */
			public String NameofCreator;
			/*
			 * 2.4.1.2 Parallel Name of Creator
			 */
			public List<String> ParallelNameofCreator;
			/*
			 * 2.4.1.3 Role
			 */
			public String Role;
			/*
			 * 2.4.1.4 Other Information
			 */
			public String OtherInformation;
		}
		
	}
	
	/*
	 * 2.5 Contributor
	 */
	public ContributorClass Contributor;
	public static class ContributorClass{
		/*
		 * 2.5.1 Description Of Contributor
		 */
		public List<DescriptionofContributorClass> DescriptionofContributor;
		public static class DescriptionofContributorClass{
			/*
			 * 2.5.1.1 Name Of Contributor
			 */
			public String NameofContributor;
			/*
			 * 2.5.1.2 Parallel Name Of Contributor
			 */
			public List<String> ParallelNameofContributor;
			/*
			 * 2.5.1.3 Role
			 */
			public String Role;
			/*
			 * 2.5.1.4 Other Information
			 */
			public String OtherInformation;
		}
		
		
	}
	
	/*
	 * 1.6 Publisher
	 */
	public PublisherClass Publisher;
	public static class PublisherClass{
		/*
		 * 2.6.1 Description Of Publisher
		 */
		public List<DescriptionofPublisherClass> DescriptionofPublisher;
		public static class DescriptionofPublisherClass{
			/*
			 * 2.6.1.1 Name Of Publisher
			 */
			public String NameofPublisher;
			/*
			 * 2.6.1.2 Place of Publisher
			 */
			public String PlaceofPublisher;
		}
		
		
		/*
		 * 2.6.2 Description of Producer
		 */
		public List<DescriptionofProducerClass> DescriptionofProducer;
		public static class DescriptionofProducerClass{
			/*
			 * 2.6.2.1 Name of Producer
			 */
			public String NameofProducer;
			/*
			 * 2.6.2.2 Place of Production
			 */
			public String PlaceofProduction;
		}
		
		
	}
	
	/*
	 * 2.7 Copyright
	 */
	public CopyrightClass Copyright;
	public static class CopyrightClass{
		/*
		 * 2.7.1 Name Of Copyright Owner
		 */
		public List<String> NameofCopyrightOwner;
		/*
		 * 2.7.2 Copyright Statement
		 */
		public String CopyrightStatement;
		/*
		 * 2.7.3 Description of Authorized Use
		 */
		public List<DescriptionofAuthorizedUseClass> DescriptionofAuthorizedUse;
		public static class DescriptionofAuthorizedUseClass{
			/*
			 * 2.7.3.1 Name of Authorized User
			 */
			public String NameofAuthorizedUser;
			/*
			 * 2.7.3.2 Authorized Way of Usage
			 */
			public String AuthorizedWayofUsage;
			/*
			 * 2.7.3.3 Authorized Date of Start
			 */
			@JsonSerialize(using = MyDateSerializer.class)
			@JsonDeserialize(using = MyDateDeserializer.class)
			public Date AuthorizedDateofStart;
			/*
			 * 2.7.3.4 Authorized Deadline
			 */
			public String AuthorizedDeadline;
			/*
			 * 2.7.3.5 Authorized Geographic Area
			 */
			public String AuthorizedGeographicArea;
			/*
			 * 2.7.3.6 Times of Authorized Usage
			 */
			public Integer TimesofAuthorizedUsage;
			/*
			 * 2.7.3.7 Other Information
			 */
			public String OtherInformation;	
		}
		
	}

	/*
	 * 2.8 Language
	 */
	public LanguageClass Language;
	public static class LanguageClass{
		/*
		 * 2.8.1 Audio Channel
		 */
		public List<AudioChannelClass> AudioChannel;
		public static class AudioChannelClass{
			/*
			 * 2.8.1.1 Audio Channel Number
			 */
			public Integer AudioChannelNumber;
			/*
			 * 2.8.1.2 Audio Channel Language
			 */
			public String AudioChannelLanguage;
		}
		
		
		/*
		 * 2.8.2 Subtitle
		 */
		public List<SubtitleClass> Subtitle;
		public static class SubtitleClass{
			/*
			 * 2.8.2.1 Subtitle Number
			 */
			public Integer SubtitleNumber;
			/*
			 * 2.8.2.2 Subtitle Language
			 */
			public String SubtitleLanguage;
		}
	}
	
	/*
	 * 2.9 Type
	 */
	@JsonProperty(value = "Type")
	public TypeClass myType;
	public static class TypeClass{
		/*
		 * 2.9.1 Program Form
		 */
		public List<String> ProgramForm;
	}
	
	/*
	 * 2.10 Format
	 */
	public FormatClass Format;
	public static class FormatClass {
		/*
		 * 2.10.1 Duration
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date Duration;
		/*
		 * 2.10.2 Starting Point
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date StartingPoint;
		/*
		 * 2.10.3 Subtitle Form
		 */
		public String SubtitleForm;
	}
	
	/*
	 * 2.11 Identifier
	 */
	public IdentifierClass Identifier;
	public static class IdentifierClass{
		/*
		 * 2.11.1 Internationa Standard Recording Code (ISRC)
		 */
		@JsonProperty(value = "Internationa Standard Recording Code (ISRC)")
		public String ISRC;
		
		/*
		 * 2.11.2 Relations ID 
		 */
		public String RelationsID;
	}
	
	/*
	 * 2.12 Coverage
	 */
	public CoverageClass Coverage;
	public static class CoverageClass{
		/*
		 * 2.12.1 Years Covered
		 */
		public List<YearsCoveredClass> YearsCovered;
		public static class YearsCoveredClass{
			/*
			 * 2.12.1.1 Year of Start
			 */
			public Integer YearofStart;
			/*
			 * 2.12.1.2 Year of End 
			 */
			public Integer YearofEnd;
			/*
			 * 2.12.1.3 Description of Years Covered
			 */
			public String DescriptionofYearsCovered;
		}
		
		/*
		 * 2.12.2 Spatial
		 */
		public List<String> Spatial;
		
	}
	
	/*
	 * 2.13 Source
	 */
	public SourceClass Source;
	public static class SourceClass{
		/*
		 * 2.13.1 Acquiring Method of Source
		 */
		public String AcquiringMethodofSource;
		/*
		 * 2.13.2 Source Provider
		 */
		public String SourceProvider;
	}
	
	/*
	 * 2.14 Relation
	 */
	public List<RelationClass> Relation;
	public static class RelationClass{

		/*
		 * 2.14.1 Is Part of 
		 */
		public String IsPartof;
		/*
		 * 2.14.2 References 
		 */
		public List<String> References;
	}
	
	
}

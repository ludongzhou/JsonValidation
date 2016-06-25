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

/*
 * 1 Program
 */
public class ProgramClass {
	public ProgramClass(){
		
	}
	
	/*
	 * 1.1 Title
	 */
	//@JsonProperty(value = "Title")
	public TitleClass Title;
	public static class TitleClass {
		/*
		 * 1.1.1 Proper Title
		 */
		public String ProperTitle;
		
		/*
		 * 1.1.2 Parallel Proper Title
		 */
		public List<String> ParallelProperTitle;
		
		/*
		 * 1.1.3 Subordinate Title
		 */
		public String SubordinateTitle;
		
		/*
		 * 1.1.4 Alternative ProperTitle
		 */
		public List<String> AlternativeProperTitle;
		
		/*
		 * 1.1.5 Title description
		 * !!
		 */
		public String TitleDescription;
		
		/*
		 * 1.1.6 Series
		 */
		public SeriesClass Series;
		public static class SeriesClass{
			/*
			 * 1.1.6.1 Series Title
			 */
			public String SeriesTitle;
			
			/*
			 * 1.1.6.2 Total Number of Episodes
			 */
			public Integer TotalNumberofEpisodes;
			
			/*
			 * 1.1.6.3 Episodes Number
			 */
			public Integer EpisodesNumber;
			
			/*
			 * 1.1.6.4 Parallel Series Title
			 */
			public List<String> ParallelSeriesTitle;
		}
	}
	
	/*
	 * 1.2 Subject
	 */
	public SubjectClass Subject;
	public static class SubjectClass{
		/*
		 * 1.2.1 Class
		 */
		public List<ClassClass> Class;
		public static class ClassClass {
			/*
			 * 1.2.1.1 Classification
			 */
			public String Classification;
			
			/*
			 * 1.2.1.2 Class Number
			 */
			public String ClassNumber;
		}

		/*
		 * 1.2.2 Subject term
		 */
		public List<String> SubjectTerm;
		
		/*
		 * 1.2.3 Keyword
		 */
		public List<String> Keyword;
		
	}
	
	/*
	 * 1.3 Description
	 */
	public DescriptionClass Description;
	public static class DescriptionClass{
		/*
		 * 1.3.1 Description of Content
		 */
		public String DescriptionofContent;
		/*
		 * 1.3.2 Character
		 */
		public List<String> Character;
		
		/*
		 * 1.3.3 Date of Event
		 * yyyy-MM-dd HH:mm:SS
		 */
		/*
		@JsonSerialize(using = CustomDateSerializer.class)
		@JsonDeserialize(using = CustomDateDeserializer.class)
		public CustomDate DateofEvent;
		*/
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date DateofEvent;

		/*
		 * 1.3.4 Version Description
		 */
		public List<String> VersionDescription;
		
		/*
		 * 1.3.5 Awards
		 */
		public List<AwardsClass> Awards;
		public static class AwardsClass{
			/*
			 * 1.3.5.1 Name of Awards
			 */
			public String NameofAwards;
			/*
			 * 1.3.5.2 Item of Awards
			 */
			public String ItemofAwards;
			/*
			 * 1.3.5.3 Winners of Awards
			 */
			public List<String> WinnersofAwards;
			/*
			 * 1.3.5.4 Year or Time of Awards
			 */
			public Integer YearorTimeofAwards;
			/*
			 * 1.3.5.5 Date of Awards
			 * yyyy-MM-dd HH:mm:ss
			 */
			//1) Not Array
			@JsonSerialize(using = MyDateSerializer.class)
			@JsonDeserialize(using = MyDateDeserializer.class)
			public Date DateofAwards;
			//2) Not Array
			/*
			@JsonSerialize(using = CustomDateSerializer.class)
			@JsonDeserialize(using = CustomDateDeserializer.class)
			public CustomDate DateofAwards;
			*/
			//3) Array of Date
			//mapper register module
			//public List<CustomDate> DateofAwards;
		}

		/*
		 * 1.3.6 Column
		 */
		public List<ColumnClass> Column;
		public  static class ColumnClass{
			/*
			 * 1.3.6.1 Column Name
			 */
			public String ColumnName;
			/*
			 * 1.3.6.2 Issue Number
			 */
			public Integer IssueNumber;
			/*
			 * 1.3.6.3 Issue Year
			 */
			public Integer IssueYear;
		}
		
		/*
		 * 1.3.7 Audience
		 */
		public String Audience;
		/*
		 * 1.3.8 Additional Logo
		 */
		public String AdditionalLogo;
		
		/*
		 * 1.3.9 Audio Channel
		 */
		public List<AudioChannelClass> AudioChannel;
		public static class AudioChannelClass{
			/*
			 * 1.3.9.1 Audio Channel Number
			 */
			public Integer AudioChannelNumber;
			/*
			 * 1.3.9.2 Audio Channel Description
			 */
			public String AudioChannelDescription;

		}

		/*
		 * 1.3.10 Attachment
		 */
		public List<String> Attachment;
		
	}
	
	/*
	 * 1.4 Creator
	 */
	public CreatorClass Creator;
	public static class CreatorClass{
		/*
		 * 1.4.1 Description of Creator
		 */
		public List<DescriptionofCreatorClass> DescriptionofCreator;
		public static class DescriptionofCreatorClass{
			/*
			 * 1.4.1.1 Name of Creator
			 */
			public String NameofCreator;
			/*
			 * 1.4.1.2 Parallel Name of Creator
			 */
			public List<String> ParallelNameofCreator;
			/*
			 * 1.4.1.3 Role
			 */
			public String Role;
			/*
			 * 1.4.1.4 Other Information
			 */
			public String OtherInformation;
		}
		
	}
	
	/*
	 * 1.5 Contributor
	 */
	public List<ContributorClass> Contributor;
	public static class ContributorClass{
		/*
		 * 1.5.1 Description Of Contributor
		 */
		public DescriptionofContributorClass DescriptionofContributor;
		public static class DescriptionofContributorClass{
			/*
			 * 1.5.1.1 Name Of Contributor
			 */
			public String NameofContributor;
			/*
			 * 1.5.1.2 Parallel Name Of Contributor
			 */
			public List<String> ParallelNameofContributor;
			/*
			 * 1.5.1.3 Role
			 */
			public String Role;
			/*
			 * 1.5.1.4 Other Information
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
		 * 1.6.1 Description Of Publisher
		 */
		public List<DescriptionofPublisherClass> DescriptionofPublisher;
		public class DescriptionofPublisherClass{
			/*
			 * 1.6.1.1 Name Of Publisher
			 */
			public String NameofPublisher;
			/*
			 * 1.6.1.2 Place of Publisher
			 */
			public String PlaceofPublisher;
		}
		
		/*
		 * 1.6.2 Description of Producer
		 */
		public List<DescriptionofProducerClass> DescriptionofProducer;
		public class DescriptionofProducerClass{
			/*
			 * 1.6.2.1 Name of Producer
			 */
			public String NameofProducer;
			/*
			 * 1.6.2.2 Place of Production
			 */
			public String PlaceofProduction;
		}
	}
	
	/*
	 * 1.7 Copyright
	 */
	public CopyrightClass Copyright;
	public static class CopyrightClass{
		/*
		 * 1.7.1 Name Of Copyright Owner
		 */
		public List<String> NameofCopyrightOwner;
		/*
		 * 1.7.2 Copyright Statement
		 */
		public String CopyrightStatement;
		/*
		 * 1.7.3 Description of Authorized Use
		 */
		public List<DescriptionofAuthorizedUseClass> DescriptionofAuthorizedUse;
		public static class DescriptionofAuthorizedUseClass{
			/*
			 * 1.7.3.1 Name of Authorized User
			 */
			public String NameofAuthorizedUser;
			/*
			 * 1.7.3.2 Authorized Way of Usage
			 */
			public String AuthorizedWayofUsage;
			/*
			 * 1.7.3.3 Authorized Date of Start
			 */
			@JsonSerialize(using = MyDateSerializer.class)
			@JsonDeserialize(using = MyDateDeserializer.class)
			public Date AuthorizedDateofStart;
			/*
			 * 1.7.3.4 Authorized Deadline
			 * !!
			 * Date ?
			 */
			public String AuthorizedDeadline;
			/*
			 * 1.7.3.5 Authorized Geographic Area
			 */
			public String AuthorizedGeographicArea;
			/*
			 * 1.7.3.6 Times of Authorized Usage
			 */
			public Integer TimesofAuthorizedUsage;
			/*
			 * 1.7.3.7 Other Information
			 */
			public String OtherInformation;	
		}
		
	}

	/*
	 * 1.8 Language
	 */
	public LanguageClass Language;
	public static class LanguageClass{
		/*
		 * 1.8.1  Channel
		 */
		public List<AudioChannelClass> AudioChannel;
		public static class AudioChannelClass{
			/*
			 * 1.8.1.1 Audio Channel Number
			 */
			public Integer AudioChannelNumber;
			/*
			 * 1.8.1.2 Audio Channel Language
			 */
			public String AudioChannelLanguage;
		}
		
		/*
		 * 1.8.2 Subtitle
		 */
		public List<SubtitleClass> Subtitle;
		public static class SubtitleClass{
			/*
			 * 1.8.2.1 Subtitle Number
			 */
			public Integer SubtitleNumber;
			/*
			 * 1.8.2.2 Subtitle Language
			 */
			public String SubtitleLanguage;
		}

	}
	
	/*
	 * 1.9 Date
	 */
	@JsonProperty(value = "Date")
	public DateClass myDate;
	public static class DateClass{
		/*
		 * 1.9.1 Produced Date
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date ProducedDate;
		
		/*
		 * 1.9.2 Date of Debut
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date DateofDebut;
		
		/*
		 * 1.9.3 Published Date
		 */
		@JsonSerialize(using = MyDateSerializer.class)
		@JsonDeserialize(using = MyDateDeserializer.class)
		public Date PublishedDate;
		
	}
	
	
	/*
	 * 1.10 Type
	 */
	@JsonProperty(value = "Type")
	public TypeClass myType;
	public static class TypeClass{
		/*
		 * 1.10.1 Program Type
		 */
		public List<String> ProgramType;
		
		/*
		 * 1.10.2 Program Form
		 */
		public List<String> ProgramForm;
	}
	
	
	/*
	 * 1.11 Format
	 */
	public FormatClass Format;
	public static class FormatClass {
		/*
		 * 1.11.1 Duration
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date Duration;
		/*
		 * 1.11.2 Starting Point
		 */
		@JsonSerialize(using = MyTimeSerializer.class)
		@JsonDeserialize(using = MyTimeDeserializer.class)
		public Date StartingPoint;
		/*
		 * 1.11.3 Color
		 */
		public String Color;
		/*
		 * 1.11.4 Subtitle Form
		 */
		public String SubtitleForm;
		/*
		 * 1.11.5 Audio Channel Format
		 */
		public String AudioChannelFormat;
		/*
		 * 1.11.6 Audio Quality
		 */
		public String AudioQuality;
		/*
		 * 1.11.7 Video Quality
		 */
		public String VideoQuality;
		/*
		 * 1.11.8 Aspect Ratio
		 */
		public String AspectRatio;
		/*
		 * 1.11.9 Physical Media Type
		 */
		public String PhysicalMediaType;
		/*
		 * 1.11.10 System
		 */
		public String System;
		/*
		 * 1.11.11 Audio Data Rate
		 */
		public String AudioDataRate;
		/*
		 * 1.11.12 Audio Coding Format
		 */
		public String AudioCodingFormat;
		/*
		 * 1.11.13 Audio Sampling Frequency
		 */
		public String AudioSamplingFrequency;
		/*
		 * 1.11.14 Audio Bit Depth
		 */
		public String AudioBitDepth;
		/*
		 * 1.11.15 Video Bit rate
		 */
		public String VideoBitrate;
		/*
		 * 1.11.16 Video Coding Format
		 */
		public String VideoCodingFormat;
		/*
		 * 1.11.17 Video Sampling Type
		 */
		public String VideoSamplingType;
		/*
		 * 1.11.18 File Format
		 */
		public String FileFormat;
	}
	
	/*
	 * 1.12 Identifier
	 */
	public IdentifierClass Identifier;
	public static class IdentifierClass{
		/*
		 * 1.12.1 Internationa Standard Recording Code (ISRC)
		 */
		@JsonProperty(value = "Internationa Standard Recording Code (ISRC)")
		public String ISRC;
		
		/*
		 * 1.12.2 Relations ID 
		 */
		public String RelationsID;
	}
	
	
	/*
	 * 1.13 Coverage
	 */
	public CoverageClass Coverage;
	public static class CoverageClass{
		/*
		 * 1.13.1 Years Covered
		 */
		public List<YearsCoveredClass> YearsCovered;
		public static class YearsCoveredClass{
			/*
			 * 1.13.1.1 Year of Start
			 */
			public Integer YearofStart;
			/*
			 * 1.13.1.2 Year of End 
			 */
			public Integer YearofEnd;
			/*
			 * 1.13.1.2 Description of Years Covered
			 */
			public String DescriptionofYearsCovered;
			
		}
		/*
		 * 1.13.2 Spatial
		 */
		public List<String> Spatial;
	}
	
	/*
	 * 1.14 Source
	 */
	public SourceClass Source;
	public static class SourceClass{
		/*
		 * 1.14.1 Acquiring Method of Source
		 */
		public String AcquiringMethodofSource;
		/*
		 * 1.14.2 Source Provider
		 */
		public String SourceProvider;
	}
	
	/*
	 * 1.15 Relation
	 */
	public RelationClass Relation;
	public static class RelationClass{
		/*
		 * 1.15.1 Part of Series
		 */
		public String PartofSeries;
		/*
		 * 1.15.2 Is Part of 
		 */
		public String IsPartof;
		/*
		 * 1.15.3 Has Part
		 */
		public List<String> HasPart;
		/*
		 * 1.15.4 References 
		 */
		public List<String> References;
		/*
		 * 1.15.5 Is Referenced by
		 */
		public List<String> IsReferencedby;
		/*
		 * 1.15.6 Replaces
		 */
		public String Replaces;
		/*
		 * 1.15.7 Is Replaced by
		 */
		public String IsReplacedby;
		/*
		 * 1.15.8 Requires
		 */
		public List<String> Requires;
		/*
		 * 1.15.9 Is Required by
		 */
		public List<String> IsRequiredby;
		/*
		 * 1.15.10 Is Version of 
		 */
		public String IsVersionof;
		/*
		 * 1.15.11 Has Version of
		 */
		public List<String> HasVersionof;
	}
}

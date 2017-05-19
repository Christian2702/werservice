package de.drwhatson.server.api.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Client client;
	@ManyToOne
	private User user;
	@ManyToOne
	private Application application;
	
	private int reportType;

	private String bucketId;

	private String applicationVersion;

	private String appDestination;

	private Date eventTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public String getBucketId() {
		return bucketId;
	}

	public void setBucketId(String bucketId) {
		this.bucketId = bucketId;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAppDestination() {
		return appDestination;
	}

	public void setAppDestination(String appDestination) {
		this.appDestination = appDestination;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appDestination == null) ? 0 : appDestination.hashCode());
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((applicationVersion == null) ? 0 : applicationVersion.hashCode());
		result = prime * result + ((bucketId == null) ? 0 : bucketId.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + reportType;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (appDestination == null) {
			if (other.appDestination != null)
				return false;
		} else if (!appDestination.equals(other.appDestination))
			return false;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (applicationVersion == null) {
			if (other.applicationVersion != null)
				return false;
		} else if (!applicationVersion.equals(other.applicationVersion))
			return false;
		if (bucketId == null) {
			if (other.bucketId != null)
				return false;
		} else if (!bucketId.equals(other.bucketId))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (eventTime == null) {
			if (other.eventTime != null)
				return false;
		} else if (!eventTime.equals(other.eventTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reportType != other.reportType)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", client=" + client + ", user=" + user + ", application=" + application
				+ ", reportType=" + reportType + ", bucketId=" + bucketId + ", applicationVersion=" + applicationVersion
				+ ", appDestination=" + appDestination + ", eventTime=" + eventTime + "]";
	}

	public static Report create(Long id, Client client, User user, Application application, String bucketId, int eventType,
			String applicationVersion, String appDestination, Date eventTime) {
		Report report = new Report();
		report.setId(id);
		report.setClient(client);
		report.setUser(user);
		report.setApplication(application);
		report.setBucketId(bucketId);
		report.setApplicationVersion(applicationVersion);
		report.setAppDestination(appDestination);
		report.setEventTime(eventTime);
		return report;
	}

	public static Report create(Client client, User user, Application application, String bucketId, int eventType,
			String applicationVersion, String appDestination, Date eventTime) {

		return create(null, client, user, application, bucketId, eventType, applicationVersion, appDestination, eventTime);
	}

}

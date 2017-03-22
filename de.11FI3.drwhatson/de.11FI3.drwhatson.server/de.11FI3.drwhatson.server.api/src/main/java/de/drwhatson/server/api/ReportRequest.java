package de.drwhatson.server.api;

public class ReportRequest {

	private String appName;
	private String appPath;
	private String userName;
	private String macAddress;
	private int reportType;
	private String bucketId;
	private Long eventTime;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppPath() {
		return appPath;
	}
	public void setAppPath(String appPath) {
		this.appPath = appPath;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}
	public Long getTimestamp() {
		return eventTime;
	}
	public void setTimestamp(Long timestamp) {
		this.eventTime = timestamp;
	}

}

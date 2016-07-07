package com.contacts.db.models.abergin;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="ADDRESS")
public class Address extends Model{

	@Column(name="ADDRESS_ID")
	private Long addressId;
	
	@Column(name="ADDRESS_HEADING", length=30, notNull = true)
	private String addressHeading;
	
	@Column(name="PINCODE", length=10, notNull = true)
	private String pincode;
	
	@Column(name = "ADDRESS")
	private String address;				//@TODO Check for CLOB
	
	@Column(name="LANDMARK", length=100)
	private String landmark;
	
	@Column(name="PHONE_NO", length=15)
	private String phoneNo;

	@Column(name="CITY", length=20)
	private String city;
	
	@Column(name="STATE", length=20)
	private String state;
	
	@Column(name="COUNTRY", length=20)
	private String country;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "USER", onDelete = Column.ForeignKeyAction.NO_ACTION)
	private AUser user;

	@Column(name = "JOURNAL_ID")
	private Integer journalId;			//Journal ID of the record

	public Address() {}

	public Address(Long addressId, String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country,  Double longitude, Double latitude, AUser user, Integer journalId) {
		this.addressId = addressId;
		this.addressHeading = addressHeading;
		this.pincode = pincode;
		this.address = address;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
		this.journalId = journalId;
	}

	public void superimpose(Long addressId, String addressHeading, String pincode, String address, String landmark, String phoneNo, String city, String state, String country,  Double longitude, Double latitude, AUser user, Integer journalId) {
		this.addressId = addressId;
		this.addressHeading = addressHeading;
		this.pincode = pincode;
		this.address = address;
		this.landmark = landmark;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
		this.journalId = journalId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressHeading() {
		return addressHeading;
	}

	public void setAddressHeading(String addressHeading) {
		this.addressHeading = addressHeading;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public AUser getUser() {
		return user;
	}

	public void setUser(AUser user) {
		this.user = user;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}
}

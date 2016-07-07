package com.contacts.db.models.abergin;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.contacts.app.enums.STATUS;
import com.contacts.app.enums.USER_TYPE;
import com.contacts.db.models.places.City;
import com.contacts.db.models.specialities.UserSubSpeciality;

import java.util.Date;
import java.util.List;

@Table(name="USERS")
public class AUser extends Model{

	public AUser() {}
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_TYPE", notNull = true)
	private USER_TYPE userType;

	@Column(name = "NAME", length = 30)
	private String name;

	@Column(name = "EMAIL", length = 30)
	private String email;

	@Column(name = "MOBILE", length = 15, notNull = true)
	private String mobile;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Column(name = "IMAGE_BLOB")
	private byte[] imageBlob;

	@Column(name="LAST_LOGIN")
	private Date lastLogin;

	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name = "STATUS")
	private STATUS status;

	@Column(name="JOURNAL_ID")
	private Integer journalId;

	@Column(name = "CITY", onDelete = Column.ForeignKeyAction.CASCADE)
	private City city;

	private Address address;

	private List<UserSubSpeciality> userSubSpecialitySet;

	public AUser(Long userId) {
		this.userId = userId;
	}

	public AUser(Long userId, USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status, City city, Integer journalId) {
		this.userId = userId;
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.imageBlob = imageBlob;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.status = status;
		this.city = city;
		this.journalId = journalId;
	}

	public void superimpose(Long userId, USER_TYPE userType, String name, String email, String mobile, String password, byte[] imageBlob, Date lastLogin, Date createdOn, STATUS status, City city, Integer journalId) {
		this.userId = userId;
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.imageBlob = imageBlob;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.status = status;
		this.city = city;
		this.journalId = journalId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public void setUserType(USER_TYPE userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public byte[] getImageBlob() {
		return imageBlob;
	}

	public void setImageBlob(byte[] imageBlob) {
		this.imageBlob = imageBlob;
	}

	public Address getAddress() {
		return new Select().from(Address.class).where("USER = ?", this.getId()).executeSingle();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public List<UserSubSpeciality> getUserSubSpecialitySet() {
		return new Select().from(UserSubSpeciality.class).where("USER = ?", this.getId()).execute();
	}

	public void setUserSubSpecialitySet(List<UserSubSpeciality> userSubSpecialitySet) {
		this.userSubSpecialitySet = userSubSpecialitySet;
	}
}

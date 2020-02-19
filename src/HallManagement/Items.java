package HallManagement;





//import supershop.String;

public class Items {
	private int Id;
  private String FirstName;
  private String LastName;
  private String HallPost;
  private String TeachersInfo;
  private String Dept;
  private String PhoneNo;
  private String Mail;
  private String Post;
  private String Contact;
  private String StudentId;
  private String HallId;
  private String RoomNo;
  private String Sessions;
  private String Religion;
  private String District;

 
  
  public Items(int id, String firstName, String lastName, String studentId,String hallId, String roomNo, String phoneNo, String dept,
		
		String sessions, String religion, String district) {
	super();
	Id = id;
	FirstName = firstName;
	LastName = lastName;
	Dept = dept;
	PhoneNo = phoneNo;
	StudentId = studentId;
	HallId = hallId;
	RoomNo = roomNo;
	Sessions = sessions;
	Religion = religion;
	District = district;
}


public Items(int id, String firstName, String lastName, String post,
		String contact) {
	super();
	Id = id;
	FirstName = firstName;
	LastName = lastName;
	Post = post;
	Contact = contact;
}


public String getPost() {
	return Post;
}


public void setPost(String post) {
	Post = post;
}


public String getContact() {
	return Contact;
}


public void setContact(String contact) {
	Contact = contact;
}


public String getStudentId() {
	return StudentId;
}


public void setStudentId(String studentId) {
	StudentId = studentId;
}


public String getHallId() {
	return HallId;
}


public void setHallId(String hallId) {
	HallId = hallId;
}


public String getRoomNo() {
	return RoomNo;
}


public void setRoomNo(String roomNo) {
	RoomNo = roomNo;
}


public String getSessions() {
	return Sessions;
}


public void setSessions(String sessions) {
	Sessions = sessions;
}


public String getReligion() {
	return Religion;
}


public void setReligion(String religion) {
	Religion = religion;
}


public String getDistrict() {
	return District;
}


public void setDistrict(String district) {
	District = district;
}


public Items(int Id, String FirstName, String LastName, String HallPost, String TeachersInfo, String Dept,String PhoneNo,String Mail)
  {
      this.setId(Id);
      this.setFirstName(FirstName);
      this.setLastName(LastName);
      this.setHallPost(HallPost);
      this.setTeachersInfo(TeachersInfo);
      this.setDept(Dept);
      this.setPhoneNo(PhoneNo);
      this.setMail(Mail);
  }


public int getId() {
	return Id;
}


public void setId(int id) {
	Id = id;
}


public String getFirstName() {
	return FirstName;
}


public void setFirstName(String firstName) {
	FirstName = firstName;
}


public String getLastName() {
	return LastName;
}


public void setLastName(String lastName) {
	LastName = lastName;
}


public String getHallPost() {
	return HallPost;
}


public void setHallPost(String hallPost) {
	HallPost = hallPost;
}


public String getTeachersInfo() {
	return TeachersInfo;
}


public void setTeachersInfo(String teachersInfo) {
	TeachersInfo = teachersInfo;
}


public String getDept() {
	return Dept;
}


public void setDept(String dept) {
	Dept = dept;
}


public String getPhoneNo() {
	return PhoneNo;
}


public void setPhoneNo(String phoneNo) {
	PhoneNo = phoneNo;
}


public String getMail() {
	return Mail;
}


public void setMail(String mail) {
	Mail = mail;
}
  

 
}



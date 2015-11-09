package auction.UserCreate;

public class CreateUserVO {
	
	private String	u_id;
	private String	u_pw;
	private String	u_name;
	private String	u_nick;
	private int 	u_lv;
	/*private String 	u_post;
	private String 	u_email;*/
	
	public CreateUserVO(){
		
	}
	public CreateUserVO(String u_id,String u_pw,String u_name,String u_nick,int u_lv/*, String u_post, String u_email*/){
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_nick = u_nick;
		this.u_lv 	= u_lv;
		/*this.u_post = u_post;
		this.u_email = u_email;*/
		
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	public int getU_lv() {
		return u_lv;
	}
	public void setU_lv(int u_lv) {
		this.u_lv = u_lv;
	}
	
	/*public String getU_post() {
		return u_post;
	}
	public void setU_post(String u_post) {
		this.u_post = u_post;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}*/
	

}

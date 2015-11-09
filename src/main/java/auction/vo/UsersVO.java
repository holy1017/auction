package auction.vo;

public class UsersVO {
	private int	u_no	;
	private String	u_id	= "";
	private String	u_name	= "";
	private String	u_nick	= "";
	private String	u_pw	= "";
	private int		u_lv	= 0;
	private String	u_date	= "";
							
	public String getU_id() {
		return u_id;
	}
	
	public int getU_no() {
		return u_no;
	}
	
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
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
	
	public String getU_pw() {
		return u_pw;
	}
	
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	
	public int getU_lv() {
		return u_lv;
	}
	
	public void setU_lv(int u_lv) {
		this.u_lv = u_lv;
	}
	
	public String getU_date() {
		return u_date;
	}
	
	public void setU_date(String u_date) {
		this.u_date = u_date;
	}
}

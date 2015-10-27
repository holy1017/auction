package auction.vo;

public class ReplyVO {
	private int    r_no         =0;
	private String r_context    ="";
	private int    u_no         =0;
	private int    b_no         =0;
	private String r_date       ="";
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getR_context() {
		return r_context;
	}
	public void setR_context(String r_context) {
		this.r_context = r_context;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
}

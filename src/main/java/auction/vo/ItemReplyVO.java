package auction.vo;

public class ItemReplyVO {
	private int    ar_no                =0;
	private String ar_context           ="";
	private int    a_no                 =0;
	private int    u_no                 =0;
	private String ar_date              ="";
	public int getAr_no() {
		return ar_no;
	}
	public void setAr_no(int ar_no) {
		this.ar_no = ar_no;
	}
	public String getAr_context() {
		return ar_context;
	}
	public void setAr_context(String ar_context) {
		this.ar_context = ar_context;
	}
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getAr_date() {
		return ar_date;
	}
	public void setAr_date(String ar_date) {
		this.ar_date = ar_date;
	}
}

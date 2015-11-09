package auction.vo;

public class BidderVO {
	private int    d_no         =0;
	private int    a_no         =0;
	private int    u_no         =0;
	private int    d_price      =0;
	private String d_date       ="";
	public int getD_no() {
		return d_no;
	}
	public void setD_no(int d_no) {
		this.d_no = d_no;
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
	public int getD_price() {
		return d_price;
	}
	public void setD_price(int d_price) {
		this.d_price = d_price;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
}

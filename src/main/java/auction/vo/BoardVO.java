package auction.vo;

public class BoardVO {
	private int		b_no		= 0;
	private int		u_no		= 0;
	private String	b_title		= "";
	private String	b_context	= "";
	private String	b_date		= "";
								
	public int getB_no() {
		return b_no;
	}
	
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	
	public int getU_no() {
		return u_no;
	}
	
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	
	public String getB_title() {
		return b_title;
	}
	
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	public String getB_context() {
		return b_context;
	}
	
	public void setB_context(String b_context) {
		this.b_context = b_context;
	}
	
	public String getB_date() {
		return b_date;
	}
	
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
}

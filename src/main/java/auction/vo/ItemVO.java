package auction.vo;

import org.springframework.web.multipart.MultipartFile;

public class ItemVO extends UsersVO {
	
	
	private String u_id           ;
	private int    a_no             =0;//�����۹�ȣ
	private int    u_no              =0;//������ȣ
	private String a_name           ="";//��ǰ��
	private int    a_top_price      =0;//�ﱸ��
	private int    a_bot_price      =0;//������
	private String a_ddate          ="";//��
	private String a_date           ="";//��ϳ�¥
	private String a_content		="";//����
	private String a_imgContext		="";//�̹������
	private String bd_date		="";
	private String bd_name		="";
	private int a_bid_price	= 0;
	MultipartFile a_file;
	
	
	public MultipartFile getA_file() {
		return a_file;
	}
	public void setA_file(MultipartFile a_file) {
		this.a_file = a_file;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
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
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public int getA_top_price() {
		return a_top_price;
	}
	public void setA_top_price(int a_top_price) {
		this.a_top_price = a_top_price;
	}
	public int getA_bot_price() {
		return a_bot_price;
	}
	public void setA_bot_price(int a_bot_price) {
		this.a_bot_price = a_bot_price;
	}
	public String getA_ddate() {
		return a_ddate;
	}
	public void setA_ddate(String a_ddate) {
		this.a_ddate = a_ddate;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getA_imgContext() {
		return a_imgContext;
	}
	public void setA_imgContext(String a_imgContext) {
		this.a_imgContext = a_imgContext;
	}
	public String getBd_date() {
		return bd_date;
	}
	public void setBd_date(String bd_date) {
		this.bd_date = bd_date;
	}
	public String getBd_name() {
		return bd_name;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}
	public int getA_bid_price() {
		return a_bid_price;
	}
	public void setA_bid_price(int a_bid_price) {
		this.a_bid_price = a_bid_price;
	}
	
}
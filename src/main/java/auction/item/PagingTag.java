package auction.item;


import java.io.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;



public class PagingTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * @param page 		현재 페이지 번호
	 * @param total  	전체 조회된  Row수
	 * @param list_size 페이지에서 보여주는 레코드 수
	 * @param page_size 페이지 네비게이터에 표시되는 페이지 버튼
	 */
	
	
	private int page = 1;
	private int total = 1;
	private int list_size = 2;
	private int page_size = 2;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(getPaging());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	public void setPage(int page){
		this.page = page;
	}
	public void setTotal(int total){
		this.total = total;
	}
	public void setList_size(int list_size){
		this.list_size = list_size;
	}
	public void setPage_size(int page_size){
		this.page_size = page_size;
	}
	
	public String getPaging(){
		String ret = "";
		if(page<1) page=1;
		if(total<1) return "";
		
		//page가 1페이지 page_size가 2이면 현재 currentFirst는 1
		int currentFirst =((page-1)/page_size)*page_size+1;
		
		//currentlast는 2
		int currentlast = ((page-1)/page_size)*page_size+page_size;
		
		//nextFirst 3
		int nextFirst = (((page-1)/page_size)+1)*page_size+1;
		
		//prevLast는 0
		int prevLast = (((page-1)/page_size)-1)*page_size+1;
		
		int lastPage= 1;
		lastPage = total / list_size;
		//lastPage(총 페이지수)는 total이 11 이고..아오다못침
		
		if(total%list_size != 0) lastPage = lastPage +1;
		//Currentlast가 listpage(총페이지의 수) 보다 크면 마지막 페이지로 수정
		
		currentlast = (currentlast > lastPage)? lastPage : currentlast;
		
		ret += " <div class='paginate'>";
		
		if(page >1){
			ret += " <a href=\"javascript:goPage('1')\"><span><img src='../image/common/btn_paginate_first.gif' /></span></a>";
		}else{
			ret += " <span><img src='../image/common/btn_paginate_first.gif' alt='처음' /></span>";
		}
		
		if( prevLast > 0){
			ret += " <a href=\"javascript:goPage('"+prevLast+"')\"><span><img src='../image/common/btn_paginate_prev.gif' alt='이전' /></sapn></a>";
		}else{
			ret += " <span><img src='../image/common/btn_paginate_prev.gif' alt='이전' /></sapn>";			
		}
		
		for(int j=currentFirst; j<currentFirst+page_size && j<=lastPage; j++){
			if(j<=currentlast){
				if(j==page){
					ret +=" <a href='#' class='on textAn'>"+j+"<a>";
				}else{
					ret += " <a href=\"javascript:goPage('"+j+"')\" class='textAn'>"+j+"</a>";
				}
			}
		}
		if(nextFirst <= lastPage){
			ret += " <a href=\"javascript:goPage('"+nextFirst+"')\"><span><img src='../image/common/btn_paginate_next.gif' alt='다음' /></span></a>";
		}else{
			ret += " <span><img src='../image/common/btn_paginate_next.gif' alt='다음' /></a>";
		}
		
		if(page<lastPage){
			ret += " <a href=\"javascript:goPage('"+lastPage+"')\"><span><img src='../image/common/btn_paginate_last.gif' alt='마지막' /></span>";
		}
		ret += " </div>";
		return ret;
	}
}	

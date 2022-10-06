package com.updev.admin;

public class PageDTO {  
    // ����������,����������,��������,�Խñ� �Ѱ���,��������۰���,������������, start, end
	public int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end, realEnd;
	public int cntPage=10;  //�� ȭ�鿡 ǥ���ϰ��� �ϴ� ������ ��
	public boolean prev, next;	//���� ������, ���� ������
	public Criteria cri;
	public String sname; // �˻�Ÿ�� (������, �۾��� ���)
	public String keyword; // Ű����
	public int b_num, b_replycnt;
	
	
	
	public PageDTO(Criteria cri, int total, int nowPage, int cntPerPage) {
		this.cri = cri;
		this.total = total;
		
		//ȭ�鿡 ������ ������ ������
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//ȭ�鿡 ������ ���� ������
		this.startPage = this.endPage -9;
		//��ü ������ ������
		this.realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount());
		//ȭ�鿡 ���� ������ �������� ��ȿ���� üũ
		if(this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}
		
		//����, ���� ��ư ǥ�� ���� ����
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
		
		setNowPage(nowPage);
	    setCntPerPage(cntPerPage);
	    setTotal(total);
	    calcLastPage(getTotal(), getCntPerPage());
	    calcStartEndPage(getNowPage(), cntPage);
	    calcStartEnd(getNowPage(), getCntPerPage());   
	    
	}
	
	public PageDTO(Criteria cri, int total, int nowPage, int cntPerPage, String keyword) {
		this.cri = cri;
		this.total = total;
		
		//ȭ�鿡 ������ ������ ������
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//ȭ�鿡 ������ ���� ������
		this.startPage = this.endPage -9;
		//��ü ������ ������
		this.realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount());
		//ȭ�鿡 ���� ������ �������� ��ȿ���� üũ
		if(this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}
		
		//����, ���� ��ư ǥ�� ���� ����
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
		
		setKeyword(keyword);
		setNowPage(nowPage);
	    setCntPerPage(cntPerPage);
	    setTotal(total);
	    calcLastPage(getTotal(), getCntPerPage());
	    calcStartEndPage(getNowPage(), cntPage);
	    calcStartEnd(getNowPage(), getCntPerPage());   
	    
	}
	
	public PageDTO(Criteria cri, int total, int nowPage, int cntPerPage, int b_num) {
		this.cri = cri;
		this.total = total;
		this.b_num = b_num;
		
		//ȭ�鿡 ������ ������ ������
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		//ȭ�鿡 ������ ���� ������
		this.startPage = this.endPage -9;
		//��ü ������ ������
		this.realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount());
		//ȭ�鿡 ���� ������ �������� ��ȿ���� üũ
		if(this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}
		
		//����, ���� ��ư ǥ�� ���� ����
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
		
		setB_num(b_num);
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());   
		
	}
	
	
   public int getCntPage() {
      return cntPage;
   }
   
   public void setCntPage(int cntPage) {
      this.cntPage = cntPage;
   }
   
   public PageDTO() {
      super();
   }
   



// ���ϸ��������������
   public void calcLastPage(int total, int cntPerPage) {
      setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
         }   
   //����,�� ������ ���
   public void calcStartEndPage(int nowPage, int cntPage) {
      setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
      if (getLastPage() < getEndPage()) {
         setEndPage(getLastPage());
      }
      setStartPage(getEndPage() - cntPage + 1);
      if(getStartPage()<1) {
         setStartPage(1);
      }
   }
   
   // DB ������ ����� start,end�� ���
   public void calcStartEnd(int nowPage, int cntPerPage) {
      setEnd(nowPage * cntPerPage);
      setStart(getEnd() - cntPerPage + 1);
   }

	public int getNowPage() {
		return nowPage;
	}
	
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getCntPerPage() {
		return cntPerPage;
	}
	
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	
	public int getLastPage() {
		return lastPage;
	}
	
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public Criteria getCri() {
		return cri;
	}
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public int getB_replycnt() {
		return b_replycnt;
	}

	public void setB_replycnt(int b_replycnt) {
		this.b_replycnt = b_replycnt;
	}
   
}

//System.out.println("��ü ���ڵ��� ��"+getTotal());
//System.out.println("��ü �������� ��"+getLastPage());
//System.out.println("������������"+getStartPage());
//System.out.println("�� ������ ��"+getEndPage());     
package prev.fengb.mongodb.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Page implements Pageable {

	private int pageNumber;
	private int pageSize;
	private Sort sort;

	public Page() {
		super();
	}

	public Page(int pageNumber, int pageSize, Sort sort) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.sort = sort;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public long getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

}

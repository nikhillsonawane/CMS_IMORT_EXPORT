package com.cms.importexport.dto;

import java.io.Serializable;
import java.util.List;

public class DataTable implements Serializable {
	private static final long serialVersionUID = 1L;
	//private Integer draw;
	private Long recordsTotal;
	//private Long recordsFiltered;
	private List<?> data;
	
	

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	
	
}

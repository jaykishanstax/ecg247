package com.ecg.web.ecgonline.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageDto {

    private long size;

    private long totalElements;

    private int totalPages;

    private int number;

    public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PageDto() {
    }

    public PageDto(long size, long totalElements, int totalPages, int number) {

        if (size >= totalElements) {
            this.size = totalElements;
        } else {
            this.size = size;
        }
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;

    }
}

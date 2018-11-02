package com.ecg.web.ecgonline.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = -169222192890052995L;
    private String message;
    private String error;
    private T data;
    private Collection<T> allData;
    private Integer status;
    private PageDto page;

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Collection<T> getAllData() {
		return allData;
	}

	public void setAllData(Collection<T> allData) {
		this.allData = allData;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public PageDto getPage() {
		return page;
	}

	public void setPage(PageDto page) {
		this.page = page;
	}

	public GenericResponse(final List<String> fieldErrors, final List<String> globalErrors) {
        super();
        final ObjectMapper mapper = new ObjectMapper();
        try {
            this.message = mapper.writeValueAsString(fieldErrors);
            this.error = mapper.writeValueAsString(globalErrors);
        } catch (final JsonProcessingException e) {
            this.message = "";
            this.error = "";
        }
    }

    public GenericResponse() {

    }

    public GenericResponse(final String message, final String error) {
        super();
        this.message = message;
        this.error = error;
    }

}

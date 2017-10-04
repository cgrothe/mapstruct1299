package org.mapstruct.example.model;

public class TargetDto {
	private String generatedId;
	private String dtoVersion;
	private String generatedByCode;

	/**
	 * @return  the generatedId
	 */
	public String getGeneratedId() {
		return generatedId;
	}

	/**
	 * @param  generatedId  the generatedId to set
	 */
	public void setGeneratedId(final String generatedId) {
		this.generatedId = generatedId;
	}

	/**
	 * @return  the dtoVersion
	 */
	public String getDtoVersion() {
		return dtoVersion;
	}

	/**
	 * @param  dtoVersion  the dtoVersion to set
	 */
	public void setDtoVersion(final String dtoVersion) {
		this.dtoVersion = dtoVersion;
	}

	/**
	 * @return  the generatedByCode
	 */
	public String getGeneratedByCode() {
		return generatedByCode;
	}

	/**
	 * @param  generatedByCode  the generatedByCode to set
	 */
	public void setGeneratedByCode(final String generatedByCode) {
		this.generatedByCode = generatedByCode;
	}


}

package com.mingo.pojo;

import lombok.Data;

@Data
public class Contact {

	private Integer cId;
	private String cName;
	private String cEmail;
	private String cNumber;

	
	// Getters and Setters
		public Integer getcId() {
			return cId;
		}

		public void setcId(Integer cId) {
			this.cId = cId;
		}

		public String getcName() {
			return cName;
		}

		public void setcName(String cName) {
			this.cName = cName;
		}

		public String getcEmail() {
			return cEmail;
		}

		public void setcEmail(String cEmail) {
			this.cEmail = cEmail;
		}

		public String getcNumber() {
			return cNumber;
		}

		public void setcNumber(String cNumber) {
			this.cNumber = cNumber;
		}
}
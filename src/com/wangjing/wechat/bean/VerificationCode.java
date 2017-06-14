package com.wangjing.wechat.bean;

/**
 * 
 * @ClassName: VerificationCode
 * @Description: TODO
 * @author YoungSmith
 * @date 2017年6月10日 下午11:25:46
 *
 */
public class VerificationCode {
	private String code;
	private String isUsed;
	private String type;
	private String version;
	private String startDate;
	private String expiredDate;
	private String usedDate;

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(String usedDate) {
		this.usedDate = usedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

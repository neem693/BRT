package com.theComments.brt.constFile;

public enum EmailInfo {

	EMAIL_VERIFY_INFO(1L, "http://the-comment.com", null);

	public final Long emailTemplateId;
	public final String url;
	public final String additionalInfo;

	private EmailInfo(Long emailTemplateId, String url, String additionalInfo) {
		this.emailTemplateId = emailTemplateId;
		this.url = url;
		this.additionalInfo = additionalInfo;
	}

}

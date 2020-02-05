package com.theComments.brt.constFile;

public enum SNS {

	GOOGLE("google", "https://www.googleapis.com/oauth2/v1/tokeninfo"),
	KAKAO("kakao","https://kapi.kakao.com/v2/user/me");

	public final String snsType;
	public final String checkAccessTokenUri;

	SNS(String type, String uri) {
		this.snsType = type;
		this.checkAccessTokenUri = uri;
	}
}


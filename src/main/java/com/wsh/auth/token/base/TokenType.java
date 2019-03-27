package com.wsh.auth.token.base;

import com.wsh.auth.token.api.ApiToken;
import com.wsh.auth.token.app.AppToken;
import com.wsh.auth.token.platform.PlatformToken;
import com.wsh.auth.token.wxplatform.WxplatformToken;


public enum TokenType {

	app(AppToken.class),
	
	platform(PlatformToken.class),
	
	wxplatform(WxplatformToken.class),
	
	api(ApiToken.class),
	;
	
	private Class<? extends BaseToken> tokenClass;

	public Class<? extends BaseToken> getTokenClass() {
		return tokenClass;
	}
	
	private TokenType(Class<? extends BaseToken> tokenClass) {
		this.tokenClass = tokenClass;
	}
	
	public static Class<? extends BaseToken> getTokenClass(String type) {
		return TokenType.valueOf(type).tokenClass;
	}
	
}

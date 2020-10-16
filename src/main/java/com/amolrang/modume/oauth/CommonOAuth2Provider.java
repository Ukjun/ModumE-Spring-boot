package com.amolrang.modume.oauth;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistration.Builder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

public enum CommonOAuth2Provider {
	GOOGLE {
		@Override
		public Builder getBuilder(String registrationID) {
			ClientRegistration.Builder builder = getBuilder(registrationID, ClientAuthenticationMethod.BASIC);
			builder.scope("openid", "profile", "email");
			builder.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth");
			builder.tokenUri("https://www.googleapis.com/oauth2/v4/token");
			builder.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs");
			builder.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo");
			builder.userNameAttributeName(IdTokenClaimNames.SUB);
			builder.clientName("Google");
			builder.clientId("327498212271-k08jmuqgri0octbl5tt78h749pf5irg5.apps.googleusercontent.com");
			builder.clientSecret("sB_WQ5-BCPHXcvEcSjoeUyI8");
			return builder;
		}
	};
	
	

    private static final String DEFAULT_REDIRECT_URL = "{baseUrl}/login/oauth2/code/{registrationId}";


	protected final ClientRegistration.Builder getBuilder(String registrationId, ClientAuthenticationMethod method) {

		ClientRegistration.Builder builder = ClientRegistration.withRegistrationId(registrationId);
		builder.clientAuthenticationMethod(method);
		builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
		builder.redirectUriTemplate(CommonOAuth2Provider.DEFAULT_REDIRECT_URL);
		return builder;
	}

	public abstract Builder getBuilder(String registrationID);
}

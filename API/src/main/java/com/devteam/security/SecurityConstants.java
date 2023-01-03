package com.devteam.security;

public class SecurityConstants {
	public static final String SIGN_UP_URLS = "/api/users/**";
	public static final String SECRET = "SecretKeyToGenJWT";
	public static final String TOKEN_PREFIX = "Bearer "; // space is necessary after Bearer
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 30_000; // 30 seconds
}

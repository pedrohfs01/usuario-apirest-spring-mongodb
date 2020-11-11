package com.springteste.projetospring.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static Instant convertDate(String minDate, Instant min) {
		return LocalDateTime.parse(minDate, DateTimeFormatter.ofPattern( "yyyy-MM-dd")).toInstant(null);
	}
}

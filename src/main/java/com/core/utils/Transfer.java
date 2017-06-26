package com.core.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Transfer {
	public static final String COMMA = ",";

	public static Set<String> stringToSet(String sourceStr, String separator) {
		String[] source = sourceStr.split(separator);
		if (source.length <= 0) {
			return null;
		}
		return new HashSet<>(Arrays.asList(source));
	}
}

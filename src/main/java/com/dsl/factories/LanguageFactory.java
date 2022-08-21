package com.dsl.factories;

import com.dsl.models.language.LanguageCode;

public class LanguageFactory {

	public static LanguageCode createLanguageCode(String language, String code) {
		return new LanguageCode(language, code);
	}
}

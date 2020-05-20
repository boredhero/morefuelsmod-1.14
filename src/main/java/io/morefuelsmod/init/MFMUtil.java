package io.morefuelsmod.init;

import javax.annotation.Nonnull;

public final class MFMUtil {
	
	/* Credit for this class and section goes to Cadiboo
	 * https://github.com/Cadiboo/Example-Mod/blob/1.14.4/src/main/java/io/github/cadiboo/examplemod/ModUtil.java
	 * 
	 * The purpose of this is to supress warnings and return null without actually returning null.
	 */
	
	@Nonnull
	@SuppressWarnings("ConstantConditions")
	public static <T> T _null() {
		return null;
	}
}

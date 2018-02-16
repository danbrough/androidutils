/*
 * Copyright (c) 2004-2013 QOS.ch
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package org.slf4j.impl;

import android.util.Log;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;


public class AndroidLoggerFactory implements ILoggerFactory {
	static final String ANONYMOUS_TAG = "null";
	static final int TAG_MAX_LENGTH = 23;


	private static final String PROPERTIES_FILE = "/slf4j.properties";
	public static String TAG = "SLF4J";

	static ConcurrentHashMap<String, LogInfo> LOGGERS;
	static LogInfo DEFAULT_LOG_INFO;

	static {
		LOGGERS = new ConcurrentHashMap<>();
		configure();
	}

	public static class LogInfo {
		Logger log;
		String tag;
		int priority;
		boolean color;
	}


	private static void configure() {

		Log.d(TAG, "configure() loading " + PROPERTIES_FILE);
		InputStream is = AndroidLoggerFactory.class.getResourceAsStream(PROPERTIES_FILE);

		LogInfo logInfo = new LogInfo();
		logInfo.tag = "SLF4J";
		logInfo.priority = 0;//native
		logInfo.color = false;

		DEFAULT_LOG_INFO = logInfo;
		LOGGERS.put("", DEFAULT_LOG_INFO);

		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(is));
			String s;
			while ((s = input.readLine()) != null) {
				s = s.trim();
				if (s.length() == 0) continue;
				if (s.charAt(0) == '#') continue;

				int i = s.indexOf('=');
				if (i == -1) throw new IOException("Expecting a name=value pair");

				String name = s.substring(0, i).trim();
				String value = s.substring(i + 1).trim();

				String property = name.toLowerCase();
				i = property.indexOf('_');
				if (i > -1) {
					property = property.substring(i + 1);
					name = name.substring(0, i);
				} else {
					name = "";
				}

				if (property.equals("tag") || property.equals("level") || property.equals("colour") || property.equals("color")) {
					if (!property.equals("tag")) value = value.toLowerCase();
				} else {
					throw new IOException("Property must be one of tag|level|color|colour at [" + s + "]");
				}


				logInfo = LOGGERS.get(name);
				if (logInfo == null) {
					logInfo = new LogInfo();
					LOGGERS.put(name, logInfo);
				}

				Log.v(TAG, "SETTING " + property + " ON LOGGER: [" + name + "] TO " + value);

				switch (property) {
					case "color":
					case "colour":
						logInfo.color = value.equals("true") || value.equals("1") || value.equals("yes");
						break;
					case "tag":
						logInfo.tag = value;
						break;
					case "level":
						switch (value) {
							case "native":
								logInfo.priority = 0;
								break;
							case "all":
							case "verbose":
							case "trace":
								logInfo.priority = 1;
								break;
							case "debug":
								logInfo.priority = 2;
								break;
							case "info":
								logInfo.priority = 3;
								break;
							case "warn":
								logInfo.priority = 4;
								break;
							case "error":
								logInfo.priority = 5;
								break;
							default:
								throw new IllegalArgumentException("Invalid log level: " + value);
						}
						break;
					default:
						throw new IllegalArgumentException("Invalid property " + property);

				}


			}
			input.close();

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return;
		}

	}


	/**
	 * Tag names cannot be longer than {@value #TAG_MAX_LENGTH} characters on
	 * Android platform.
	 * <p>
	 * Returns the short logger tag (up to {@value #TAG_MAX_LENGTH} characters)
	 * for the given logger name. Traditionally loggers are named by
	 * fully-qualified Java classes; this method attempts to return a concise
	 * identifying part of such names.
	 * <p>
	 * See also: android/system/core/include/cutils/property.h
	 * android/frameworks/base/core/jni/android_util_Log.cpp
	 * dalvik.system.DalvikLogging
	 */
	static String loggerNameToTag(String loggerName) {
		// Anonymous logger
		if (loggerName == null) {
			return ANONYMOUS_TAG;
		}

		int length = loggerName.length();
		if (length <= TAG_MAX_LENGTH) {
			return loggerName;
		}

		int tagLength = 0;
		int lastTokenIndex = 0;
		int lastPeriodIndex;
		StringBuilder tagName = new StringBuilder(TAG_MAX_LENGTH + 3);
		while ((lastPeriodIndex = loggerName.indexOf('.', lastTokenIndex)) != -1) {
			tagName.append(loggerName.charAt(lastTokenIndex));
			// token of one character appended as is otherwise truncate it to one
			// character
			int tokenLength = lastPeriodIndex - lastTokenIndex;
			if (tokenLength > 1) {
				tagName.append('*');
			}
			tagName.append('.');
			lastTokenIndex = lastPeriodIndex + 1;

			// check if name is already too long
			tagLength = tagName.length();
			if (tagLength > TAG_MAX_LENGTH) {
				return getSimpleName(loggerName);
			}
		}

		// Either we had no useful dot location at all
		// or last token would exceed TAG_MAX_LENGTH
		int tokenLength = length - lastTokenIndex;
		if (tagLength == 0 || (tagLength + tokenLength) > TAG_MAX_LENGTH) {
			return getSimpleName(loggerName);
		}

		// last token (usually class name) appended as is
		tagName.append(loggerName, lastTokenIndex, length);
		return tagName.toString();
	}

	private static String getSimpleName(String loggerName) {
		// Take leading part and append '*' to indicate that it was truncated
		int length = loggerName.length();
		int lastPeriodIndex = loggerName.lastIndexOf('.');
		return lastPeriodIndex != -1 && length - (lastPeriodIndex + 1) <= TAG_MAX_LENGTH
				? loggerName.substring(lastPeriodIndex + 1) : '*' + loggerName.substring(length -
				TAG_MAX_LENGTH + 1);
	}

	/**
	 * Return a {@link AndroidLoggerAdapter} instance by name.
	 */


	@Override
	public Logger getLogger(String name) {

		String s = name;
		LogInfo logInfo = null;

		if (LOGGERS.containsKey(s)) {
			logInfo = LOGGERS.get(s);
		} else {
			int i = 0;
			while ((i = s.lastIndexOf('.')) > 0) {
				s = s.substring(0, i);
				if (LOGGERS.containsKey(s)) {
					Log.d(TAG, "found logger at: " + s + " for " + name);
					logInfo = LOGGERS.get(s);
					LOGGERS.put(name, logInfo);
					break;
				}
			}
		}

		if (logInfo == null) {
			if (ROOT_LOGGER == null) {
				ROOT_LOGGER = new AndroidLoggerAdapter(DEFAULT_LOG_INFO);
				DEFAULT_LOG_INFO.log = ROOT_LOGGER;
			}
			LOGGERS.put(name, DEFAULT_LOG_INFO);
			//	Log.i("TEST","using default log info: " + DEFAULT_LOG_INFO + " for " + name);
			return ROOT_LOGGER;
		}

		Logger log = logInfo.log;
		if (log == null) {
			log = new AndroidLoggerAdapter(logInfo);
			logInfo.log = log;
		}


		return log;
	}

	private static Logger ROOT_LOGGER;
}
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

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;


class AndroidLoggerAdapter extends MarkerIgnoringBase {
  private static final long serialVersionUID = -1227274521521287937L;

  private final int priority;
  private boolean color = false;

  /**
   * Package access allows only {@link AndroidLoggerFactory} to instantiate
   * SimpleLogger instances.
   */
  AndroidLoggerAdapter(AndroidLoggerFactory.LogInfo logInfo) {
    this.name = logInfo.tag;
    this.priority = logInfo.priority;
    this.color = logInfo.color;
  }

  /**
   * Is this logger instance enabled for the VERBOSE level?
   *
   * @return True if this Logger is enabled for level VERBOSE, false otherwise.
   */
  @Override
  public boolean isTraceEnabled() {
    return isLoggable(Log.VERBOSE);
  }

  /**
   * Log a message object at level VERBOSE.
   *
   * @param msg - the message object to be logged
   */
  @Override
  public void trace(String msg) {
    log(Log.VERBOSE, msg, null);
  }

  /**
   * Log a message at level VERBOSE according to the specified format and
   * argument.
   * <p>
   * <p>
   * This form avoids superfluous object creation when the logger is disabled
   * for level VERBOSE.
   * </p>
   *
   * @param format the format string
   * @param arg    the argument
   */
  @Override
  public void trace(String format, Object arg) {
    formatAndLog(Log.VERBOSE, format, arg);
  }

  /**
   * Log a message at level VERBOSE according to the specified format and
   * arguments.
   * <p>
   * <p>
   * This form avoids superfluous object creation when the logger is disabled
   * for the VERBOSE level.
   * </p>
   *
   * @param format the format string
   * @param arg1   the first argument
   * @param arg2   the second argument
   */
  @Override
  public void trace(String format, Object arg1, Object arg2) {
    formatAndLog(Log.VERBOSE, format, arg1, arg2);
  }

  /**
   * Log a message at level VERBOSE according to the specified format and
   * arguments.
   * <p>
   * <p>
   * This form avoids superfluous object creation when the logger is disabled
   * for the VERBOSE level.
   * </p>
   *
   * @param format   the format string
   * @param argArray an array of arguments
   */
  @Override
  public void trace(String format, Object... argArray) {
    formatAndLog(Log.VERBOSE, format, argArray);
  }

  /**
   * Log an exception (throwable) at level VERBOSE with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t   the exception (throwable) to log
   */
  @Override
  public void trace(String msg, Throwable t) {
    log(Log.VERBOSE, msg, t);
  }

  /**
   * Is this logger instance enabled for the DEBUG level?
   *
   * @return True if this Logger is enabled for level DEBUG, false otherwise.
   */
  @Override
  public boolean isDebugEnabled() {
    return isLoggable(Log.DEBUG);
  }

  /**
   * Log a message object at level DEBUG.
   *
   * @param msg - the message object to be logged
   */
  @Override
  public void debug(String msg) {
    log(Log.DEBUG, msg, null);
  }


  @Override
  public void debug(String format, Object arg) {
    formatAndLog(Log.DEBUG, format, arg);
  }

  @Override
  public void debug(String format, Object arg1, Object arg2) {
    formatAndLog(Log.DEBUG, format, arg1, arg2);
  }


  @Override
  public void debug(String format, Object... argArray) {
    formatAndLog(Log.DEBUG, format, argArray);
  }

  @Override
  public void debug(String msg, Throwable t) {
    log(Log.VERBOSE, msg, t);
  }


  @Override
  public boolean isInfoEnabled() {
    return isLoggable(Log.INFO);
  }

  @Override
  public void info(String msg) {
    log(Log.INFO, msg, null);
  }

  @Override
  public void info(String format, Object arg) {
    formatAndLog(Log.INFO, format, arg);
  }


  @Override
  public void info(String format, Object arg1, Object arg2) {
    formatAndLog(Log.INFO, format, arg1, arg2);
  }


  @Override
  public void info(String format, Object... argArray) {
    formatAndLog(Log.INFO, format, argArray);
  }


  @Override
  public void info(String msg, Throwable t) {
    log(Log.INFO, msg, t);
  }


  @Override
  public boolean isWarnEnabled() {
    return isLoggable(Log.WARN);
  }

  @Override
  public void warn(String msg) {
    log(Log.WARN, msg, null);
  }

  @Override
  public void warn(String format, Object arg) {
    formatAndLog(Log.WARN, format, arg);
  }


  @Override
  public void warn(String format, Object arg1, Object arg2) {
    formatAndLog(Log.WARN, format, arg1, arg2);
  }

  @Override
  public void warn(String format, Object... argArray) {
    formatAndLog(Log.WARN, format, argArray);
  }


  @Override
  public void warn(String msg, Throwable t) {
    log(Log.WARN, msg, t);
  }


  @Override
  public boolean isErrorEnabled() {
    return isLoggable(Log.ERROR);
  }

  @Override
  public void error(String msg) {
    log(Log.ERROR, msg, null);
  }


  @Override
  public void error(String format, Object arg) {
    formatAndLog(Log.ERROR, format, arg);
  }


  @Override
  public void error(String format, Object arg1, Object arg2) {
    formatAndLog(Log.ERROR, format, arg1, arg2);
  }


  @Override
  public void error(String format, Object... argArray) {
    formatAndLog(Log.ERROR, format, argArray);
  }


  @Override
  public void error(String msg, Throwable t) {
    log(Log.ERROR, msg, t);
  }

  private void formatAndLog(int priority, String format, Object... argArray) {
    if (isLoggable(priority)) {
      FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
      _log(priority, ft.getMessage(), ft.getThrowable());
    }
  }

  private void log(int priority, String message, Throwable throwable) {
    if (isLoggable(priority)) {
      _log(priority, message, throwable);
    }
  }

  private boolean isLoggable(int priority) {

    if (priority == 0) {
      return Log.isLoggable(name, priority);
    }

    return priority > this.priority;

  }

  /*
  else if ( /$MATCH/&& $5 == "D" ) {print "\x00\x1b[0;36m"$0"\x1b[0m"} \
	else if ( /$MATCH/&& $5 == "I" ) {print "\x00\x1b[0;32m"$0"\x1b[0m"} \
	else if ( /$MATCH/&& $5 == "W" ) {print "\x00\x1b[0;33m"$0"\x1b[0m"} \
	else if ( /$MATCH/&& $5 == "E" ) {print "\x00\x1b[0;31m"$0"\x1b[0m"} \
	else if ( /$MATCH/&& $5 == "F" ) {print "\x00\x1b[0;31m"$0"\x1b[0m"} \
*/

  private void _log(int priority, String message, Throwable throwable) {

    Thread thread = Thread.currentThread();
    StackTraceElement stackElements[] = thread.getStackTrace();
    StackTraceElement element = stackElements[5];
    String header = "[<" + thread.getName() + ":" + thread.getId() + ">:" + element.getClassName
        () + ":"
        + element.getMethodName() + "():" + element.getLineNumber() + "] ";
    message = header + message;
    if (throwable != null) {
      message += '\n' + Log.getStackTraceString(throwable);
    }

    if (color) {
      int color = 0;
      switch (priority) {
        case Log.VERBOSE:
          color = 35;
          break;
        case Log.DEBUG:
          color = 36;
          break;
        case Log.INFO:
          color = 32;
          break;
        case Log.WARN:
          color = 33;
          break;
        default:
          color = 31;
      }

      Log.println(priority, name, "\u001b[0;" + color + "m" + message + "\u001b[0m");
    } else {
      Log.println(priority, name, message);
    }
  }
}
package net.skds.ninvoker;

import java.lang.foreign.FunctionDescriptor;

import static java.lang.foreign.ValueLayout.*;

public class FunctionDescriptors {

	public static final FunctionDescriptor VP = FunctionDescriptor.ofVoid(ADDRESS);
	public static final FunctionDescriptor VPI = FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT);
	public static final FunctionDescriptor VIL = FunctionDescriptor.ofVoid(JAVA_INT, JAVA_LONG);

	public static final FunctionDescriptor SI = FunctionDescriptor.of(JAVA_SHORT, JAVA_INT);
	public static final FunctionDescriptor I = FunctionDescriptor.of(JAVA_INT);
	public static final FunctionDescriptor ILL = FunctionDescriptor.of(JAVA_INT, JAVA_LONG, JAVA_LONG);
	public static final FunctionDescriptor ILP = FunctionDescriptor.of(JAVA_INT, JAVA_LONG, ADDRESS);
}

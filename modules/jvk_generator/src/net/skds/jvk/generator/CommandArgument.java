package net.skds.jvk.generator;

import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.CBAnnotation;
import net.skds.lib2.misc.clazz.classbuilder.CBMethod;
import net.skds.lib2.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

record CommandArgument(String name, IDataType type, String comment) {

	public static List<CBMethod.Arg> arguments(List<CommandArgument> arguments) {
		List<CBMethod.Arg> args = new ArrayList<>();
		for (int i = 0; i < arguments.size(); i++) {
			CommandArgument a = arguments.get(i);
			Class<?> t = a.type().nativeType().javaType.clazz;
			args.add(new CBMethod.Arg(
					t,
					a.name(),
					List.of(new CBAnnotation(NativeType.class, StringUtils.quote(a.type().nativeTypeName()))),
					a.comment()
			));
		}
		return args;
	}
}

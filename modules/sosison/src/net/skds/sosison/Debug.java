package net.skds.sosison;

import net.skds.lib.mat.FastMath;
import net.skds.lib.utils.SKDSUtils;
import net.skds.lib.utils.collection.LongMap;

public class Debug {

	public static void main(String[] args) {

		int s = 1000_000_000;

		long[] longs = new long[s];
		Object[] objects = new Object[s];

		for (int i = 0; i < s; i++) {
			longs[i] = FastMath.RANDOM.nextLong();
			objects[i] = new Object();
		}

		long l = 0;
		LongMap<Object> map = new LongMap<>();
		//HashMap<Long, Object> map = new HashMap<>();
		var t = SKDSUtils.startTimeMeasure();

		for (int i = 0; i < s; i++) {
			map.put(longs[i], objects[i]);
		}

		for (int i = 0; i < s; i++) {
			l += map.get(longs[i]).hashCode();
		}

		System.out.println(l + "  " + t.query());

	}
}

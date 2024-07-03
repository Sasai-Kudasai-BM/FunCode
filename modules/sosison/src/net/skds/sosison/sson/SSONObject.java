package net.skds.sosison.sson;

public interface SSONObject {

	SSONObject getObject(long key);

	byte getByte(long key);

	short getShort(long key);

	int getInt(long key);

	long getLong(long key);

	byte[] getByteArray(long key);

	short[] getShortArray(long key);

	int[] getIntArray(long key);

	long[] getLongArray(long key);

	default SSONObject getObject(String key) {
		return getObject(SSONIndexer.geIndex(key));
	}
}

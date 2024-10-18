package net.skds.sosison.bson;

import lombok.RequiredArgsConstructor;

//https://bsonspec.org/spec.html
@RequiredArgsConstructor
public enum BsonType {

	// common
	NULL(10),
	BEGIN_OBJECT(3),
	END_OBJECT(0),
	BEGIN_ARRAY(4),
	END_ARRAY(0),
	STRING(2),
	BOOLEAN(8),

	// bson
	BINARY_DATA(5),
	INT_32(16),
	INT_64(18),
	DOUBLE(1),
	BYTE(-0x00FFFFFF),
	DOC_ID(7),

	// json
	NUMBER(-0x00FFFFFF);

	public final int bsonId;

}

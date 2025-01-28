package net.skds.funcode;

import net.skds.lib2.utils.SKDSUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) throws IOException {
		System.out.println("DEGeneration");
		Random r = new Random(0);
		byte[] data = new byte[1024 * 1024 * 16];
		r.nextBytes(data);
		System.out.println("Hash");
		String hash = SKDSUtils.hashArray(data);
		System.out.println(hash);

		System.out.println("zip");
		ByteArrayOutputStream boas = new ByteArrayOutputStream(data.length);
		ZipOutputStream zos = new ZipOutputStream(boas);
		ZipEntry ze = new ZipEntry("cum");
		zos.putNextEntry(ze);
		zos.write(data);
		zos.closeEntry();
		System.out.println("unzip");

		byte[] file = boas.toByteArray();
		System.out.println("File size: " + SKDSUtils.memoryCompact(file.length));
		file[2357] = 0;
		file[2358] = 0;
		file[2359] = 0;

		ByteArrayInputStream is = new ByteArrayInputStream(file);
		ZipInputStream zis = new ZipInputStream(is);
		System.out.println("Entry: " + zis.getNextEntry());
		byte[] data2 = zis.readAllBytes();
		System.out.println("Hash2");
		String hash2 = SKDSUtils.hashArray(data2);
		System.out.println(hash2);
	}
}

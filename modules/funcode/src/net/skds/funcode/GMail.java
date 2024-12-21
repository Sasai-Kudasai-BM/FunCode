package net.skds.funcode;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;

public class GMail {

	private static final Charset charset = StandardCharsets.UTF_8;

	private static final String msg = """
			{
			  "id": string,
			  "threadId": string,
			  "labelIds": [
			    string
			  ],
			  "snippet": string,
			  "historyId": string,
			  "internalDate": string,
			  "payload": {
			    object (MessagePart)
			  },
			  "sizeEstimate": integer,
			  "raw": string
			}			
			""";

	public static void main(String[] args) throws Exception {

		byte[] dataBytes = "dataString".getBytes();

		//CREATE KEYS
		//byte[] dk = Base64.getUrlDecoder().decode("AIzaSyBUWuOYnWsj_Bgnd6gUws1m2aZslipUOB8");
		//byte[] dk = Base64.getUrlDecoder().decode("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");
		byte[] dk = Base64.getUrlDecoder().decode("ubYKv8wfbj70SwOOaQyKdBiMgtjv");
		SecretKey originalKey = new SecretKeySpec(dk, 0, dk.length, "RSA");
		System.out.println(originalKey.getFormat());

		var factory = KeyFactory.getInstance("RSA");
		var spec = factory.getKeySpec(originalKey, RSAPrivateCrtKeySpec.class);
		PrivateKey k = factory.generatePrivate(spec);

		//PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(dk);
		//KeyFactory kf = KeyFactory.getInstance("RSA");
		//PrivateKey privKey = kf.generatePrivate(keySpec);
		//System.out.println(privKey);

		//KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		//keyPairGenerator.initialize(2048);
		//KeyPair keyPair = keyPairGenerator.generateKeyPair();
		//PrivateKey privateKey = keyPair.getPrivate();

		byte[] automaticSignatureBytes = sign("SHA256withRSA", k, dataBytes);

		System.out.println(Base64.getEncoder().encodeToString(automaticSignatureBytes));

		/*
		createJWT("jj", "hh", "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");
		HttpRequest request = HttpRequest.newBuilder()
				.header("Authorization", "Bearer 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")
				.POST(HttpRequest.BodyPublishers.ofString(msg))
				.uri(URI.create("https://gmail.googleapis.com/upload/gmail/v1/users/barnaulminemc@gmail.com/messages/send"))
				.build();
		var resp = HttpUtils.doRequest(request);
		System.out.println(new String(resp.data(), charset));

		 */

	}

	public static byte[] sign(String algorithms, PrivateKey privateKey, byte[] dataBytes) throws Exception {

		//CREATE SIGNATURE (use Hash first)
		Signature signature = Signature.getInstance(algorithms);
		signature.initSign(privateKey);
		signature.update(dataBytes);
		byte[] signatureBytes = signature.sign();

		//ENCODE SIGNATURE
		byte[] signatureEncodedBytes = Base64.getEncoder().encode(signatureBytes);
		String signatureEncodedString = new String(signatureEncodedBytes);

		//DISPLAY ENCODED SIGNATURE
		System.out.println("SIGNATURE = " + signatureEncodedString);

		//RETURN SIGNATURE
		return signatureBytes;
	}

	private static String createJWT(String payload, String header, String secret) {
		String payloadB64 = Base64.getUrlEncoder().encodeToString(payload.getBytes(charset));
		String headerB64 = Base64.getUrlEncoder().encodeToString(header.getBytes(charset));
		try {
			Cipher c = Cipher.getInstance("SHA256withRSA");
			System.out.println(c);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return null;
	}
}

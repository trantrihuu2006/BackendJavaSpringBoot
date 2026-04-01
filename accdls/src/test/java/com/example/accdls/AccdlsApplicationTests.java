package com.example.accdls;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class AccdlsApplicationTests {

	@Test
	void hash() throws NoSuchAlgorithmException {
		String password = "12345";

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte[] digest = md.digest();
		String md5Hash = DatatypeConverter.printHexBinary(digest);
	}

}

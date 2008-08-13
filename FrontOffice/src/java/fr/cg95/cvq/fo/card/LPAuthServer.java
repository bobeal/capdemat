/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and René le Clercq 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.fo.card;

import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.security.provider.SecureRandom;

/**
 * General class for handling a client authentification
 * 
 * @author Julien Pasquier, Lex Persona.
 */
public class LPAuthServer {
	// Message digest algorithms object identifier
	public static final String DIGEST_SHA256_OID = "2.16.840.1.101.3.4.2.1";
	public static final String DIGEST_SHA384_OID = "2.16.840.1.101.3.4.2.2";
	public static final String DIGEST_SHA512_OID = "2.16.840.1.101.3.4.2.3";

	// JCE provider
	private static final Provider provider = new BouncyCastleProvider();
	static {
		Security.removeProvider(provider.getName());
		Security.addProvider(provider);
	}

	/**
	 * Return the digest algorithm JCA name from
	 * a digest algorithm object identifier.
	 */
	private static String getDigestAlgorithmName(String digestAlgorithmOID) throws NoSuchAlgorithmException {
		String digestAlgorithmName = null;

		if (DIGEST_SHA256_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA-256";
		} else if (DIGEST_SHA384_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA-384";
		} else if (DIGEST_SHA512_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA-512";
		} else {
			throw new NoSuchAlgorithmException("Invalid digest algorithm.");
		}

		return digestAlgorithmName;
	}

	/**
	 * Return the digest with signature algorithm JCA name
	 * from the digest algorithm OID and the signature
	 * algorithm JCA name.
	 */
	private static String getDigestWithSignatureAlgorithmName(String digestAlgorithmOID, String signatureAlgorithmName)
		throws NoSuchAlgorithmException {
		String digestWithSignatureAlgorithmName = null;
		String digestAlgorithmName = null;

		if (DIGEST_SHA256_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA256";
		} else if (DIGEST_SHA384_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA384";
		} else if (DIGEST_SHA512_OID.equals(digestAlgorithmOID)) {
			digestAlgorithmName = "SHA512";
		} else {
			throw new NoSuchAlgorithmException("Invalid digest algorithm.");
		}

		digestWithSignatureAlgorithmName = digestAlgorithmName + "with" + signatureAlgorithmName;

		return digestWithSignatureAlgorithmName;
	}

	/**
	 * Create a new challenge (with a pseudo random number generator).
	 * @param nbBytesChallenge challenge size in bytes
	 *
	 * @return a new challenge
	 */
	public static byte[] generateChallenge(int nbBytesChallenge) {
		SecureRandom secureRandom = new SecureRandom();
		byte[] challenge = new byte[nbBytesChallenge];
		secureRandom.engineNextBytes(challenge);

		return challenge;
	}

	/**
	 * Hash a challenge with a message digest algorithm.
	 * @param challenge plain challenge to be hashed
	 * @param digestAlgorithmOID digest algorithm identifier used to hash the challenge
	 *
	 * @return a new challenge
	 */
	public static byte[] hashChallenge(byte[] challenge, String digestAlgorithmOID) throws NoSuchAlgorithmException {
		// Get the digest algorithm JCA name
		String digestAlgorithmName = getDigestAlgorithmName(digestAlgorithmOID);

		// Hash the challenge
		MessageDigest messageDigest = MessageDigest.getInstance(digestAlgorithmName, provider);
		byte[] hashedChallenge = messageDigest.digest(challenge);

		return hashedChallenge;
	}

	/**
	 * Verify the signature with the original challenge.
	 * @param signatureValue signature (digest encryption)
	 * @param digestAlgorithmOID digest algorithm identifier
	 * @param encodedSignerCertificate encoded X509 certificate of the signer
	 * @param challenge original challenge to match with the signed data
	 */
	public static void verifyChallengeSignature(
		byte[] signatureValue,
		String digestAlgorithmOID,
		byte[] encodedSignerCertificate,
		byte[] challenge)
		throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, CertificateException {
			
		// Get the X509 certificate of the signer
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", provider);
		X509Certificate signerCertificate =
			(X509Certificate) certificateFactory.generateCertificate(
				new ByteArrayInputStream(encodedSignerCertificate));

		// Verify if certificate is an autosigned certificate
		if (!signerCertificate.getSubjectX500Principal().equals(signerCertificate.getIssuerX500Principal())) {
			throw new CertificateException("Not autosigned certificate.");
		}

		// Get the signer public key
		PublicKey publicKey = signerCertificate.getPublicKey();

		// Verify certificate signature
		signerCertificate.verify(publicKey, provider.getName());

		// Get the digest with signature algorithm JCA name
		String digestWithSignatureAlgorithmName =
			getDigestWithSignatureAlgorithmName(digestAlgorithmOID, publicKey.getAlgorithm());

		// Verify the signature
		Signature signature = Signature.getInstance(digestWithSignatureAlgorithmName, provider);
		signature.initVerify(publicKey);
		signature.update(challenge);
		if (!signature.verify(signatureValue)) {
			throw new SignatureException("Invalid challenge signature.");
		}
	}
}

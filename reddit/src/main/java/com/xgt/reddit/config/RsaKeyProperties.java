package com.xgt.reddit.config;

import java.security.interfaces.RSAPrivateKey;

import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

}

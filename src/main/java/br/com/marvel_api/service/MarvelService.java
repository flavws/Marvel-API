package br.com.marvel_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Service
public class MarvelService {

    @Value("${marvel.api.public.key}")
    private String publicKey;

    @Value("${marvel.api.private.key}")
    private String privateKey;

    @Value("${marvel.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String fetchFromMarvel(String category, String name, int page, int size, String orderBy) {
        long timestamp = Instant.now().getEpochSecond();
        String hash = generateHash(timestamp);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(apiUrl + "/" + category)
                .queryParam("ts", timestamp)
                .queryParam("apikey", publicKey)
                .queryParam("hash", hash)
                .queryParam("offset", page * size)
                .queryParam("limit", size)
                .queryParam("orderBy", orderBy);

        if (name != null) {
            uriBuilder.queryParam("nameStartsWith", name);
        }

        return restTemplate.getForObject(uriBuilder.toUriString(), String.class);
    }

    private String generateHash(long timestamp) {
        try {
            String value = timestamp + privateKey + publicKey;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(value.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not generate hash", e);
        }
    }
}

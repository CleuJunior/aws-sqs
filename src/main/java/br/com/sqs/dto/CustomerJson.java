package br.com.sqs.dto;


public record CustomerJson(Long id, String firstName, String lastName) {

    public CustomerJson(String name, String email) {
        this(null, name, email);
    }
}

package me.gumenny.githubler.data.mappers;

public interface Mapper<A, B> {
    B transform(A obj) throws RuntimeException;
}

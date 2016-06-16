package com.example.com.example.rr.convert;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import java.io.IOException;

final class MyRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    MyRequestBodyConverter() {

    }

    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.toString());
    }
}

package com.june.eg.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class IPInfoConverterFactory extends Converter.Factory {

	public static IPInfoConverterFactory create() {
		return new IPInfoConverterFactory();
	}

	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
		return new IPInfoResponseBodyConverter<IPInfo>();
	}

	@Override
	public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
		return new IPInfoRequestBodyConverter<IPInfo>();
	}
}

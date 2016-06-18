package com.june.eg.retrofit.convert;

import com.june.eg.retrofit.RespInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class MyConverterFactory extends Converter.Factory {

	public static MyConverterFactory create() {
		return new MyConverterFactory();
	}

	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
		return new MyResponseBodyConverter<RespInfo>();
	}

	@Override
	public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
		return new MyRequestBodyConverter<RespInfo>();
	}
}

package com.example.com.example.rr.convert;

import com.example.com.example.rr.RespInfo;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

	JsonResponseBodyConverter() {

	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		RespInfo respInfo = new RespInfo();
		int start = value.string().indexOf(">>") + 1;
		int end = start + value.string().substring(start).indexOf("<");
		respInfo.domain = value.string().substring(start, end);
		return (T) respInfo;
	}

}

package com.june.eg.retrofit;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class IPInfoResponseBodyConverter<T> implements Converter<ResponseBody, T> {

	IPInfoResponseBodyConverter() {

	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		if (value == null) {
			System.out.println("responsebody is null");
		} else {
			String charset = value.contentType().charset().toString();
			if(charset == null || charset.trim().length() < 1){
				charset = "utf-8";
			}
			String result = new String(value.bytes(), charset);
//			System.out.println("responsebody " + result);

			String s = result.substring(result.indexOf("id=\"result\""));
			s = s.substring(s.indexOf("<code>") + 6);
			s = s.substring(0, s.indexOf("</code>"));

			IPInfo respInfo = new IPInfo();
			respInfo.domain = s;
			return (T) respInfo;

		}

		return null;
	}
}
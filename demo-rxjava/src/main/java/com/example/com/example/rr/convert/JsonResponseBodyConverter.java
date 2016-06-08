package com.example.com.example.rr.convert;

import com.example.com.example.rr.RespInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

	JsonResponseBodyConverter() {

	}

	@Override
	public T convert(ResponseBody value) throws IOException {
		if (value == null) {
			System.out.println("responsebody is null");
		} else {
			//			System.out.println("responsebody value " + value.string());
			//			System.out.println(" " + new String(value.string().getBytes("gb2312"), "gb2312"));
			//			value.byteStream();
			//			BufferedReader br = new BufferedReader(new InputStreamReader(value.byteStream()));
			//			StringBuilder sb = new StringBuilder();
			//			String s = null;
			//			while ((s = br.readLine()) != null){
			//				sb.append(s);
			//			}
			String charset = value.contentType().charset().toString();
			if(charset == null || charset.trim().length() < 1){
				charset = "utf-8";
			}
			String result = new String(value.bytes(), charset);
			System.out.println("responsebody " + result);

			String s = result.substring(result.indexOf("id=\"result\""));
			s = s.substring(s.indexOf("<code>") + 6);
			s = s.substring(0, s.indexOf("</code>"));

			RespInfo respInfo = new RespInfo();
			respInfo.domain = s;
			return (T) respInfo;

		}

		return null;
	}
}
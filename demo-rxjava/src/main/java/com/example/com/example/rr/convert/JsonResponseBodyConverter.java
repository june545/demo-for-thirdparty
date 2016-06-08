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

			String result = new String(value.bytes(), "gb2312");
//			System.out.println("responsebody " + result);
			RespInfo respInfo = new RespInfo();
			int start = result.indexOf(">>") + 1;
			int end = start + result.substring(start).indexOf("<");
			respInfo.domain = result.substring(start, end);
			return (T) respInfo;

		}

		return null;
	}
}
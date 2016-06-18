package com.june.eg.rx;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class TestRx {

	public static final void main(String[] args) {
		test2();
	}

	private static void test1() {
		Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("publish a news ");
				subscriber.onCompleted();
			}
		});

		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				System.out.println("I read it.");
			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				System.out.println("I accept: " + s);
			}
		};

		observable.subscribe(subscriber);
	}

	private static void test2() {
		Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("publish a news ");
				subscriber.onCompleted();
			}
		}).map(new Func1<String, String>() {
			@Override
			public String call(String o) {

				return " 2016-6-8 " + o;
			}
		});

		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				System.out.println("I read it.");
			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				System.out.println("I accept: " + s);
			}
		};

		observable.subscribe(subscriber);
	}


}

package com.june.eg.rx;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class TestRx {

	public static final void main(String[] args) {
//		test2();
		flat();
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
				subscriber.onNext("下雨了");
				subscriber.onCompleted();
			}
		}).map(new Func1<String, String>() {
			@Override
			public String call(String o) {

				return "打雷了，" + o;
			}
		});

		Subscriber<String> subscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				System.out.println("回家收衣服了!");
			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				System.out.println(s);
			}
		};

		observable.subscribe(subscriber);
	}

	static void flat(){
		Observable.just("hello ").flatMap(new Func1<String, Observable<String>>() {
			@Override
			public Observable<String> call(String s) {
				return Observable.just(s + "world");
			};
		}).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});

	}


}

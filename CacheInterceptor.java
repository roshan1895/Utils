package com.example.retrofitdemo.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request=chain.request();
        Response response=chain.proceed(request);
        CacheControl cache=new CacheControl.Builder().maxAge(10, TimeUnit.DAYS).build();
        response.header("Cache-Control",cache.toString());
        return response;
    }
}

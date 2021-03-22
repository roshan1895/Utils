package com.example.retrofitdemo.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthTokenInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest=chain.request();
        Request newRequest=originalRequest.newBuilder().header("Authorization", "AuthToken").build();
        // replace "Authorization" with your access token key name.
        // replace "AuthToken" with your access token value.
        return chain.proceed(newRequest);
    }
}

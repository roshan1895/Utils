package com.example.retrofitdemo.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ForceCacheInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder builder=chain.request().newBuilder();
        if (!IsInternetAvailable()) {
            builder.cacheControl(CacheControl.FORCE_CACHE);

        }
        return chain.proceed(builder.build());    }
}

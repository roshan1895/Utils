package com.example.retrofitdemo.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ErrorInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request=chain.request();
        Response response=chain.proceed(request);
        switch (response.code())
        {
            case 400:                //Show Bad Request Error Message
                break;
            case 401:               //Show UnauthorizedError Message
                break;
            case 403:                //Show Forbidden Message
                break;
            case 404:                //Show NotFound Message
                break;

            // ... and so on
            /*
              We can pass the error to the view using via the interfaces or by using something like RxJava, EventBus, and etc.
                 */
        }
        return response;
    }
}

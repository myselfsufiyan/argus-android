package com.moldedbits.argus.sample;

import android.app.Application;

import com.moldedbits.argus.Argus;
import com.moldedbits.argus.ArgusThemeBuilder;
import com.moldedbits.argus.SimpleNextScreenProvider;
import com.moldedbits.argus.provider.BaseProvider;
import com.moldedbits.argus.provider.login.EmailLoginProvider;
import com.moldedbits.argus.provider.signup.EmailSignupProvider;
import com.moldedbits.argus.provider.social.FaceBookSignupProvider;
import com.moldedbits.argus.provider.social.GoogleSignupProvider;
import com.moldedbits.argus.storage.DefaultArgusStorage;

import java.util.ArrayList;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<BaseProvider> loginProviders = new ArrayList<>();
        ArrayList<BaseProvider> signupProviders = new ArrayList<>();
        loginProviders.add(new EmailLoginProvider());
        loginProviders.add(new FaceBookSignupProvider());
        loginProviders.add(new GoogleSignupProvider());

        signupProviders.add(new EmailSignupProvider());
        signupProviders.add(new FaceBookSignupProvider());
        signupProviders.add(new GoogleSignupProvider());

        ArgusThemeBuilder argusThemeBuilder = new ArgusThemeBuilder()
                .buttonColor(R.color.com_facebook_blue)
                .build();

        new Argus.Builder()
                .argusStorage(new DefaultArgusStorage(getApplicationContext()))
                .nextScreenProvider(new SimpleNextScreenProvider(MainActivity.class))
                .signupProviders(signupProviders)
                .loginProviders(loginProviders)
                .theme(argusThemeBuilder)
                .signupLayout(R.layout.custom_signup_layout)
                .build();

    }
}
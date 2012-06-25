package com.github.caarlos0;

import com.github.caarlos0.helper.PersistenceHelper;
import com.google.inject.Injector;

public class App {
    public static void main(String[] args) {
        Injector i = PersistenceHelper.getInjector();
    }
}
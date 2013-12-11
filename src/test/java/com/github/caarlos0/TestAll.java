package com.github.caarlos0;

import com.github.caarlos0.tests.BasicTests;
import com.github.caarlos0.tests.CallbackTests;
import com.github.caarlos0.tests.SortableTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicTests.class, CallbackTests.class, SortableTests.class })
public class TestAll {

}

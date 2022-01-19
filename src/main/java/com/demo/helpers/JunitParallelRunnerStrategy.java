package com.demo.helpers;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

//There is a problem with Junit parallel running with 'fixed' strategy. As work around need create strategy class and use 'custom' strategy.
//https://github.com/junit-team/junit5/issues/2273
public class JunitParallelRunnerStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {
    @Override
    public int getParallelism() {
        return Integer.parseInt(System.getProperty("threadCount"));
    }

    @Override
    public int getMinimumRunnable() {
        return Integer.parseInt(System.getProperty("threadCount"));
    }

    @Override
    public int getMaxPoolSize() {
        return Integer.parseInt(System.getProperty("threadCount"));
    }

    @Override
    public int getCorePoolSize() {
        return Integer.parseInt(System.getProperty("threadCount"));
    }

    @Override
    public int getKeepAliveSeconds() {
        return 30;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(final ConfigurationParameters configurationParameters) {
        return this;
    }
}
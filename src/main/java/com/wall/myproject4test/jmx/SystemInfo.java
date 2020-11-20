package com.wall.myproject4test.jmx;

public class SystemInfo implements SystemInfoMBean {
    @Override
    public int getCpuCore() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }
}

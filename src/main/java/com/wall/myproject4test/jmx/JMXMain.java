package com.wall.myproject4test.jmx;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class JMXMain {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer mbean = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.wall.my-project4test:type=SystemInfo");
        SystemInfo systemInfo = new SystemInfo();
        mbean.registerMBean(systemInfo,objectName);
        System.in.read();
    }
}

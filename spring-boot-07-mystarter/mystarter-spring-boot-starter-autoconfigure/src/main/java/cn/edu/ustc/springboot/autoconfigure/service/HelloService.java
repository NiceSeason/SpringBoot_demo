package cn.edu.ustc.springboot.autoconfigure.service;

import cn.edu.ustc.springboot.autoconfigure.properties.HelloProperties;

public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
        return helloProperties.getPrefix()+"-" +name + helloProperties.getSuffix();
    }
}

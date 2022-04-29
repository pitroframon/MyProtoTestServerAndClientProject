package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:8080")
                .usePlaintext()
                .build();

        com.example.myprotoproject.GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                com.example.myprotoproject.GreetingServiceGrpc.newBlockingStub(channel);

        com.example.myprotoproject.GreetingServiceOuterClass.HelloRequest helloRequest =
                com.example.myprotoproject.GreetingServiceOuterClass.HelloRequest.newBuilder()
                        .setName("Roma")
                        .addHobbies("basketball")
                        .build();

        com.example.myprotoproject.GreetingServiceOuterClass.HelloResponse helloResponse = stub.greeting(helloRequest);

        System.out.println(helloResponse);

        channel.shutdownNow();
    }
}

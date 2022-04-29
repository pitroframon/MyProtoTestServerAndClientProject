package org.example;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends com.example.myprotoproject.GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(com.example.myprotoproject.GreetingServiceOuterClass.HelloRequest helloRequest,
                         StreamObserver<com.example.myprotoproject.GreetingServiceOuterClass.HelloResponse> helloResponseStreamObserver){

        System.out.println(helloRequest);

        com.example.myprotoproject.GreetingServiceOuterClass.HelloResponse response =
                com.example.myprotoproject.GreetingServiceOuterClass.HelloResponse.newBuilder()
                        .setGreeting("Hello from server, " + helloRequest.getName() + ". "
                                + helloRequest.getHobbiesList() + " is real funny!")
                        .build();

        helloResponseStreamObserver.onNext(response);
        helloResponseStreamObserver.onCompleted();
    }
}

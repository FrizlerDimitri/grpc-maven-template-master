package de.othr.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SampleServer {

    public static final String SAMPLE_GRPC_HOST = "localhost";
    public static final int SAMPLE_GRPC_PORT    = 1234;

    public static void main(String[] args) {

        Server server = ServerBuilder.forPort(SAMPLE_GRPC_PORT)
                .addService(new MyServiceImpl())
                .build();

        try {
            server.start();
            System.out.println("Server running...");


            server.awaitTermination();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

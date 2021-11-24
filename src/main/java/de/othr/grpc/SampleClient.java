package de.othr.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import your.pkg.Messwert;
import your.pkg.MesswertServiceGrpc;

public class SampleClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(SampleServer.SAMPLE_GRPC_HOST,
                        SampleServer.SAMPLE_GRPC_PORT)
                .usePlaintext()
                .build();

        //SampleServiceGrpc.SampleServiceBlockingStub stub = SampleServiceGrpc.newBlockingStub(channel);
        MesswertServiceGrpc.MesswertServiceBlockingStub stub = MesswertServiceGrpc.newBlockingStub(channel);


        Messwert messwert=your.pkg.Messwert.newBuilder().setValue(3.4f).setContext("dfsdfsdf").build();

        your.pkg.Bewertung b = stub.getBewertung(messwert);

        System.out.println(b.getMess());

        channel.shutdown();

        //Generate messages, use stub

    }
}

package de.othr.grpc;

import io.grpc.stub.StreamObserver;
import your.pkg.Bewertung;
import your.pkg.Messwert;
import your.pkg.MesswertServiceGrpc;

public class MyServiceImpl extends MesswertServiceGrpc.MesswertServiceImplBase {

    @Override
    public void getBewertung(Messwert request, StreamObserver<Bewertung> responseObserver) {

        Bewertung bewertung=your.pkg.Bewertung.newBuilder().setMess(request.getContext() + " passt so ").build();

        responseObserver.onNext(bewertung);
        responseObserver.onCompleted();


        //super.getBewertung(request, responseObserver);
    }
}

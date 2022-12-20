package Semana11;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //Crear un subscriber y susbcripcon
        PrimerSubcritor  printerSuscbriber = new PrimerSubcritor();
        //Funcion
        Function<String, String> toUpper = String::toUpperCase;
        //Crear Processor
        TransformProcessor transformProcessor = new TransformProcessor(toUpper);
        //Susbcripcion

        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(printerSuscbriber);

        List<String> items = List.of("juna","pedro","mayra","ana","ariel","Diego");
        //Enviar los datos a los succrioptores

        items.forEach(publisher::submit);

        Thread.sleep( 1* 1000);

        publisher.close();

    }
}

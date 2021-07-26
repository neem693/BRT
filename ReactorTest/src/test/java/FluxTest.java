import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



import static org.assertj.core.api.Assertions.*;


public class FluxTest {

    @Test
    public void test1(){

        List<Integer> elements = new ArrayList<>();

        Flux.just(1,2,3,4)
                .log()
                .subscribe(x ->{
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    elements.add(x);
                } );

        assertThat(elements).containsExactly(1,2,3,4);

    }

    @Test
    public void test2(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,4)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;
                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        s.request(Long.MAX_VALUE);

                        s.request(2);
                    }

                    @Override
                public void onNext(Integer integer) {
                        elements.add(integer);
                        onNextAmount++;
                        if(onNextAmount % 2 == 0){
                            s.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Test
    public void test3(){
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,4)
                .log()
                .map(i -> i*2)
                .subscribe(x-> elements.add(x));


    }

    @Test
    public void test4(){
        List<String> elements = new ArrayList<>();
        Flux.just(1,2,3,4)
                .log()
                .map(i -> i*2)
                .zipWith(Flux.range(0,Integer.MAX_VALUE),
                        (one,two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
                .subscribe(x-> elements.add(x));
        System.out.println(elements);
        assertThat(elements).containsExactly(
                "First Flux: 2, Second Flux: 0",
                "First Flux: 4, Second Flux: 1",
                "First Flux: 6, Second Flux: 2",
                "First Flux: 8, Second Flux: 3");
    }

    @Test
    public void test5(){

        ConnectableFlux<Object> publish = Flux.create(fluxSink ->{
            while(true){
                fluxSink.next(System.currentTimeMillis());
            }
        }).publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);

        publish.connect();

    }

    @Test
    public void test6(){

        ConnectableFlux<Object> publish = Flux.create(fluxSink ->{
            while(true){
                fluxSink.next(System.currentTimeMillis());
            }
        }).sample(Duration.ofSeconds(2))
                .publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);

        publish.connect();

    }



    @Test
    public void test7(){
        List<Integer> elements0 = new ArrayList<>();
        Flux.just(1,2,3,4)
                .log()
                .subscribe(x -> elements0.add(x));
        List<Integer> elements = new ArrayList<>();
        Flux.just(1,2,3,4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(x-> elements.add(x));

        assertThat(elements).containsExactly(2,4,6,8);


    }





}

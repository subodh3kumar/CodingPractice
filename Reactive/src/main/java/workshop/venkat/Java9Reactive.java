package workshop.venkat;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Java9Reactive {

    public static void main(String[] args) {

        SubmissionPublisher<Integer> feed = new SubmissionPublisher<>();

        feed.subscribe(new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(5);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println(item);
                subscription.request(1);

                /*if (item == 5) {
                    subscription.cancel();
                }*/
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("ERROR: " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("DONE");
            }
        });

        for (int i = 1; i <= 10; i++) {
            feed.submit(i);
        }

        sleep(10000);
        System.out.println("-----");
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}

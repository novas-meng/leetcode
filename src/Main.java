import java.util.concurrent.*;

class MyRunnable implements Callable
{

    @Override
    public Object call() throws Exception {

            System.out.println(Thread.currentThread()+","+Thread.activeCount());
            Thread.sleep(100000);

        return 1;
    }
}
class MyRunnable2 implements Callable
{

    @Override
    public Object call() throws Exception {
        for (int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread()+","+i+"===="+Thread.activeCount());
        }
        return 1;
    }
}
class Main
{
    public static void main(String[] args)
    {
        System.out.println();
        ThreadPoolExecutor service=new ThreadPoolExecutor(3, 4,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>());
        //ExecutorService service= Executors.newFixedThreadPool(2);

        service.submit(new MyRunnable());
        service.submit(new MyRunnable());
        service.submit(new MyRunnable());
        service.submit(new MyRunnable());
        for (int i=0;i<1000;i++)
        {
           // service.submit(new MyRunnable());
        }
        Future future=service.submit(new MyRunnable2());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 4. 已知远程接口 remote_call()有频率限制1分钟最多60次。请封装一个本地接口local_call()，本地其他API调用local_call()，可达到这样的效果：
 * 不超过频率时正常调用，超过频率时调用被延迟至下一分钟再执行调用
 */
public class Test7 {
    static volatile Integer count;

    static ReentrantLock lock = new ReentrantLock();
    static Condition full = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new Task1()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test7 test7 = new Test7();
        for (int i = 0; i < 61; i++) {
            test7.localCall();
        }
    }

    public void localCall() {
        lock.lock();
        try {
            if (count <= 0) {
                full.await();
                System.out.println("执行次数超过限定值！");
            } else {
                count--;
                remoteCall();
                System.out.println("当前时间还剩余执行次数="+count);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    static class Task1 implements Runnable {
        boolean flag = false;
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    System.out.println("刷新执行次数");
                    count = 60;
                    full.signalAll();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void remoteCall() {

    }

}

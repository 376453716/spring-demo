### Thread && Progress
1. Thread 
操作系统对执行的程序的抽象，实现多个程序同时运行的效果，每个进程有独立的程序计数器、堆栈、状态信息、内存空间
线程，一个进程中的多个执行

### jdk concurrent package

1. Death lock

```
Node : Parent p Child c

p.addChild(c)-->
    p.addChild(c) lock p
    c.setParent(p) try lock c
    
c.setParent(p)--->
    c.setParent(p) lock c
    p.addChild(c)   tryLock p
```    
2.communication

```
Thread 1 pool.in...		waite out... 
Thread 2 pool.out...		waite in ...

pool 
	empty state
	sync in			empty->false notifyAll
	sync out		empty->true notifyAll
	sync waiteIn	not empty?->wait()
	sync waiteOut	empty->wait()

	sync 自动释放锁

pool2
	pool state
	reentrantLock
	lock.condition

	lock in			empty->false condition.signalAll unlock
	lock out		empty->true condition.signalAll unlock
	lock waiteIn	not empty?->condition.wait() unlock
	lock waiteOut	empty->condition.wait() unlock
```

### AQS

### util
 
 
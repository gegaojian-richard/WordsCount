# WordsCount

Java并发编程 - 多线程协作统计多个文件单词数

基于ConcurrentHashMap,使用CAS编程模式实现

WordCounter - 单词计数器，底层为一个ConcurrentHashMap,采用CAS模式实现increase方法

TerminationToken - 统计结束标志，单例，利用synchronized关键字对volatile变量赋值，volatile保证变量对客户端主线程的内存可见性

Worker - 统计工作类，统计完成后调用TerminationToken单例的add方法

Main - 客户端类，创建单词计数器、统计工作者实例，监控TerminationToken单例，统计完成后打印单词总次数

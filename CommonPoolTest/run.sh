#Trying to cause a similar crash to:
# ---------------  P R O C E S S  ---------------
#
#Java Threads: ( => current thread )
#   0x000000000f9fd000 JavaThread "ForkJoinPool.commonPool-worker-1" daemon [_thread_blocked, id=6024, stack(0x00007ffe6429e000,0x00007ffe6439f000)]
#
export JAVA_HOME=/home/fdemeloj/Downloads/cases/jdk-11.0.10+9
$JAVA_HOME/bin/javac CommonPoolTest.java  -Xdiags:verbose
#Not valid: $JAVA_HOME/bin/java CommonPoolTest -Djava.util.concurrent.ForkJoinPool.common.parallelism=20 
$JAVA_HOME/bin/java -Djava.util.concurrent.ForkJoinPool.common.parallelism=20000 CommonPoolTest

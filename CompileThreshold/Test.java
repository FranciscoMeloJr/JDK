
public class Test{

	public static void main(String[] args) throws Exception
	{
	for (int i = 0; i < 10000; i++)
	{
	    call();
	}
	Thread.sleep(1000);
	}

	private static void call()
	{
	if (System.currentTimeMillis() == 0)
	{
	    System.out.println("foo");
	}
	}
}
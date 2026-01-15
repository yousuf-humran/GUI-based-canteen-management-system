public abstract class Food implements Payment
{
	protected String name;
	protected int price;

	public abstract int getPrice();
}

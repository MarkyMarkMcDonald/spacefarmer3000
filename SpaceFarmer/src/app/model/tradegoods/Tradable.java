package app.model.tradegoods;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:31 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public interface Tradable {

	/**
	 * @return The base price of a Tradable.
	 */
	int getBasePrice();

	/**
	 * @return The name of a Tradable.
	 */
	String getName();
}

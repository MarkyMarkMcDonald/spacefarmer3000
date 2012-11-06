package App.model;

import java.util.Map;
import java.util.Set;

import App.service.Randomizer;

public class RandomEvent {
	
	private static final double EVENT_CHANCE=.05;
	private static final int CHANGE_MIN=1;
	private static final int CHANGE_MAX=10;
	
	public static void findItem(Player player)
	{
		int addAmount=CHANGE_MIN+Randomizer.nextInt(CHANGE_MAX-CHANGE_MIN+1);
		TradeGoodType type=(TradeGoodType) Randomizer.randEnum(TradeGoodType.class);
		Enum<?>[] subNames=type.getSubNames();
		Class<? extends Enum<?>> enumType=(Class<? extends Enum<?>>) subNames[0].getClass();
		BasicGood good=new BasicGood(type, (Enum<?>) Randomizer.randEnum(enumType));
		Ship ship=player.getShip();
		int cargoSize=ship.getCargoSize();
		if (player.getInventory().getSpaceUsed()+addAmount>cargoSize)
		{
			addAmount=cargoSize-player.getInventory().getSpaceUsed();
		}
		player.getInventory().addItem(good, addAmount);
	}
	
	public static void loseItem(Player player)
	{
		int loseAmount=CHANGE_MIN+Randomizer.nextInt(CHANGE_MAX-CHANGE_MIN+1);
		Set<Tradable> goodsSet=player.getInventory().getTradablesHeld();
		Tradable[] goods=goodsSet.toArray(new Tradable[0]);
		Tradable lostGood= (Tradable) Randomizer.randElement(goods);
		if (player.getInventory().getQuantity(lostGood) < loseAmount)
		{
			loseAmount=player.getInventory().getQuantity(lostGood);
		}
		player.getInventory().addItem(lostGood,-loseAmount);
	}
	
	

}

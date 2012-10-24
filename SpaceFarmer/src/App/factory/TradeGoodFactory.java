package App.factory;

import java.util.HashMap;
import java.util.Map;

import App.model.Equipment;
import App.model.Food;
import App.model.IndustrialGood;
import App.model.NaturalResource;
import App.model.TradeGood;
import App.model.TradeGoodType;
import static App.model.Category.*;

public class TradeGoodFactory {
	private static Map<TradeGoodType,TradeGood> goods;
	
	public static TradeGood getTradeGood(TradeGoodType type)
	{
		if (goods == null)
			goods=new HashMap<TradeGoodType,TradeGood>(TradeGoodType.values().length);
		if (goods.containsKey(type))
			return goods.get(type);

		return goods.get(type);
	}
	

}

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
		switch (type.getCategory())
		{
		      case(EQUIPMENT):
		    	  goods.put(type, new Equipment(type));
		    	  return goods.get(type);
		      case(FOOD):
		    	  goods.put(type, new Food(type));
		    	  return goods.get(type);
		      case(INDUSTRIALGOOD):
		    	  goods.put(type, new IndustrialGood(type));
		    	  return goods.get(type);
		      case(NATURALRESOURCE):
		    	  goods.put(type, new NaturalResource(type));
		    	  return goods.get(type);
		           
		}
		return goods.get(type);
	}
	

}

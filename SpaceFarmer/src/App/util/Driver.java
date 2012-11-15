package app.util;

import app.factory.UniverseFactory;
import app.model.Game;
import app.view.Display;
import conf.GameVariables;
import conf.PlanetNames;
import conf.SystemNames;

import java.awt.*;

/**
 * This class starts the SpaceFarmer game; it has the program's main method.
 * 
 * @author Mark McDonald, Andrew Wilder
 */
public class Driver {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// There is a singleton Game (holds all information) and
					// Display (Holds all the views and the layout
					// configuration)s.
					Display frame = new Display();
					frame.setVisible(true);
					Game game = new Game();
					Display.setGame(game);
					UniverseFactory.createUniverse(
							PlanetNames.getPlanetNamesAsList(),
							SystemNames.getSystemNamesAsList(),
							GameVariables.NumPlanets,
							GameVariables.NumPlanetarySystems,
							GameVariables.SystemRows,
							GameVariables.SystemColumns,
							GameVariables.UniverseRows,
							GameVariables.UniverseColumns,
							GameVariables.QuadrantXDimension,
							GameVariables.QuadrantYDimension,
							GameVariables.MinimumSystemDistance);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Driver";
	}
}

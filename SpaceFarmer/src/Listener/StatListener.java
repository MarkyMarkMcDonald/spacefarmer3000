package App.model;

public class StatListener {
	
	public actionPerformed(ActionEvent e)
	{
	    if(SettingService.checkCorrect())
        {
		    Display.moveToTemporaryScreen();
	    }
    }

}


package controller;


public class ControllerForModel implements IControllerForModel {

	private static ControllerForModel instance = null;

	private ControllerForModel() {
		//to-do
	}

	public IControllerForModel getInstance() {
		if (instance == null)
			instance = new ControllerForModel();
		return instance;
	}
}
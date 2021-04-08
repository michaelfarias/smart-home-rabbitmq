package br.ufc.crateus.smarthouse.objects;

import br.ufc.crateus.smarthouse.objects.interfaces.ObjectsInterface;

public class LightBulb implements ObjectsInterface {

	public void run(String action) {
		if (action.equals("activate")) {
			System.out.println("activating lamp");
		}
	}

}

package br.ufc.crateus.smarthouse.objects;

import br.ufc.crateus.smarthouse.objects.interfaces.ObjectsInterface;

public class DigitalLock implements ObjectsInterface {

	public void run(String action) {

		if (action.equals("arrived")) {
			System.out.println("unlocking lock");
		}
		if (action.equals("exited")) {
			System.out.println("locking lock");
		}
	}

}

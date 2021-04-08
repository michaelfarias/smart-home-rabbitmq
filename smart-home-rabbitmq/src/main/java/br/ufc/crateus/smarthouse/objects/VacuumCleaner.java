package br.ufc.crateus.smarthouse.objects;

import br.ufc.crateus.smarthouse.objects.interfaces.ObjectsInterface;

public class VacuumCleaner implements ObjectsInterface {

	public void run(String action) {
		if (action.equals("turns on")) {
			System.out.println("turning on vacuum cleaner");
		}
		if (action.equals("turns off")) {
			System.out.println("turning off vacuum cleaner");
		}
	}
}

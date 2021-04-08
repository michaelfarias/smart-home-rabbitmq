package br.ufc.crateus.smarthouse.objects;

import br.ufc.crateus.smarthouse.objects.interfaces.ObjectsInterface;

public class AirConditioning implements ObjectsInterface {

	public void run(String action) {

		if (action.equals("ative")) {
			System.out.println("turning on air conditioning");
		}
		if (action.equals("desative")) {
			System.out.println("turning off air conditioning");
		}

	}
}

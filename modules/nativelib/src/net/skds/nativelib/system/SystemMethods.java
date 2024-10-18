package net.skds.nativelib.system;

import java.util.Arrays;

@SuppressWarnings("unused")
public interface SystemMethods {
	static SystemMethods getInstance() {
		return SystemSecrets.sysSup.get();
	}

	void getMousePosition(double[] pos);


	public static void main(String[] args) {
		double[] pos = new double[2];
		getInstance().getMousePosition(pos);
		System.out.println(Arrays.toString(pos));
	}
}

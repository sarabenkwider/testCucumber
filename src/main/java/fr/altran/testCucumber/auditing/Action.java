package fr.altran.testCucumber.auditing;

public enum Action {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	INSERTED("INSERTED"), UPDATED("UPDATED"), DELETED("DELETED");

	private String name;

	private Action(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}
}

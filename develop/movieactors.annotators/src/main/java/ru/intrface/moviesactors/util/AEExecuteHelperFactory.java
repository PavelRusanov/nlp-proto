package ru.intrface.moviesactors.util;

public abstract class AEExecuteHelperFactory<T extends IAeExecuteHelper> {
	public abstract T getAEHelper();
}

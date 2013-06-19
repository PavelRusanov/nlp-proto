package ru.intrface.movieactors.annotators;

import javax.naming.NamingException;

import ru.intrface.moviesactors.util.AEExecuteHelperFactory;

public class BasicAEExHelperFactory extends AEExecuteHelperFactory<BasicAEExecuteHelper> {
	
	
	@Override
	public BasicAEExecuteHelper getAEHelper() {
		BasicAEExecuteHelper helper= new BasicAEExecuteHelper();
		try {
			helper.init();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return helper;
	}


}

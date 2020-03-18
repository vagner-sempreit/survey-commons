package br.com.cielo.desafio.surveycommons.util;

public class Paginations {

	public static final int FIRST_PAGE = 0;

	private static final long ZERO = 0;
	
	public static long numberOfPages(long quantity, long batchSize) {
		if(quantity <= ZERO || batchSize <= ZERO) {
			return ZERO;
		}
		
		long pages = quantity / batchSize;
		
		if((quantity % batchSize) > ZERO) {
			pages++;
		}
		
		return pages;
	}
}
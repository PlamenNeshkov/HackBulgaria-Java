package _1.monday;

import java.util.ArrayList;
import java.util.List;

public class VatTaxCalculator {
	private List<Integer> _countryIds;
	private List<CountryVatTax> _countries;
	private int _defaultIndex;
	
	public VatTaxCalculator(List<CountryVatTax> countries) {
		try {
			_countryIds = new ArrayList<>();
			int defaultCount = 0;
			
			for (int i = 0; i < countries.size(); i++) {
				CountryVatTax country = countries.get(i);
				
				if (country.isDefault()) {
					if (_countryIds.contains(country.getId())) {
						throw new DuplicateCountryIdException();
					}
					_countryIds.add(country.getId());
					
					defaultCount++;
					_defaultIndex = i;
				}
			}
			
			if (defaultCount != 1) {
				throw new NotSingleDefaultCountryException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		_countries = new ArrayList<CountryVatTax>(countries);
	}
	
	public double CalculateTax(double price, int countryId) {
		int index = _countryIds.indexOf(countryId);
		try {
			if (index == -1) {
				throw new CountryNotSupportedException();
			}
		} catch (CountryNotSupportedException e) {
			e.printStackTrace();
		}
		
		double vatTax = _countries.get(index).getVatTax();
		
		return price + (price * vatTax);
	}
	
	public double CalculateTax(double price) {
		return CalculateTax(price, _defaultIndex);
	}
	
}

@SuppressWarnings("serial")
class NotSingleDefaultCountryException extends Exception {
	public NotSingleDefaultCountryException() {}
	
	public NotSingleDefaultCountryException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class DuplicateCountryIdException extends Exception {
	public DuplicateCountryIdException() {}
	
	public DuplicateCountryIdException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class CountryNotSupportedException extends Exception {
	public CountryNotSupportedException() {}
	
	public CountryNotSupportedException(String message) {
		super(message);
	}
}
package _1.monday;

public class CountryVatTax {
	private final int _countryId;
	private final double _vatTax;
	private final boolean _isDefault;
	
	public CountryVatTax(int countryId, double vatTax, boolean isDefault) {
		_countryId = countryId;
		_vatTax = vatTax;
		_isDefault = isDefault;
	}

	public int getId() {
		return _countryId;
	}
	
	public double getVatTax() {
		return _vatTax;
	}
	
	public boolean isDefault() {
		return _isDefault;
	}
}

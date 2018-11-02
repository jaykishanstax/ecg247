package com.ecg.web.ecgonline.enumerator;

public enum BrandModels {
	BAJAJ("Bajaj"), HONDA("Honda"), HERO("Hero"), MAHINDRA("Mahindra"), SUZUKI("Suzuki"),VESPA("Vespa"), TVS("Tvs"), YAMAHA("Yamaha"), KTM("Ktm"), ROYAL_ENFIELD("Royal Enfield");
    private String brandName;

    public String getBrandName() {
		return brandName;
	}

    BrandModels(String brandName) {
        this.brandName = brandName;
    }

    public static BrandModels valueFromName(String brandName) {
    	for(BrandModels brand : BrandModels.values())
        {
      	  if(brand.getBrandName().equals(brandName))
      		  return brand;
        }
        return null;
    }

    public String toString() {
        return this.brandName;
    }

}
